package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _79_Path_Sum extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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

    // A better one.
    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    // My solution.
    public class Solution1 {
        public boolean hasPathSum(TreeNode root, int sum) {
            return has(root, 0, sum);
        }

        private boolean has(TreeNode node, int cur, int sum) {
            if (node == null) {
                return false;
            }
            cur += node.val;
            if (cur == sum && node.left == null && node.right == null) {
                return true;
            }
            return has(node.left, cur, sum) || has(node.right, cur, sum);
        }
    }
}
