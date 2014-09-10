package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/9.
 */
public class _49_Roman_to_Integer extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a roman numeral, convert it to an integer.\n" +
                "Input is guaranteed to be within the range from 1 to 3999.";
    }

    @Override
    public void run() {
        print(new Solution().romanToInt("VI"));
        print(new Solution().romanToInt("IV"));
        print(new Solution().romanToInt("IIV"));
    }

    public class Solution {
        public int romanToInt(String s) {
            int num = 0;
            int index = s.length() - 1;
            while (index >= 0) {
                char c = s.charAt(index);
                if (index > 0 && convert(c) > convert(s.charAt(index - 1)) && "IXC".contains(String.valueOf(s.charAt(index - 1)))) {
                    num += convert(c) - convert(s.charAt(index - 1));
                    index -= 2;
                } else {
                    num += convert(c);
                    index--;
                }
            }
            return num;
        }

        public int convert(char c) {
            switch (c) {
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
    }
}
