package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/17.
 */
public class _89_First_Missing_Positive extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an unsorted integer array, find the first missing positive integer.\n" +
                "For example,\n" +
                "Given [1,2,0] return 3,\n" +
                "and [3,4,-1,1] return 2.\n" +
                "Your algorithm should run in O(n) time and uses constant space.";
    }

    @Override
    public void run() {
        Solution solution = new Solution();
        print(solution.firstMissingPositive(new int[]{100, 99, 1}));
        print(solution.firstMissingPositive(new int[]{100, 99}));
        print(solution.firstMissingPositive(new int[]{9, -1, 2, 2, 2, 3, 4, 5, 6, 7}));
        print(solution.firstMissingPositive(new int[]{-1, 8, 234, 10, 3, 4, 5, 6, 7}));
        print(solution.firstMissingPositive(new int[]{3, 4, 5, 6, 7}));
    }

    public class Solution {
        public int firstMissingPositive(int[] A) {
            if (A == null || A.length == 0) {
                return 1;
            }
            int i = 0;
            while (i < A.length) {
                if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                } else {
                    i++;
                }
            }
            for (i = 0; i < A.length; i++) {
                if (A[i] != i + 1) {
                    break;
                }
            }
            return i + 1;
        }
    }

    public class Solution1 {
        public int firstMissingPositive(int[] A) {
            int i = 0;
            while (i < A.length) {
                if (A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                    int tmp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = tmp;
                } else {
                    i++;
                }
            }
            for (i = 0; i < A.length; i++) {
                if (A[i] != i + 1)
                    return i + 1;
            }
            return A.length + 1;
        }
    }
}
