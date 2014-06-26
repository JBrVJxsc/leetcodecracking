package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.List;

/**
 * Created by Who on 2014/6/25.
 */
public class p7 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Binary Tree Postorder Traversal";
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, return the postorder traversal of its nodes' values.\n" +
                "For example:\n" +
                "Given binary tree {1,#,2,3},\n" +
                "   1\n" +
                "    \\\n" +
                "     2\n" +
                "    /\n" +
                "   3\n" +
                "return [3,2,1].\n" +
                "Note: Recursive solution is trivial, could you do it iteratively?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            return null;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
