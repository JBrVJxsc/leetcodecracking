package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _77_Minimum_Depth_of_Binary_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, find its minimum depth.\n" +
                "The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.";
    }

    @Override
    public void run() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        print(new Solution().minDepth(treeNode));
    }

    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return min(root, 1);
        }

        private int min(TreeNode node, int depth) {
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left == null) {
                return min(node.right, depth + 1);
            } else if (node.right == null) {
                return min(node.left, depth + 1);
            } else {
                return Math.min(min(node.left, depth + 1), min(node.right, depth + 1));
            }
        }
    }
}
