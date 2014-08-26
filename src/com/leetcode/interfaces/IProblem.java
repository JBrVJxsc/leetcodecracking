package com.leetcode.interfaces;

import com.leetcode.listeners.PrintConsoleListener;
import com.leetcode.listeners.SetParameterListener;

/**
 * Created by Who on 2014/4/4.
 */
public interface IProblem {

    int getVersion();

    boolean isValid();

    long getID();

    String getName();

    String getSummary();

    String getNote();

    void run();

    void addPrintConsoleListener(PrintConsoleListener printConsoleListener);

    void addSetParameterListener(SetParameterListener setParameterListener);
}
