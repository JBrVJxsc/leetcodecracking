package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/23.
 */
public class _1_Reverse_Words_in_a_String extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getSummary() {
        return "Given an input string, reverse the string word by word.\n" +
                "For example,\n" +
                "Given s = \"the sky is blue\",\n" +
                "return \"blue is sky the\".";
    }

    @Override
    public void run() {
        String s = "    the        sky      is       blue    ";
        print("The original words is: " + s);
        print("The reversed words is: " + new Solution().reverseWords(s));
    }

    public class Solution {
        public String reverseWords(String s) {
            String[] words = s.trim().split(" ");
            String done = "";
            for (int i = words.length - 1; i >= 0; i--) {
                if (words[i].equals("")) {
                    continue;
                }
                done += words[i] + " ";
            }
            return done.trim();
        }
    }
}
