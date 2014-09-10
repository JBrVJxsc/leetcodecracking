package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _21_Gas_Station extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "There are N gas stations along a circular route, where the amount of gas at station i is gas[i].\n" +
                "You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next\n" +
                "station (i+1). You begin the journey with an empty tank at one of the gas stations.\n" +
                "Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.\n" +
                "Note: The solution is guaranteed to be unique.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int total = 0;
            int index = -1;
            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if (sum < 0) {
                    index = i;
                    sum = 0;
                }
            }
            return total >= 0 ? index + 1 : -1;
        }

        public int canCompleteCircuit1(int[] gas, int[] cost) {
            int index = -1;
            int total = 0;
            int sum = 0;
            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if (sum < 0) {
                    index = i;
                    sum = 0;
                }
            }
            return total >= 0 ? index + 1 : -1;
        }

        public int canCompleteCircuit2(int[] gas, int[] cost) {
            int index = -1;
            int total = 0;
            int sum = 0;
            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if (sum < 0) {
                    index = i;
                    sum = 0;
                }
            }
            return total >= 0 ? index + 1 : -1;
        }
    }
}
