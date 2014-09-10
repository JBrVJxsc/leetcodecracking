package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/9.
 */
public class _46_Longest_Common_Prefix extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Write a function to find the longest common prefix string amongst an array of strings.";
    }

    @Override
    public void run() {
        print(new Solution().longestCommonPrefix(new String[]{"123abc", "123456"}));
    }

    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int minLen = Integer.MAX_VALUE;
            for (String i : strs) {
                minLen = minLen < i.length() ? minLen : i.length();
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < minLen; i++) {
                char c = strs[0].charAt(i);
                for (String s : strs) {
                    if (s.charAt(i) != c) {
                        return stringBuffer.toString();
                    }
                }
                stringBuffer.append(c);
            }
            return stringBuffer.toString();
        }
    }
}
