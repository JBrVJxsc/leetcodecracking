package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/10.
 */
public class _60_Binary_Tree_Postorder_Traversal extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
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
            List<Integer> list = new ArrayList<Integer>();
            get(list, root);
            return list;
        }

        private void get(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            get(list, node.left);
            get(list, node.right);
            list.add(node.val);
        }
    }
}
