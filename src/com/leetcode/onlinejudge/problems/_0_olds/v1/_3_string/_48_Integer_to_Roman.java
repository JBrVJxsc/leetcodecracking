package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/9.
 */
public class _48_Integer_to_Roman extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an integer, convert it to a roman numeral.\n" +
                "Input is guaranteed to be within the range from 1 to 3999.";
    }

    @Override
    public void run() {
        print(new Solution().intToRoman(4));
    }

    public class Solution {
        public String intToRoman(int num) {
            StringBuffer stringBuffer = new StringBuffer();
            char[] dicHundred = new char[]{'C', 'D', 'M'};
            char[] dicTen = new char[]{'X', 'L', 'C'};
            char[] dicNum = new char[]{'I', 'V', 'X'};
            int thousand = num / 1000;
            num %= 1000;
            int hundred = num / 100;
            num %= 100;
            int ten = num / 10;
            num %= 10;
            for (int i = 0; i < thousand; i++) {
                stringBuffer.append("M");
            }
            convert(hundred, stringBuffer, dicHundred);
            convert(ten, stringBuffer, dicTen);
            convert(num, stringBuffer, dicNum);
            return stringBuffer.toString();
        }

        private void convert(int num, StringBuffer stringBuffer, char[] dic) {
            if (num <= 3) {
                for (int i = 0; i < num; i++) {
                    stringBuffer.append(dic[0]);
                }
            } else if (num == 4) {
                stringBuffer.append(dic[0]);
                stringBuffer.append(dic[1]);
            } else if (num == 5) {
                stringBuffer.append(dic[1]);
            } else if (5 < num && num < 9) {
                stringBuffer.append(dic[1]);
                for (int i = 0; i < num % 5; i++) {
                    stringBuffer.append(dic[0]);
                }
            } else {
                stringBuffer.append(dic[0]);
                stringBuffer.append(dic[2]);
            }
        }
    }
}
