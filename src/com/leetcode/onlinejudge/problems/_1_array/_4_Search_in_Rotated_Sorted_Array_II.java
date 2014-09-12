package com.leetcode.onlinejudge.problems._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Xu on 9/12/14.
 */
public class _4_Search_in_Rotated_Sorted_Array_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public String getSummary() {
        return "Follow up for \"Search in Rotated Sorted Array\":\n" +
                "What if duplicates are allowed?\n" +
                "Would this affect the run-time complexity? How and why?\n" +
                "Write a function to determine if a given target is in the array.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean search(int[] A, int target) {
            return binarySearch(A, 0, A.length - 1, target);
        }

        private boolean binarySearch(int[] A, int start, int end, int target) {
            if (start > end) {
                return false;
            }
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                return true;
            }

            return true;
        }
    }
}
