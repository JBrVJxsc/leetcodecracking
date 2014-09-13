package com.leetcode.onlinejudge.problems._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Xu on 9/10/14.
 */
public class _3_Search_in_Rotated_Sorted_Array extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public String getSummary() {
        return "Suppose a sorted array is rotated at some pivot unknown to you beforehand.\n" +
                "(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).\n" +
                "You are given a target value to search. If found in the array return its index, otherwise return -1.\n" +
                "You may assume no duplicate exists in the array.";
    }

    @Override
    public void run() {
        int[] ints = new int[]{3, 1};
        print(new Solution().search(ints, 1));
    }

    public class Solution {
        public int search(int[] A, int target) {
            return binarySearch(A, 0, A.length - 1, target);
        }

        private int binarySearch(int[] A, int start, int end, int target) {
            if (start > end) {
                return -1;
            }
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                return middle;
            }
            // Find the correct sequence.
            if (A[start] <= A[middle]) {
                if (A[start] <= target && target < A[middle]) {
                    return binarySearch(A, start, middle - 1, target);
                } else {
                    return binarySearch(A, middle + 1, end, target);
                }
            } else {
                if (A[middle] < target && target <= A[end]) {
                    return binarySearch(A, middle + 1, end, target);
                } else {
                    return binarySearch(A, start, middle - 1, target);
                }
            }
        }
    }
}
