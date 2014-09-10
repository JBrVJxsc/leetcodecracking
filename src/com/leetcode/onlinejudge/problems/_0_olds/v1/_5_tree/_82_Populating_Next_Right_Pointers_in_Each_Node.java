package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeLinkNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _82_Populating_Next_Right_Pointers_in_Each_Node extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }


    @Override
    public String getSummary() {
        return "Given a binary tree\n" +
                "    struct TreeLinkNode {\n" +
                "      TreeLinkNode *left;\n" +
                "      TreeLinkNode *right;\n" +
                "      TreeLinkNode *next;\n" +
                "    }\n" +
                "Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.\n" +
                "Initially, all next pointers are set to NULL.\n" +
                "Note:\n" +
                "You may only use constant extra space.\n" +
                "You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).\n" +
                "For example,\n" +
                "Given the following perfect binary tree,\n" +
                "         1\n" +
                "       /  \\\n" +
                "      2    3\n" +
                "     / \\  / \\\n" +
                "    4  5  6  7\n" +
                "After calling your function, the tree should look like:\n" +
                "         1 -> NULL\n" +
                "       /  \\\n" +
                "      2 -> 3 -> NULL\n" +
                "     / \\  / \\\n" +
                "    4->5->6->7 -> NULL";
    }

    @Override
    public void run() {
        TreeLinkNode node = new TreeLinkNode(0);
        new Solution().connect(node);
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            connect(root.left);
            connect(root.right);
            if (root.left == null) {
                return;
            }
            root.left.next = root.right;
            if (root.left.right == null) {
                return;
            }
            TreeLinkNode right = root.left.right;
            TreeLinkNode left = root.right.left;
            while (right != null) {
                right.next = left;
                right = right.right;
                left = left.left;
            }
        }
    }
}
