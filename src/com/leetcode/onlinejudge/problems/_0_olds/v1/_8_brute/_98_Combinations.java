package com.leetcode.onlinejudge.problems._0_olds.v1._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;

/**
 * Created by Who on 2014/8/18.
 */
public class _98_Combinations extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
    public String getNote() {
        return "UNSOLVED";
    }

    @Override
    public void run() {
        new Solution().combine(4, 2);
    }

    // Solution one.
    public class Solution {
        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
            if (n <= 0 || k <= 0) {
                return null;
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            int start = 1;
            int num = 0;
            ArrayList<Integer> subResult = new ArrayList<Integer>();
            buildResult(start, num, n, k, subResult, result);
            return result;
        }

        // DFS classical format
        private void buildResult(int start, int currentNum, int n, int k, ArrayList<Integer> subResult, ArrayList<ArrayList<Integer>> result) {
            if (currentNum == k) {
                ArrayList<Integer> temp = new ArrayList<Integer>(subResult);
                result.add(temp);
                return;
            }
            for (int i = start; i <= n; i++) {
                subResult.add(i);
                buildResult(i + 1, currentNum + 1, n, k, subResult, result);
                subResult.remove(subResult.size() - 1);
            }
        }
    }

    // Solution two.
    public class Solution1 {
        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> subset = new ArrayList<Integer>();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = j + 1;
            }
            subsets(n, k, num, 0, subset, result);
            return result;
        }

        private void subsets(int n, int k, int[] num, int begin, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> result) {
            if (subset.size() >= k) {
                ArrayList<Integer> c = new ArrayList<Integer>(subset);
                result.add(c);
            } else {
                for (int i = begin; i < num.length; i++) {
                    subset.add(num[i]);
                    subsets(n, k, num, i + 1, subset, result);
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }
}
