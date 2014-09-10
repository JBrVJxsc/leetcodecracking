package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/27.
 */
public class _17_Plus_One extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a non-negative number represented as an array of digits, plus one to the number.\n" +
                "The digits are stored such that the most significant digit is at the head of the list.";
    }

    @Override
    public void run() {
        int[] ints = new int[]{9};
        print(new Solution().plusOne(ints));
    }

    public class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0) return new int[0];
            if (addOne(digits, digits.length - 1)) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                System.arraycopy(digits, 0, result, 1, digits.length);
                return result;
            }
            return digits;
        }

        private boolean addOne(int[] digits, int index) {
            if (index < 0) return true;
            int i = digits[index] + 1;
            if (i >= 10) {
                digits[index] = i - 10;
                return addOne(digits, --index);
            } else digits[index] = i;
            return false;
        }
    }
}
