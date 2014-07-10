package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.List;

/**
 * Created by Who on 2014/6/29.
 */
public class p21 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "[UNSOLVED]Palindrome Partitioning";
    }

    @Override
    public String getSummary() {
        return "Given a string s, partition s such that every substring of the partition is a palindrome.\n" +
                "Return all possible palindrome partitioning of s.\n" +
                "For example, given s = \"aab\",\n" +
                "Return\n" +
                "\n" +
                "  [\n" +
                "    [\"aa\",\"b\"],\n" +
                "    [\"a\",\"a\",\"b\"]\n" +
                "  ]";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<List<String>> partition(String s) {
            return null;
        }
    }
}
