package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/6/29.
 */
public class _13_Maximum_Depth_of_Binary_Tree extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, find its maximum depth.\n" +
                "The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.";
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(9);
        print(new Solution().maxDepth(root));
    }

    public class Solution {

        private int getMaxDepth(TreeNode node, int depth) {
            int left = depth;
            int right = depth;
            if (node.left != null) {
                left = getMaxDepth(node.left, depth + 1);
            }
            if (node.right != null) {
                right = getMaxDepth(node.right, depth + 1);
            }
            return (left < right) ? right : left;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return getMaxDepth(root, 1);
        }
    }
}
