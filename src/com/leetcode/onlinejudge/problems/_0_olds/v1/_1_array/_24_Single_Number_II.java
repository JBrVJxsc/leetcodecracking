package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _24_Single_Number_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array of integers, every element appears three times except for one. Find that single one.\n" +
                "Note:\n" +
                "Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 1, 1, 2, 2, 2, 6};
        print(new Solution().singleNumber(a));
    }

    public class Solution {

        public int singleNumber(int[] A) {
            int target = 0;
            int[] bit = new int[32];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bit[j] += b & 1;
                }
            }
            for (int i = 0; i < 32; ++i) {
                target += (bit[i] % 3 << i);
            }
            return target;
        }

        public int singleNumber1(int[] A) {
            int target = 0;
            int[] bits = new int[32];
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bits[j] += b & 1;
                }
            for (int i = 0; i < 32; i++)
                target += bits[i] % 3 << i;
            return target;
        }

        public int singleNumber2(int[] A) {
            int target = 0;
            int[] bits = new int[32];
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bits[j] += b & 1;
                }
            for (int i = 0; i < 32; i++)
                target += bits[i] % 3 << i;
            return target;
        }

        public int singleNumber3(int[] A) {
            int target = 0;
            int[] bits = new int[32];
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bits[j] += b & 1;
                }
            for (int i = 0; i < 32; i++)
                target += bits[i] % 3 << i;
            return target;
        }

        public int singleNumber4(int[] A) {
            int target = 0;
            int[] bits = new int[32];
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bits[j] += b & 1;
                }
            for (int i = 0; i < 32; i++)
                target += bits[i] % 3 << i;
            return target;
        }

        public int singleNumber5(int[] A) {
            int target = 0;
            int[] bits = new int[32];
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < 32; j++) {
                    int b = A[i] >> j;
                    if (b == 0) break;
                    bits[j] += b & 1;
                }
            for (int i = 0; i < 32; i++)
                target += bits[i] % 3 << i;
            return target;
        }
    }
}
