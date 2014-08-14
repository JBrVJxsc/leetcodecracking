package com.leetcode.onlinejudge.problems._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _79_Path_Sum extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.\n" +
                "For example:\n" +
                "Given the below binary tree and sum = 22,\n" +
                "              5\n" +
                "             / \\\n" +
                "            4   8\n" +
                "           /   / \\\n" +
                "          11  13  4\n" +
                "         /  \\      \\\n" +
                "        7    2      1\n" +
                "return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return true;
        }
    }
}
