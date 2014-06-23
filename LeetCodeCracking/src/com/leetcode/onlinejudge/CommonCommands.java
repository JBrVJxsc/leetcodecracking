package com.leetcode.onlinejudge;

import com.leetcode.base.Parameter;
import com.leetcode.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/17.
 */
public class CommonCommands extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return Long.MIN_VALUE;
    }

    @Override
    public String getName() {
        return "Common Commands";
    }

    @Override
    public String getSummary() {
        String summary = "0. Get current time in nanoseconds.";
        return summary;
    }

    @Override
    public void run() {
        Parameter<Integer> command = new Parameter<Integer>(0, "Command Index");
        set(command);
        switch (command.getValue()) {
            case 0: {
                print(System.currentTimeMillis());
            }
        }
    }
}
