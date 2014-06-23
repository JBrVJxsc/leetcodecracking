package com.leetcode.onlinejudge.algorithms;

import com.leetcode.interfaces.IAlgorithm;
import com.leetcode.onlinejudge.BaseAlgorithm;

/**
 * Created by Who on 2014/6/23.
 */
public class a1 extends BaseAlgorithm implements IAlgorithm {

    @Override
    public String getName() {
        return "Reverse Words in a String";
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
        print("TEST");
    }
}
