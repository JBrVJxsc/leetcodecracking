package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _41_String_to_Integer_atoi extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Implement atoi to convert a string to an integer.\n" +
                "Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.\n" +
                "Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.\n" +
                "Requirements for atoi:\n" +
                "The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.\n" +
                "The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.\n" +
                "If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.\n" +
                "If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.";
    }

    @Override
    public void run() {
        print(new Solution().atoi("+431"));
    }

    public class Solution {
        public int atoi(String str) {
            if (str.trim().length() == 0)
                return 0;
            char[] chars = str.trim().toCharArray();
            int num = 0;
            int len = chars.length;
            int i = 0;
            int sign = 1;
            if (chars[0] == '+')
                i++;
            if (chars[0] == '-') {
                sign = -1;
                i++;
            }
            for (; i < len; i++) {
                if (chars[i] < '0' || chars[i] > '9')
                    break;
                if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && chars[i] - '0' > Integer.MAX_VALUE % 10)
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                num = num * 10 + chars[i] - '0';
            }
            return num * sign;
        }
    }
}
