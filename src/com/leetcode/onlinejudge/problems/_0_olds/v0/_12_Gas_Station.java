package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class _12_Gas_Station extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getName() {
        return "[UNSOLVED: TLE]Gas Station";
    }

    @Override
    public String getSummary() {
        return "There are N gas stations along a circular route, where the amount of gas at station i is gas[i].\n" +
                "You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.\n" +
                "Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.\n" +
                "Note:\n" +
                "The solution is guaranteed to be unique.";
    }

    @Override
    public void run() {
        int[] gas = new int[]{1, 2, 3, 3};
        int[] cost = new int[]{2, 1, 5, 1};
        print(new Solution().canCompleteCircuit(gas, cost));
    }

    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas.length == 1) {
                if (gas[0] >= cost[0]) {
                    return 0;
                } else {
                    return -1;
                }
            }
            int gasAmount = 0;
            for (int i = 0; i < gas.length; i++) {
                gasAmount = 0;
                for (int j = i; j < i + gas.length; j++) {
                    int index = (j < gas.length) ? j : j - gas.length;
                    gasAmount += gas[index];
                    gasAmount -= cost[index];
                    if (j == i + gas.length - 1) {
                        return i;
                    }
                    if (gasAmount < 0) {
                        break;
                    }
                }
            }
            return -1;
        }
    }
}
