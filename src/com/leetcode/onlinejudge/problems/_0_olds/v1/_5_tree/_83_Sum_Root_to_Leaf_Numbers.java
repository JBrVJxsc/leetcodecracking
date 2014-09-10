package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _83_Sum_Root_to_Leaf_Numbers extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.\n" +
                "An example is the root-to-leaf path 1->2->3 which represents the number 123.\n" +
                "Find the total sum of all root-to-leaf numbers.\n" +
                "For example,\n" +
                "    1\n" +
                "   / \\\n" +
                "  2   3\n" +
                "The root-to-leaf path 1->2 represents the number 12.\n" +
                "The root-to-leaf path 1->3 represents the number 13.\n" +
                "Return the sum = 12 + 13 = 25.";
    }

    @Override
    public void run() {
        print(new Solution().sumNumbers(TreeNode.getTreeNode(1, 2, 3)));
    }

    public class Solution {

        private int total = 0;

        public int sumNumbers(TreeNode root) {
            sum(root, 0);
            return total;
        }

        private void sum(TreeNode node, int num) {
            if (node == null) {
                return;
            }
            num = num * 10 + node.val;
            if (node.left == null && node.right == null) {
                total += num;
                return;
            }
            sum(node.left, num);
            sum(node.right, num);
        }
    }
}
