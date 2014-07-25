package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/25.
 */
public class _12_Next_Permutation extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.\n" +
                "If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).\n" +
                "The replacement must be in-place, do not allocate extra memory.\n" +
                "Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.\n" +
                "1,2,3 → 1,3,2\n" +
                "3,2,1 → 1,2,3\n" +
                "1,1,5 → 1,5,1";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public void nextPermutation(int[] num) {

        }
    }
}
