package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _67_Balanced_Binary_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, determine if it is height-balanced.\n" +
                "For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.";
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        Solution solution = new Solution();
        timerOn();
        print(solution.isBalanced(root));
        print(timerOff());
    }

    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)) > 1) {
                return false;
            }
            if (!isBalanced(root.left)) {
                return false;
            }
            return isBalanced(root.right);
        }

        private int getHeight(TreeNode node, int height) {
            if (node == null) {
                return height;
            }
            return Math.max(getHeight(node.left, height + 1), getHeight(node.right, height + 1));
        }
    }
}
