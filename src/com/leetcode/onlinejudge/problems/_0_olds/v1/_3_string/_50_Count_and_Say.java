package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/9.
 */
public class _50_Count_and_Say extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "The count-and-say sequence is the sequence of integers beginning as follows:\n" +
                "1, 11, 21, 1211, 111221, ...\n" +
                "1 is read off as \"one 1\" or 11.\n" +
                "11 is read off as \"two 1s\" or 21.\n" +
                "21 is read off as \"one 2, then one 1\" or 1211.\n" +
                "Given an integer n, generate the nth sequence.\n" +
                "Note: The sequence of integers will be represented as a string.";
    }

    @Override
    public void run() {
        print(new Solution().countAndSay(6));
    }

    public class Solution {
        public String countAndSay(int n) {
            String result = "1";
            for (int i = 1; i < n; i++) {
                result = gen(result);
            }
            return result;
        }

        private String gen(String str) {
            StringBuffer stringBuffer = new StringBuffer();
            char c = str.charAt(0);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != c) {
                    stringBuffer.append(count);
                    stringBuffer.append(c);
                    c = str.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
                if (i == str.length() - 1) {
                    stringBuffer.append(count);
                    stringBuffer.append(c);
                }
            }
            return stringBuffer.toString();
        }
    }
}
