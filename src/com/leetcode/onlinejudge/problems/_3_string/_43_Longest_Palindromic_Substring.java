package com.leetcode.onlinejudge.problems._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _43_Longest_Palindromic_Substring extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.";
    }

    @Override
    public void run() {
        print(new Solution().longestPalindrome("abcdedcba"));
    }

    public class Solution {
        public String longestPalindrome(String s) {
            if (s == null)
                return null;
            if (s.length() <= 1)
                return s;
            int maxLen = 0;
            String longestStr = null;
            int length = s.length();
            int[][] table = new int[length][length];
            //every single letter is palindrome
            for (int i = 0; i < length; i++) {
                table[i][i] = 1;
            }
//            printTable(table);
            //e.g. bcba
            //two consecutive same letters are palindrome
            for (int i = 0; i <= length - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    table[i][i + 1] = 1;
                    longestStr = s.substring(i, i + 2);
                }
            }
            printTable(table);
            //condition for calculate whole table
            for (int l = 3; l <= length; l++) {
                for (int i = 0; i <= length - l; i++) {
                    int j = i + l - 1;
                    print(i + ", " + j);
                    if (s.charAt(i) == s.charAt(j)) {
                        table[i][j] = table[i + 1][j - 1];
                        print((i + 1) + ", " + (j - 1));
                        print();
                        if (table[i][j] == 1 && l > maxLen)
                            longestStr = s.substring(i, j + 1);
                    } else {
                        table[i][j] = 0;
                    }
//                    printTable(table);
                }
            }
            return longestStr;
        }

        public void printTable(int[][] x) {
            for (int[] y : x) {
                for (int z : y) {
                    System.out.print(z + " ");
                }
                System.out.println();
            }
            System.out.println("------");
        }
    }
}
