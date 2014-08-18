package com.leetcode.onlinejudge.problems._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _98_Combinations extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.\n" +
                "For example,\n" +
                "If n = 4 and k = 2, a solution is:\n" +
                "[\n" +
                "  [2,4],\n" +
                "  [3,4],\n" +
                "  [2,3],\n" +
                "  [1,2],\n" +
                "  [1,3],\n" +
                "  [1,4],\n" +
                "]";
    }

    @Override
    public void run() {
        new Solution().combine(3, 3);
    }

    public class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return null;
        }
    }
}
