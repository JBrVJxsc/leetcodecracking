package com.leetcode.onlinejudge.problems._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/8.
 */
public class _44_Regular_Expression_Matching extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Implement regular expression matching with support for '.' and '*'.\n" +
                "'.' Matches any single character.\n" +
                "'*' Matches zero or more of the preceding element.\n" +
                "The matching should cover the entire input string (not partial).\n" +
                "The function prototype should be:\n" +
                "bool isMatch(const char *s, const char *p)\n" +
                "Some examples:\n" +
                "isMatch(\"aa\",\"a\") → false\n" +
                "isMatch(\"aa\",\"aa\") → true\n" +
                "isMatch(\"aaa\",\"aa\") → false\n" +
                "isMatch(\"aa\", \"a*\") → true\n" +
                "isMatch(\"aa\", \".*\") → true\n" +
                "isMatch(\"ab\", \".*\") → true\n" +
                "isMatch(\"aab\", \"c*a*b\") → true";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean isMatch(String s, String p) {
            if (s.equals(p)) {
                return true;
            }

            return true;
        }
    }
}
