package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/10.
 */
public class _53_Length_of_Last_Word extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.\n" +
                "If the last word does not exist, return 0.\n" +
                "Note: A word is defined as a character sequence consists of non-space characters only.\n" +
                "For example, \n" +
                "Given s = \"Hello World\",\n" +
                "return 5.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    start = i + 1;
                }
            }
            return s.length() - start;
        }
    }
}
