package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/7/26.
 */
public class _15_Trapping_Rain_Water extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.\n" +
                "For example, \n" +
                "Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.";
    }

    @Override
    public void run() {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        print(new Solution().trap(a));
    }

    public class Solution {
        public int trap(int[] A) {
            if (A == null || A.length == 0) return 0;
            int total = 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int leftMax = left[0] = A[0];
            int rightMax = right[A.length - 1] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                leftMax = Math.max(leftMax, A[i]);
                left[i] = leftMax;
                rightMax = Math.max(rightMax, A[A.length - 1 - i]);
                right[A.length - 1 - i] = rightMax;
            }
            for (int i = 0; i < A.length; i++)
                total += Math.min(left[i], right[i]) - A[i];
            return total;
        }

        public int trap1(int[] A) {
            if (A == null || A.length == 0) return 0;
            int total = 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int leftMax = left[0] = A[0];
            int rightMax = right[A.length - 1] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                leftMax = Math.max(leftMax, A[i]);
                left[i] = leftMax;
                rightMax = Math.max(rightMax, A[A.length - 1 - i]);
                right[A.length - 1 - i] = rightMax;
            }
            for (int i = 0; i < A.length; i++) {
                total += Math.min(left[i], right[i]) - A[i];
            }
            return total;
        }

        public int trap2(int[] A) {
            int total = 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int leftMax = left[0] = A[0];
            int rightMax = right[A.length - 1] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                leftMax = Math.max(leftMax, A[i]);
                left[i] = leftMax;
                rightMax = Math.max(rightMax, A[A.length - 1 - i]);
                right[A.length - 1 - i] = rightMax;
            }
            for (int i = 0; i < A.length; i++) {
                total += Math.min(left[i], right[i]) - A[i];
            }
            return total;
        }

        public int trap3(int[] A) {
            if (A == null || A.length == 0) return 0;
            int total = 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int leftMax = left[0] = A[0];
            int rightMax = right[A.length - 1] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                leftMax = Math.max(leftMax, A[i]);
                left[i] = leftMax;
                rightMax = Math.max(rightMax, A[A.length - 1 - i]);
                right[A.length - 1 - i] = rightMax;
            }
            for (int i = 0; i < A.length; i++) {
                total += Math.min(left[i], right[i]) - A[i];
            }
            return total;
        }

        public int trap4(int[] A) {
            if (A == null || A.length == 0) return 0;
            int total = 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int leftMax = left[0] = A[0];
            int rightMax = right[A.length - 1] = A[A.length - 1];
            for (int i = 1; i < A.length; i++) {
                leftMax = Math.max(leftMax, A[i]);
                left[i] = leftMax;
                rightMax = Math.max(rightMax, A[A.length - 1 - i]);
                right[A.length - 1 - i] = rightMax;
            }
            for (int i = 0; i < A.length; i++)
                total += Math.min(left[i], right[i]) - A[i];
            return total;
        }
    }

    // Got TLE.
    public class Solution1 {
        public int trap(int[] A) {
            int[] copy = Arrays.copyOf(A, A.length);
            Arrays.sort(copy);
            int total = 0;
            for (int i = 0; i < copy.length; i++) {
                if (i == 0 || copy[i] != copy[i - 1]) {
                    int flag = copy[i];
                    int counter = 0;
                    boolean start = false;
                    for (int j = 0; j < A.length; j++)
                        if (A[j] >= flag) {
                            start = true;
                            total += counter;
                            counter = 0;
                        } else if (start) counter++;
                }
            }
            return total;
        }
    }
}
