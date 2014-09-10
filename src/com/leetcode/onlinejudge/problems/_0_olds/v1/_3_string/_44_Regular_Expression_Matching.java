package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/8.
 */
public class _44_Regular_Expression_Matching extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
    public String getNote() {
        return "[UNSOLVED]";
    }

    @Override
    public void run() {
        print(new Solution().isMatch("aaaab", ".*"));
    }

    public class Solution {
        public boolean isMatch(String s, String p) {
            return match(s, p, 0, 0);
        }

        private boolean match(String s, String p, int i, int j) {
            if (j == p.length())
                return i == s.length();
            if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
                if (i == s.length() || s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')
                    return false;
                else
                    return match(s, p, i + 1, j + 1);
            }
            //p.charAt(j+1)=='*'
            while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                if (match(s, p, i, j + 2))
                    return true;
                i++;
            }
            return match(s, p, i, j + 2);
        }
    }

    // LeetCode, Regular Expression Matching
    public class Solution1 {
        public boolean isMatch(String s, String p) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            // next char is not '*': must match current character
            if (p.length() == 1 || (p.length() > 1 && p.charAt(1) != '*')) {
                return ((p.charAt(0) == s.charAt(0)) ||
                        (p.charAt(0) == '.' && !s.isEmpty())) &&
                        isMatch(s.substring(1), p.substring(1));
            }
            // next char is '*'
            while ((s.length() > 0 && p.charAt(0) == s.charAt(0)) ||
                    (p.charAt(0) == '.' && !s.isEmpty())) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }

    public class Solution2 {
        public boolean isMatch(String s, String p) {
            if (p.length() == 0)
                return s.length() == 0;
            //p's length 1 is special case
            if (p.length() == 1 || p.charAt(1) != '*') {
                if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                    return false;
                return isMatch(s.substring(1), p.substring(1));
            } else {
                int len = s.length();
                int i = -1;
                while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                    if (isMatch(s.substring(i + 1), p.substring(2)))
                        return true;
                    i++;
                }
                return false;
            }
        }
    }
}
