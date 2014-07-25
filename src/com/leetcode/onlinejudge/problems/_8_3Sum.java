package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Who on 2014/7/25.
 */
public class _8_3Sum extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.\n" +
                "Note:\n" +
                "Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)\n" +
                "The solution set must not contain duplicate triplets.\n" +
                "    For example, given array S = {-1 0 1 2 -1 -4},\n" +
                "    A solution set is:\n" +
                "    (-1, 0, 1)\n" +
                "    (-1, -1, 2)";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            return null;
        }
    }
}
