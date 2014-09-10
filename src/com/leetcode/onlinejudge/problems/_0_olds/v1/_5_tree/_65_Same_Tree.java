package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _65_Same_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given two binary trees, write a function to check if they are equal or not.\n" +
                "Two binary trees are considered equal if they are structurally identical and the nodes have the same value.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
