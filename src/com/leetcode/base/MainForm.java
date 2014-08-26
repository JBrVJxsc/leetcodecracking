package com.leetcode.base;

import com.leetcode.common.Reflection;
import com.leetcode.interfaces.IProblem;
import com.leetcode.listeners.PrintConsoleListener;
import com.leetcode.listeners.SetParameterListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Who on 2014/4/4.
 */
public class MainForm {
    private JFrame frame;
    private JPanel pnlMain;
    private JPanel pnlTop;
    private JComboBox cmbProblems;
    private JButton btRun;
    private JTextArea txtConsole;
    private JScrollPane pnlScroll;

    private IProblem currentProblem = null;
    private ConsoleWorker consoleWorker = null;
    private boolean running = false;
    private long startTime = 0l;
    private long endTime = 0l;
    private List<Parameter> parameterList = null;
    private long parameterSettingTime = 0l;

    public MainForm() {
    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.init();
    }

    private void init() {
        initForm();
        initListener();
        initProblems();
    }

    private void initForm() {
        frame = new JFrame("LeetCode") {
            public JFrame init() {
                enableEvents(ConsoleAWTEvent.EVENT_ID);
                return this;
            }

            @Override
            protected void processEvent(AWTEvent paramAWTEvent) {
                if ((paramAWTEvent instanceof ConsoleAWTEvent)) {
                    ConsoleAWTEvent consoleAWTEvent = (ConsoleAWTEvent) paramAWTEvent;
                    printConsole(consoleAWTEvent.getString());
                } else {
                    super.processEvent(paramAWTEvent);
                }
            }
        }.init();
        frame.setContentPane(this.pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        toolkit.addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    KeyEvent evt = (KeyEvent) e;
                    if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        frame.dispose();
                        System.exit(0);
                    }
                }
            }
        }, AWTEvent.KEY_EVENT_MASK);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }

        txtConsole.setBackground(Color.black);
        txtConsole.setForeground(Color.green);
        txtConsole.setCaretColor(Color.green);
        btRun.setEnabled(false);
    }

    private void initProblems() {
        List<Object> problemList = null;
        try {
            problemList = Reflection.getInstancesByInterface(Class.forName("com.leetcode.interfaces.IProblem"), "com.leetcode");
        } catch (ClassNotFoundException e) {
        }
        Collections.sort(problemList, new ProblemsComparator());
        for (int i = problemList.size() - 1; i >= 0; i--) {
            IProblem problem = (IProblem) problemList.get(i);
            if (problem.isValid() && problem.getVersion() == Setting.DisplayedVersion) {
                cmbProblems.addItem(problem);
            }
        }
        btRun.setEnabled(true);
        run();
    }

    private void initListener() {
        cmbProblems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentProblem = (IProblem) cmbProblems.getSelectedItem();
                resetConsole(currentProblem);
            }
        });

        btRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (btRun.getText() == "Run") {
                    run();
                } else {
                    stop();
                }
            }
        });
    }

    private void run() {
        if (currentProblem == null) {
            return;
        }
        resetConsole(currentProblem);
        consoleWorker = null;
        consoleWorker = new ConsoleWorker(frame);
        startTime = System.currentTimeMillis();
        running = true;
        consoleWorker.start();
    }

    private void stop() {
        printConsole("\n\nProblem has stopped manually.");
        bottomConsole();
        endTime = System.currentTimeMillis();
        String parameterInfo = "";
        for (Parameter parameter : parameterList) {
            parameterInfo += "\n" + parameter.getName() + ": " + parameter.getValue().toString();
        }
        if (parameterInfo != "") {
            parameterInfo = "\n\nParameters:" + parameterInfo;
            printConsole(parameterInfo);
        }
        printConsole("\n\nTotal running time: " + String.valueOf(getRunTime()) + " ms.");
        running = false;
        consoleWorker.stop();
        consoleWorker = null;
        btRun.setText("Run");
    }

    private void resetConsole(IProblem problem) {
        txtConsole.setText(null);
        txtConsole.append("Source code: " + problem.getClass().getName() + "\n");
        if (problem.getSummary() == null) {
            txtConsole.append("\n" + problem.getName() + "\n");
        } else {
            txtConsole.append("\n" + problem.getSummary() + "\n");
        }

        if (problem.getNote() != null) {
            txtConsole.append("\nNote:\n" + problem.getNote() + "\n");
        }
    }

    private void printConsole(String string) {
        if (running) {
            txtConsole.append(string);
        }
    }

    private void bottomConsole() {
        txtConsole.setCaretPosition(txtConsole.getText().length());
    }

    private long getRunTime() {
        return endTime - startTime - parameterSettingTime;
    }

    public String getExceptionMessage(Exception e) {
        StringBuffer stringBuffer = new StringBuffer("null");
        if (e != null) {
            stringBuffer = new StringBuffer("");
            String message = e.toString();
            int length = e.getStackTrace().length;
            if (length > 0) {
                stringBuffer.append(message + "\n");
                for (int i = 0; i < length; i++) {
                    stringBuffer.append("\t at " + e.getStackTrace()[i]);
                    if (i != length - 1) {
                        stringBuffer.append("\n");
                    }
                }
            } else {
                stringBuffer.append(message);
            }
        }
        return stringBuffer.toString();
    }

    class ConsoleAWTEvent extends AWTEvent {
        public static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
        private String string = null;

        ConsoleAWTEvent(Object object, String string) {
            super(object, EVENT_ID);
            this.string = string;
        }

        public String getString() {
            return this.string;
        }
    }

    class ConsoleWorker extends Thread {
        private EventQueue eventQueue = null;
        private Component component = null;

        ConsoleWorker(Component paramComponent) {
            component = paramComponent;
        }

        public void run() {
            parameterList = new ArrayList<Parameter>();
            parameterSettingTime = 0l;
            eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
            currentProblem.addPrintConsoleListener(new PrintConsoleListener() {
                @Override
                public void print(String string) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    eventQueue.postEvent(new ConsoleAWTEvent(component, string));
                }
            });
            currentProblem.addSetParameterListener(new SetParameterListener() {
                @Override
                public void set(Parameter... parameters) {
                    for (Parameter parameter : parameters) {
                        ParameterDialog parameterDialog = new ParameterDialog(parameter);
                        parameterDialog.pack();
                        parameterDialog.setLocationRelativeTo(component);
                        long parameterSettingStart = System.currentTimeMillis();
                        parameterDialog.setVisible(true);
                        long parameterSettingEnd = System.currentTimeMillis();
                        parameterSettingTime += parameterSettingEnd - parameterSettingStart;
                        if (!parameterList.contains(parameter)) {
                            parameterList.add(parameter);
                        }
                    }
                }
            });
            btRun.setText("Stop");
            try {
                currentProblem.run();
            } catch (Exception e) {
                printConsole("\n\nException:\n" + getExceptionMessage(e));
            }
            endTime = System.currentTimeMillis();
            String parameterInfo = "";
            for (Parameter parameter : parameterList) {
                parameterInfo += "\n" + parameter.getName() + ": " + parameter.getValue().toString();
            }
            if (parameterInfo != "") {
                parameterInfo = "\n\nParameters:" + parameterInfo;
                eventQueue.postEvent(new ConsoleAWTEvent(component, parameterInfo));
            }
            eventQueue.postEvent(new ConsoleAWTEvent(component, "\n\nTotal running time: " + String.valueOf(getRunTime()) + " ms."));
            btRun.setText("Run");
            bottomConsole();
        }
    }

    class ProblemsComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (((IProblem) o1).getID() > ((IProblem) o2).getID()) {
                return 1;
            }
            return -1;
        }
    }
}