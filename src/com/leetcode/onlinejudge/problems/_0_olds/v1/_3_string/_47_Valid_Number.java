package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/9.
 */
public class _47_Valid_Number extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Validate if a given string is numeric.\n" +
                "Some examples:\n" +
                "\"0\" => true\n" +
                "\" 0.1 \" => true\n" +
                "\"abc\" => false\n" +
                "\"1 a\" => false\n" +
                "\"2e10\" => true\n" +
                "Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.";
    }

    @Override
    public String getNote() {
        return "Tried thousand times...";
    }

    @Override
    public void run() {
        Solution solution = new Solution();
        print(solution.isNumber("0"));
        print(solution.isNumber(" 0.1"));
        print(solution.isNumber("abc"));
        print(solution.isNumber("1 a"));
        print(solution.isNumber("2e10"));
        print(solution.isNumber("005047e+6"));
    }

    public class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return false;
            }
            boolean hasDot = false;
            boolean hasE = false;
            boolean hasNeg = false;
            boolean hasPos = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c > '9' || c < '0') {
                    if (c != '+' && c != '-' && c != '.' && c != 'e' || s.length() == 1 && c != 'e') {
                        return false;
                    }
                }
                if (c == '+') {
                    if (i != 0 && !hasE || i != 0 && hasE && i == s.length() - 1 || hasPos && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    hasPos = true;
                }
                if (c == '-') {
                    if (i != 0 && !hasE || i != 0 && hasE && i == s.length() - 1 || hasNeg && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    hasNeg = true;
                }
                if (c == '.') {
                    if (i > 0) {
                        char preC = s.charAt(i - 1);
                        if ((preC == '+' || preC == '-') && s.length() == 2 || preC == 'e') {
                            return false;
                        }
                    }
                    if (hasDot || hasE) {
                        return false;
                    }
                    hasDot = true;
                }
                if (c == 'e') {
                    if (i > 0) {
                        char preC = s.charAt(i - 1);
                        if ((preC == '+' || preC == '-') && s.length() > 2) {
                            return false;
                        }
                    }
                    if (hasE || i == 0 || i == s.length() - 1 || hasDot && i == 1 && s.length() > 2) {
                        return false;
                    }
                    hasE = true;
                }
            }
            return true;
        }
    }
}
