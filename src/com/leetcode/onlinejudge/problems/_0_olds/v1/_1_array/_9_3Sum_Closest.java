package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/7/25.
 */
public class _9_3Sum_Closest extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array S of n integers, find three integers in S such that the sum is closest to a given number,\n" +
                "target. Return the sum of the three integers. You may assume that each input would have exactly one solution.\n" +
                "For example, given array S = {-1 2 1 -4}, and target = 1.\n" +
                "The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).";
    }

    @Override
    public void run() {
        int[] a = new int[]{-1, 2, 1, -4};
        print(new Solution().threeSumClosest(a, 1));
    }

    public class Solution {
        public int threeSumClosest(int[] num, int target) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                int start = i + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) return sum;
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    if (sum <= target) start++;
                    else end--;
                }
            }
            return result;
        }

        public int threeSumClosest1(int[] num, int target) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                int start = i + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) return sum;
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    if (sum <= target) start++;
                    else end--;
                }
            }
            return result;
        }

        public int threeSumClosest2(int[] num, int target) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                int start = i + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) return sum;
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    if (sum <= target) start++;
                    else end--;
                }
            }
            return result;
        }

        public int threeSumClosest3(int[] num, int target) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                int start = i + 1;
                int end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) return sum;
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    if (sum <= target) start++;
                    else end--;
                }
            }
            return result;
        }
    }
}
