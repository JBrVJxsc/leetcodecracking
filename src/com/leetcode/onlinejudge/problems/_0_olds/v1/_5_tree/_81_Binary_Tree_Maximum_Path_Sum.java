package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _81_Binary_Tree_Maximum_Path_Sum extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, find the maximum path sum.\n" +
                "The path may start and end at any node in the tree.\n" +
                "For example:\n" +
                "Given the below binary tree,\n" +
                "       1\n" +
                "      / \\\n" +
                "     2   3\n" +
                "Return 6.";
    }

    @Override
    public void run() {
        TreeNode treeNode = TreeNode.getTreeNode(-1, -2, -3, 100, null, null, null, null, -50);
        treeNode = TreeNode.getTreeNode(1, -2, -3, 1, 3, -2, null, -1);
        treeNode = TreeNode.getTreeNode(2, -1);
        print(new Solution().maxPathSum(treeNode));
    }

    public class Solution {

        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = root.val;
            if (left > 0) sum += left;
            if (right > 0) sum += right;
            max = Math.max(max, sum);
            return Math.max(right, left) > 0 ? Math.max(right, left) + root.val : root.val;
        }
    }
}
