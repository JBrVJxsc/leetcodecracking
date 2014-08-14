package com.leetcode.onlinejudge.problems._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _74_Validate_Binary_Search_Tree extends BaseProblem implements IProblem {
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

    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return true;
        }
    }
}
