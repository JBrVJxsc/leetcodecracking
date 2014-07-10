package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/6/29.
 */
public class p23 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Same Tree";
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

        private boolean check(TreeNode p, TreeNode q) {
            if (p != null && q == null) {
                return false;
            }
            if (p == null && q != null) {
                return false;
            }
            if (p == null && q == null) {
                return true;
            }
            if (p.val != q.val) {
                return false;
            }
            return check(p.left, q.left) && check(p.right, q.right) == true;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            return check(p, q);
        }
    }
}
