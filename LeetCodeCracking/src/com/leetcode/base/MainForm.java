package com.leetcode.base;

import com.leetcode.common.Reflection;
import com.leetcode.interfaces.IAlgorithm;
import com.leetcode.listeners.PrintConsoleListener;
import com.leetcode.listeners.SetParameterListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JComboBox cmbAlgorithms;
    private JButton btRun;
    private JTextArea txtConsole;
    private JScrollPane pnlScroll;

    private IAlgorithm currentAlgorithm = null;
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
        initAlgorithms();
    }

    private void initForm() {
        frame = new JFrame("Algorithms") {
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
    }

    private void initAlgorithms() {
        List<Object> algorithmList = null;
        try {
            algorithmList = Reflection.getInstancesByInterface(Class.forName("com.leetcode.interfaces.IAlgorithm"), "com.leetcode");
        } catch (ClassNotFoundException e) {
        }
        Collections.sort(algorithmList, new AlgorithmsComparator());
        for (int i = algorithmList.size() - 1; i >= 0; i--) {
            IAlgorithm algorithm = (IAlgorithm) algorithmList.get(i);
            cmbAlgorithms.addItem(algorithm);
        }
    }

    private void initListener() {
        cmbAlgorithms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAlgorithm = (IAlgorithm) cmbAlgorithms.getSelectedItem();
                resetConsole(currentAlgorithm);
            }
        });

        btRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (btRun.getText() == "Run") {
                    resetConsole(currentAlgorithm);
                    consoleWorker = null;
                    consoleWorker = new ConsoleWorker(frame);
                    startTime = System.currentTimeMillis();
                    running = true;
                    consoleWorker.start();
                } else {
                    printConsole("\n\nAlgorithm has stopped manually.");
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
            }
        });
    }

    private void resetConsole(IAlgorithm algorithm) {
        txtConsole.setText(null);
        txtConsole.append("Source code: " + algorithm.getClass().getName() + "\n");
        if (algorithm.getSummary() == null) {
            txtConsole.append("Summary: " + algorithm.getName() + "\n");
        } else {
            txtConsole.append("Summary: " + algorithm.getSummary() + "\n");
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
            currentAlgorithm.addPrintConsoleListener(new PrintConsoleListener() {
                @Override
                public void print(String string) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    eventQueue.postEvent(new ConsoleAWTEvent(component, string));
                }
            });
            currentAlgorithm.addSetParameterListener(new SetParameterListener() {
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
                currentAlgorithm.run();
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

    class AlgorithmsComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (((IAlgorithm) o1).getID() > ((IAlgorithm) o2).getID()) {
                return 1;
            }
            return -1;
        }
    }
}