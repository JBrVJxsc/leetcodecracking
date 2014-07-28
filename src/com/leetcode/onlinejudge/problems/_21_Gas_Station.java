package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _21_Gas_Station extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "There are N gas stations along a circular route, where the amount of gas at station i is gas[i].\n" +
                "You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next\n" +
                "station (i+1). You begin the journey with an empty tank at one of the gas stations.\n" +
                "Return the starting gas station’s index if you can travel around the circuit once, otherwise return -1.\n" +
                "Note: The solution is guaranteed to be unique.";
    }

    @Override
    public void run() {

    }
}
