package com.leetcode.onlinejudge.problems._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/8.
 */
public class _45_Wildcard_Matching extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Implement wildcard pattern matching with support for '?' and '*'.\n" +
                "'?' Matches any single character.\n" +
                "'*' Matches any sequence of characters (including the empty sequence).\n" +
                "The matching should cover the entire input string (not partial).\n" +
                "The function prototype should be:\n" +
                "bool isMatch(const char *s, const char *p)\n" +
                "Some examples:\n" +
                "isMatch(\"aa\",\"a\") → false\n" +
                "isMatch(\"aa\",\"aa\") → true\n" +
                "isMatch(\"aaa\",\"aa\") → false\n" +
                "isMatch(\"aa\", \"*\") → true\n" +
                "isMatch(\"aa\", \"a*\") → true\n" +
                "isMatch(\"ab\", \"?*\") → true\n" +
                "isMatch(\"aab\", \"c*a*b\") → false";
    }

    @Override
    public void run() {

    }

    public class Solution {
        // 720ms for 1800 test cases
        public boolean isMatch(String s, String p) {
            if (s == null || p == null)
                return false;
            int m = s.length(), n = p.length();
            boolean[] match = new boolean[m + 1];     // Used for dynamic programming
            match[0] = true;
            // After each round, the information whether p[0...i] matches s[0...m-1]
            // is updated in match[1...m]
            for (int i = 0; i < n; i++) {
                if (p.charAt(i) != '*') {   // Not wildcard
                    for (int j = m; j > 0; j--)     // Update match backwards
                        match[j] = match[j - 1] &&
                                (p.charAt(i) == '?' || s.charAt(j - 1) == p.charAt(i));
                } else {    // Wildcard
                    int j = 0;
                    // Find the minimum j with p[0...i-1] matching s[0...j]
                    while (j <= m && !match[j])
                        j++;
                    // Since p[i] is '*' that matches any sequence, p[0...i] matches with
                    // s[0...j+1], s[0...j+2] ...
                    for (; j <= m; j++)
                        match[j] = true;
                }
                match[0] = match[0] && p.charAt(i) == '*';
            }
            return match[m];
        }
    }
}
