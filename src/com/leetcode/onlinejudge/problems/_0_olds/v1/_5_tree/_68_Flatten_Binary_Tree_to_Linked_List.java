package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _68_Flatten_Binary_Tree_to_Linked_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        new Solution().flatten(root);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        new Solution1().flatten(root);
    }

    public class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            if (root.left == null) {
                return;
            }
            TreeNode right = root.left;
            while (right.right != null) {
                right = right.right;
            }
            right.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    // A shorter version.
    public class Solution1 {
        public void flatten(TreeNode root) {
            flatten(root, null);
        }

        private TreeNode flatten(TreeNode root, TreeNode tail) {
            if (root == null) {
                return tail;
            }
            root.right = flatten(root.left, flatten(root.right, tail));
            root.left = null;
            return root;
        }
    }
}
