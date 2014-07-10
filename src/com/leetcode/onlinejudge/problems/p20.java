package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class p20 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "[UNSOLVED]Palindrome Partitioning II";
    }

    @Override
    public String getSummary() {
        return "Given a string s, partition s such that every substring of the partition is a palindrome.\n" +
                "Return the minimum cuts needed for a palindrome partitioning of s.\n" +
                "For example, given s = \"aab\",\n" +
                "Return 1 since the palindrome partitioning [\"aa\",\"b\"] could be produced using 1 cut.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int minCut(String s) {
            return 0;
        }
    }
}
