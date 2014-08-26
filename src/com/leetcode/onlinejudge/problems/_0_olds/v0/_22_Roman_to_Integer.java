package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/30.
 */
public class _22_Roman_to_Integer extends BaseProblem implements IProblem {

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
        return "Given a roman numeral, convert it to an integer.\n" +
                "Input is guaranteed to be within the range from 1 to 3999.";
    }

    @Override
    public void run() {
        print(new Solution().romanToInt("MMMCMXCIX"));
    }

    public class Solution {

        private int c(char roman) {
            switch (roman) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            return 0;
        }

        public int romanToInt(String s) {
            int number = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == chars.length - 1) {
                    number += c(chars[i]);
                    return number;
                }
                char next = chars[i + 1];
                if (chars[i] == 'I' && (next == 'V' || next == 'X') || chars[i] == 'X' && (next == 'L' || next == 'C') || chars[i] == 'C' && (next == 'D' || next == 'M')) {
                    number += c(next) - c(chars[i]);
                    i++;
                    continue;
                }
                number += c(chars[i]);
            }
            return number;
        }
    }
}
