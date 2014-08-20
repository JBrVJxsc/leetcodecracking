package com.leetcode.onlinejudge;

import com.leetcode.base.Parameter;
import com.leetcode.listeners.PrintConsoleListener;
import com.leetcode.listeners.SetParameterListener;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Who on 2014/4/10.
 */
public abstract class BaseProblem {

    private PrintConsoleListener printConsoleListener = new PrintConsoleListener();
    private SetParameterListener setParameterListener = new SetParameterListener();
    private Stack<Long> timer = new Stack<Long>();

    public boolean isValid() {
        return true;
    }

    public long getID() {
        String className = getClass().getSimpleName();
        return Long.parseLong(className.split("_")[1]);
    }

    public String getName() {
        String className = getClass().getSimpleName();
        int index = className.indexOf("_", 1);
        return className.substring(index + 1).replace("_", " ");
    }

    public String getNote() {
        return null;
    }

    public void addPrintConsoleListener(PrintConsoleListener printConsoleListener) {
        this.printConsoleListener = (PrintConsoleListener) printConsoleListener;
    }

    public void addSetParameterListener(SetParameterListener setParameterListener) {
        this.setParameterListener = (SetParameterListener) setParameterListener;
    }

    protected void show(Object message) {
        JOptionPane.showMessageDialog(null, message);
    }

    protected void show(Object message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    protected String print(List list) {
        String string = "";
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object == null) {
                string += "null" + ", ";
            } else {
                string += iterator.next().toString() + ", ";
            }
        }
        if (string.length() > 2) {
            string = string.substring(0, string.length() - 2);
        }
        return print(string);
    }

    protected String print(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            if (object == null) {
                string += "null" + ", ";
            } else {
                string += object.toString() + ", ";
            }
        }
        if (string.length() > 2) {
            string = string.substring(0, string.length() - 2);
        }
        return print(string);
    }

    protected String print(Object object) {
        if (object == null) {
            return print("null");
        }
        String string = object.toString();
        return print(string);
    }

    protected String print(double d) {
        return print(String.valueOf(d));
    }

    protected String print(double[] ds) {
        String string = "";
        for (double d : ds) {
            string += String.valueOf(d) + " ";
        }
        return print(string);
    }

    protected String print(Double d) {
        return print(String.valueOf(d));
    }

    protected String print(long l) {
        return print(String.valueOf(l));
    }

    protected String print(long[] ls) {
        String string = "";
        for (long l : ls) {
            string += String.valueOf(l) + " ";
        }
        return print(string);
    }

    protected String print(Long l) {
        return print(String.valueOf(l));
    }

    protected String print(int i) {
        return print(String.valueOf(i));
    }

    protected String print(int[] is) {
        String string = "";
        for (int i : is) {
            string += String.valueOf(i) + " ";
        }
        return print(string);
    }

    protected String print(int[] is, int start, int end) {
        String string = "";
        for (int i = start; i <= end; i++) {
            string += String.valueOf(is[i]) + " ";
        }
        return print(string);
    }

    protected String print(Integer i) {
        return print(String.valueOf(i));
    }

    protected String print(String string) {
        printConsoleListener.print("\n" + string);
        System.out.print("\n" + string);
        return string;
    }

    protected String print() {
        return print("");
    }

    protected void set(Parameter... parameters) {
        setParameterListener.set(parameters);
    }

    protected void timerOn() {
        timer.push(System.currentTimeMillis());
    }

    protected long timerOff() {
        return System.currentTimeMillis() - timer.pop();
    }

    @Override
    public String toString() {
        return getName();
    }
}
