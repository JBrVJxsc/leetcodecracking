package com.leetcode.onlinejudge.problems.olds.v1;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Who on 2014/6/28.
 */
public class p13 extends BaseProblem implements IProblem {

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String getName() {
        return "[UNSOLVED]Word Break";
    }

    @Override
    public String getSummary() {
        return "Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.\n" +
                "For example, given\n" +
                "s = \"leetcode\",\n" +
                "dict = [\"leet\", \"code\"].\n" +
                "Return true because \"leetcode\" can be segmented as \"leet code\".";
    }

    @Override
    public void run() {
        Set<String> stringSet = new HashSet<String>();
        stringSet.add("a");
        stringSet.add("abc");
        stringSet.add("b");
        stringSet.add("cd");
        print(new Solution().wordBreak("abcd", stringSet));
    }

    //Just test subclass.
    public class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
            return true;
        }
    }
}
