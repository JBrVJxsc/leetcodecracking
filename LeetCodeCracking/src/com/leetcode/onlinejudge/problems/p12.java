package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/28.
 */
public class p12 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "[UNSOLVED]Word Break II";
    }

    @Override
    public String getSummary() {
        return "Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.\n" +
                "Return all such possible sentences.\n" +
                "For example, given\n" +
                "s = \"catsanddog\",\n" +
                "dict = [\"cat\", \"cats\", \"and\", \"sand\", \"dog\"].\n" +
                "A solution is [\"cats and dog\", \"cat sand dog\"].";
    }

    @Override
    public void run() {

    }
}
