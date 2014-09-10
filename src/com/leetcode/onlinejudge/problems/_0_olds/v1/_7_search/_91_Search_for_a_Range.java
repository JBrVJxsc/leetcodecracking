package com.leetcode.onlinejudge.problems._0_olds.v1._7_search;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/18.
 */
public class _91_Search_for_a_Range extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a sorted array of integers, find the starting and ending position of a given target value.\n" +
                "Your algorithm's runtime complexity must be in the order of O(log n).\n" +
                "If the target is not found in the array, return [-1, -1].\n" +
                "For example,\n" +
                "Given [5, 7, 7, 8, 8, 10] and target value 8,\n" +
                "return [3, 4].";
    }

    @Override
    public void run() {
        print(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public class Solution {

        private int low = -1;
        private int high = -1;

        public int[] searchRange(int[] A, int target) {
            search(A, 0, A.length - 1, target);
            return new int[]{low, high};
        }

        private void search(int[] A, int start, int end, int target) {
            if (start > end) {
                return;
            }
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                if (middle - 1 >= 0 && A[middle - 1] < target || middle == 0) {
                    low = middle;
                }
                if (middle + 1 <= A.length - 1 && A[middle + 1] > target || middle == A.length - 1) {
                    high = middle;
                }
            }
            if (low != -1 && high != -1) {
                return;
            }
            search(A, start, middle - 1, target);
            search(A, middle + 1, end, target);
        }
    }
}
