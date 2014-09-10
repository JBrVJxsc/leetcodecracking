package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _42_Add_Binary extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given two binary strings, return their sum (also a binary string).\n" +
                "For example,\n" +
                "a = \"11\"\n" +
                "b = \"1\"\n" +
                "Return \"100\".";
    }

    @Override
    public void run() {
        String s1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String s2 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        s1 = "0";
        s2 = "0";
        print(s1);
        print(s2);
        print(new Solution().addBinary(s1, s2));
    }

    // A better solution of mine.
    public class Solution {
        public String addBinary(String a, String b) {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            int num = 0;
            int counter = 0;
            int maxLen = aChars.length > bChars.length ? aChars.length : bChars.length;
            StringBuffer stringBuffer = new StringBuffer();
            do {
                int aNum = aChars.length - 1 - counter < 0 ? 0 : aChars[aChars.length - 1 - counter] - '0';
                int bNum = bChars.length - 1 - counter < 0 ? 0 : bChars[bChars.length - 1 - counter] - '0';
                num += aNum + bNum;
                stringBuffer.insert(0, num % 2);
                num /= 2;
                counter++;
            } while (num != 0 || counter < maxLen);
            return stringBuffer.toString();
        }
    }

    // My first solution. Too much codes.
    public class Solution1 {
        public String addBinary(String a, String b) {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            int aLen = aChars.length;
            int bLen = bChars.length;
            int[] nums;
            char[] larger = aChars;
            char[] smaller = bChars;
            if (aLen < bLen) {
                larger = bChars;
                smaller = aChars;
            }
            nums = new int[larger.length];
            for (int i = 0; i < smaller.length; i++)
                nums[nums.length - 1 - i] = smaller[smaller.length - 1 - i] - '0';
            for (int i = 0; i < larger.length; i++)
                nums[i] += larger[i] - '0';

            StringBuffer stringBuffer = new StringBuffer("0");
            for (int i = 0; i < nums.length - 1; i++) {
                int n = nums[nums.length - 1 - i];
                stringBuffer.insert(1, n % 2);
                nums[nums.length - 1 - i - 1] += n / 2;
            }
            int num = nums[0];
            while (num != 0) {
                stringBuffer.insert(1, num % 2);
                num /= 2;
            }
            if (stringBuffer.length() > 1)
                return stringBuffer.substring(1);
            return stringBuffer.toString();
        }
    }
}
