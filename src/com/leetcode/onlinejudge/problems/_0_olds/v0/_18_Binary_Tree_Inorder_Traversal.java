package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/6/30.
 */
public class _18_Binary_Tree_Inorder_Traversal extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, return the inorder traversal of its nodes' values.\n" +
                "For example:\n" +
                "Given binary tree {1,#,2,3},\n" +
                "   1\n" +
                "    \\\n" +
                "     2\n" +
                "    /\n" +
                "   3\n" +
                "return [1,3,2].\n" +
                "Note: Recursive solution is trivial, could you do it iteratively?";
    }

    @Override
    public void run() {

    }

    public class Solution {

        private void get(TreeNode node, ArrayList<Integer> list) {
            if (node.left != null) {
                get(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                get(node.right, list);
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            if (root == null) {
                return numberList;
            }
            get(root, numberList);
            return numberList;
        }
    }
}
