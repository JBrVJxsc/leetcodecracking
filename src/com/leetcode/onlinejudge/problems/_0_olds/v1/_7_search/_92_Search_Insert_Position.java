package com.leetcode.onlinejudge.problems._0_olds.v1._7_search;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/18.
 */
public class _92_Search_Insert_Position extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.\n" +
                "You may assume no duplicates in the array.\n" +
                "Here are few examples.\n" +
                "[1,3,5,6], 5 → 2\n" +
                "[1,3,5,6], 2 → 1\n" +
                "[1,3,5,6], 7 → 4\n" +
                "[1,3,5,6], 0 → 0";
    }

    @Override
    public void run() {
        Solution solution = new Solution();
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    // A better one with O(logN) solution.
    public class Solution {
        int index = 0;

        public int searchInsert(int[] A, int target) {
            index = A.length;
            search(A, 0, A.length - 1, target);
            return index;
        }

        private void search(int[] A, int start, int end, int target) {
            if (start > end) {
                return;
            }
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                index = middle;
            } else if (A[middle] < target) {
                search(A, middle + 1, end, target);
            } else {
                index = Math.min(index, middle);
                search(A, start, middle - 1, target);
            }
        }
    }

    // O(n) solution.
    public class Solution1 {
        public int searchInsert(int[] A, int target) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= target) {
                    return i;
                }
            }
            return A.length;
        }
    }
}
