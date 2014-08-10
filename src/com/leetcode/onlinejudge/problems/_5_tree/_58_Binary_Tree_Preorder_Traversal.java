package com.leetcode.onlinejudge.problems._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.List;

/**
 * Created by Who on 2014/8/10.
 */
public class _58_Binary_Tree_Preorder_Traversal extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a binary tree, return the preorder traversal of its nodes' values.\n" +
                "For example:\n" +
                "Given binary tree {1,#,2,3},\n" +
                "   1\n" +
                "    \\\n" +
                "     2\n" +
                "    /\n" +
                "   3\n" +
                "return [1,2,3].\n" +
                "\n" +
                "Note: Recursive solution is trivial, could you do it iteratively?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            return null;
        }
    }
}
