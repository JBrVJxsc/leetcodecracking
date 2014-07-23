package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/23.
 */
public class _3_Search_in_Rotated_Sorted_Array extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Suppose a sorted array is rotated at some pivot unknown to you beforehand.\n" +
                "(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).\n" +
                "You are given a target value to search. If found in the array return its index, otherwise return -1.\n" +
                "You may assume no duplicate exists in the array.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int search(int[] A, int target) {
            return 0;
        }
    }
}
