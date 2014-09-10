package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/13.
 */
public class _72_Unique_Binary_Search_Trees extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given n, how many structurally unique BST's (binary search trees) that store values 1...n?\n" +
                "For example,\n" +
                "Given n = 3, there are a total of 5 unique BST's.\n" +
                "   1         3     3      2      1\n" +
                "    \\       /     /      / \\      \\\n" +
                "     3     2     1      1   3      2\n" +
                "    /     /       \\                 \\\n" +
                "   2     1         2                 3";
    }

    @Override
    public void run() {
        print(new Solution().numTrees(3));
    }

    public class Solution {
        public int numTrees(int n) {
            int[] nums = new int[n + 1];
            nums[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    nums[i] += nums[j] * nums[i - 1 - j];
                }
            }
            return nums[n];
        }
    }
}
