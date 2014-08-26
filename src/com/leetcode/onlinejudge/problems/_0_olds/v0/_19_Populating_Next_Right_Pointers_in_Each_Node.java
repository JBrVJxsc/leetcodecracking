package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeLinkNode;

/**
 * Created by Who on 2014/6/30.
 */
public class _19_Populating_Next_Right_Pointers_in_Each_Node extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getName() {
        return "[UNSOLVED]Populating Next Right Pointers in Each Node";
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
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        new Solution().connect(root);
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null) {
                return;
            }
            connect(root.left);
            connect(root.right);
            root.left.next = root.right;
            if (root.left.right != null) {
                root.left.right.next = root.right.left;
            }
        }
    }
}
