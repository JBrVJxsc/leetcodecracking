package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _66_Symmetric_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).\n" +
                "For example, this binary tree is symmetric:\n" +
                "    1\n" +
                "   / \\\n" +
                "  2   2\n" +
                " / \\ / \\\n" +
                "3  4 4  3\n" +
                "But the following is not:\n" +
                "    1\n" +
                "   / \\\n" +
                "  2   2\n" +
                "   \\   \\\n" +
                "   3    3\n" +
                "Note:\n" +
                "Bonus points if you could solve it both recursively and iteratively.";
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(2);
        print(new Solution().isSymmetric(root));
    }

    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return check(root.left, root.right);
        }

        private boolean check(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            return check(left.left, right.right) && check(left.right, right.left);
        }
    }
}
