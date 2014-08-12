package com.leetcode.onlinejudge.problems._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _68_Flatten_Binary_Tree_to_Linked_List extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a binary tree, flatten it to a linked list in-place.\n" +
                "For example,\n" +
                "Given\n" +
                "         1\n" +
                "        / \\\n" +
                "       2   5\n" +
                "      / \\   \\\n" +
                "     3   4   6\n" +
                "The flattened tree should look like:\n" +
                "   1\n" +
                "    \\\n" +
                "     2\n" +
                "      \\\n" +
                "       3\n" +
                "        \\\n" +
                "         4\n" +
                "          \\\n" +
                "           5\n" +
                "            \\\n" +
                "             6\n" +
                "Hints:\n" +
                "If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public void flatten(TreeNode root) {
            get(root);
        }

        private TreeNode get(TreeNode node) {
            if (node == null) {
                return null;
            }
            TreeNode left = get(node.left);
            TreeNode right = get(node.right);
            node.right = left;
            if (left == null) {
                node.right = right;
            } else {
                node.right.right = right;
            }
            return node;
        }
    }
}
