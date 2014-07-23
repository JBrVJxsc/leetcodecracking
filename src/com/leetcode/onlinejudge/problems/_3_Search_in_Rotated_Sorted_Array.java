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
        int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
        a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(new Solution().search(a, 9));
    }

    public class Solution {
        public int search(int[] A, int target) {
            return find(A, 0, A.length - 1, target);
        }

        private int find(int[] A, int start, int end, int target) {
            if (end < start) return -1;
            int middle = start + (end - start) / 2;
            if (A[middle] == target) return middle;
            else if (target < A[middle])
                return find(A, start, middle - 1, target);
            else
                return find(A, middle + 1, end, target);
        }
    }
}
