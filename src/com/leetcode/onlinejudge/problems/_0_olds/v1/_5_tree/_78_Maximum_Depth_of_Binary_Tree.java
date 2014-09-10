package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _78_Maximum_Depth_of_Binary_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, find its maximum depth.\n" +
                "The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int maxDepth(TreeNode root) {
            return max(root, 0);
        }

        private int max(TreeNode node, int depth) {
            if (node == null) {
                return depth;
            }
            int left = max(node.left, depth + 1);
            int right = max(node.right, depth + 1);
            return Math.max(left, right);
        }
    }
}
