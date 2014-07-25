package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.List;

/**
 * Created by Who on 2014/7/25.
 */
public class _10_4Sum extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?\n" +
                "Find all unique quadruplets in the array which gives the sum of target.\n" +
                "Note:\n" +
                "• Elements in a quadruplet (a, b, c, d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)\n" +
                "• The solution set must not contain duplicate quadruplets.\n" +
                "For example, given array S = {1 0 -1 0 -2 2}, and target = 0.\n" +
                "A solution set is:\n" +
                "(-1, 0, 0, 1)\n" +
                "(-2, -1, 1, 2)\n" +
                "(-2, 0, 0, 2)";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<List<Integer>> fourSum(int[] num, int target) {
            return null;
        }
    }
}
