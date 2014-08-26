package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/30.
 */
public class _20_Search_Insert_Position extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
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
        int[] A = new int[]{1, 3, 5, 6};
        print(new Solution().searchInsert(A, 5));
        print(new Solution().searchInsert(A, 2));
        print(new Solution().searchInsert(A, 7));
        print(new Solution().searchInsert(A, 0));
    }

    public class Solution {
        public int searchInsert(int[] A, int target) {
            if (A == null || A.length == 0) {
                return 0;
            }
            if (A.length == 1) {
                return (A[0] < target) ? 1 : 0;
            }
            if (A[0] >= target) {
                return 0;
            }
            if (A[A.length - 1] < target) {
                return A.length;
            } else if (A[A.length - 1] == target) {
                return A.length - 1;
            }
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] <= target && target <= A[i + 1]) {
                    if (A[i] == target) {
                        return i;
                    } else {
                        return i + 1;
                    }
                }
            }
            return 0;
        }
    }
}
