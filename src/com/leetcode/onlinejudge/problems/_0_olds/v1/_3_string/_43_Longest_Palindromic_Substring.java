package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _43_Longest_Palindromic_Substring extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.";
    }

    @Override
    public void run() {
        print(new Solution().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        print(new Solution().longestPalindrome("bb"));
    }

    public class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int longestStart = 0;
            int maxLen = 1;
            boolean[][] status = new boolean[n][n];
            for (int i = 0; i < n; i++)
                status[i][i] = true;
            for (int i = 0; i < n - 1; i++)
                if (s.charAt(i) == s.charAt(i + 1)) {
                    status[i][i + 1] = true;
                    longestStart = i;
                    maxLen = 2;
                }
            for (int len = 3; len <= n; len++)
                for (int i = 0; i < n - len + 1; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j) && status[i + 1][j - 1]) {
                        status[i][j] = true;
                        longestStart = i;
                        maxLen = len;
                    }
                }
            return s.substring(longestStart, longestStart + maxLen);
        }
    }
}
