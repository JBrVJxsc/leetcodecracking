package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeLinkNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _69_Populating_Next_Right_Pointers_in_Each_Node_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }


    @Override
    public String getSummary() {
        return "Follow up for problem \"Populating Next Right Pointers in Each Node\".\n" +
                "What if the given tree could be any binary tree? Would your previous solution still work?\n" +
                "Note:\n" +
                "You may only use constant extra space.\n" +
                "For example,\n" +
                "Given the following binary tree,\n" +
                "         1\n" +
                "       /  \\\n" +
                "      2    3\n" +
                "     / \\    \\\n" +
                "    4   5    7\n" +
                "After calling your function, the tree should look like:\n" +
                "         1 -> NULL\n" +
                "       /  \\\n" +
                "      2 -> 3 -> NULL\n" +
                "     / \\    \\\n" +
                "    4-> 5 -> 7 -> NULL";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    TreeLinkNode node = root.next;
                    while (node != null && node.left == null && node.right == null) {
                        node = node.next;
                    }
                    if (node != null) {
                        root.left.next = node.left == null ? node.right : node.left;
                    }
                }
            }
            if (root.right != null) {
                TreeLinkNode node = root.next;
                while (node != null && node.left == null && node.right == null) {
                    node = node.next;
                }
                if (node != null) {
                    root.right.next = node.left == null ? node.right : node.left;
                }
            }
            connect(root.right);
            connect(root.left);
        }
    }
}
