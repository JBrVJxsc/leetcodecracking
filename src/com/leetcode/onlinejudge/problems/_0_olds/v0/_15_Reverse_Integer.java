package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class _15_Reverse_Integer extends BaseProblem implements IProblem {

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
        return "Reverse digits of an integer.\n" +
                "Example1: x = 123, return 321\n" +
                "Example2: x = -123, return -321\n" +
                "Have you thought about this?\n" +
                "Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!\n" +
                "If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.\n" +
                "Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?\n" +
                "Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).";
    }

    @Override
    public void run() {
        print(23 / 10);
        print(new Solution().reverse(123));
        print(new Solution().reverse(-123));
        print(new Solution().reverse(10));
        print(new Solution().reverse(100));
    }

    public class Solution {

        private int getLength(int x) {
            int length = 1;
            int divisor = 10;
            while (x % divisor != x) {
                length++;
                divisor *= 10;
            }
            return length;
        }

        public int reverse(int x) {
            int reversed = 0;
            int length = getLength(x);
            if (length == 1) {
                return x;
            }
            for (int i = 0; i < length; i++) {
                reversed += (int) (x % Math.pow(10, i + 1) / Math.pow(10, i)) * Math.pow(10, length - i - 1);
            }
            return reversed;
        }
    }
}
