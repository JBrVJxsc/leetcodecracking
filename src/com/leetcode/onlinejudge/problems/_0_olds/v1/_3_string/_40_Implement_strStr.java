package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _40_Implement_strStr extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Implement strStr().\n" +
                "Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.";
    }

    @Override
    public void run() {
        String haystack = "abcdefj";
        String needle = "cd";
        print(new Solution().strStr(haystack, needle));
    }

    public class Solution {
        public String strStr(String haystack, String needle) {
            if (needle.length() == 0 || needle.equals(haystack))
                return haystack;
            if (needle.length() > haystack.length())
                return null;
            int hLen = haystack.length();
            int nLen = needle.length();
            for (int i = 0; i < hLen; i++) {
                char c = haystack.charAt(i);
                if (c == needle.charAt(0) && hLen - i >= nLen) {
                    int j = 1;
                    for (; j < nLen; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j))
                            break;
                    }
                    if (j == nLen)
                        return haystack.substring(i);
                }
            }
            return null;
        }
    }
}
