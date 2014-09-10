package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/8/8.
 */
public class _45_Wildcard_Matching extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
    public String getNote() {
        return "[UNSOLVED]";
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

        //DP:
        public boolean isMatchDP(String s, String p) {
            int n = s.length();
            int m = p.length();
            boolean[][] dp = new boolean[2][n + 1];
            dp[m % 2][n] = true;

            for (int i = m - 1; i >= 0; i--) {
                Arrays.fill(dp[i % 2], false);
                if (p.charAt(i) == '*')
                    for (int j = n; j >= 0; j--) {
                        if (dp[(i + 1) % 2][j]) {
                            for (; j >= 0; j--)
                                dp[i % 2][j] = true;
                        }
                    }
                else
                    for (int j = n - 1; j >= 0; j--)
                        dp[i % 2][j] = (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') && dp[(i + 1) % 2][j + 1];

            }
            return dp[0][0];
        }

        //Greedy:
        public boolean isMatchGreedy(String s, String p) {
            int n = s.length();
            int m = p.length();

            int i = 0;
            int j = 0;
            int star = -1;
            int sp = 0;

            while (i < n) {
                //one * and multiple *, same effect
                while (j < m && p.charAt(j) == '*') {
                    star = j++;  //* match 0 character
                    sp = i;
                }
                if (j == m || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?')) {
                    if (star < 0)
                        return false;
                    else {
                        j = star + 1;
                        i = ++sp;     //* match 1 character
                    }
                } else {
                    i++;
                    j++;
                }
            }
            while (j < m && p.charAt(j) == '*') j++;
            return j == m;
        }
    }
}
