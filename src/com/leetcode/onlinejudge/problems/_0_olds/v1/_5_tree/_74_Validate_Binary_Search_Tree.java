package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/14.
 */
public class _74_Validate_Binary_Search_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, determine if it is a valid binary search tree (BST).\n" +
                "Assume a BST is defined as follows:\n" +
                "The left subtree of a node contains only nodes with keys less than the node's key.\n" +
                "The right subtree of a node contains only nodes with keys greater than the node's key.\n" +
                "Both the left and right subtrees must also be binary search trees.";
    }

    @Override
    public void run() {

    }

    // Recursively.
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean check(TreeNode node, int lower, int upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            if (!check(node.left, lower, node.val)) {
                return false;
            }
            return check(node.right, node.val, upper);
        }
    }

    // My version with too much codes.
    public class Solution1 {
        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            inorder(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private void inorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }
}
