package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/28.
 */
public class p13 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Word Break";
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

    }
}
