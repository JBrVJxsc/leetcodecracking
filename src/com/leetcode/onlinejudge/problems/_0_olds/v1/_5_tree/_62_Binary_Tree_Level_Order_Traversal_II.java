package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Who on 2014/8/11.
 */
public class _62_Binary_Tree_Level_Order_Traversal_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).\n" +
                "For example:\n" +
                "Given binary tree {3,9,20,#,#,15,7},\n" +
                "    3\n" +
                "   / \\\n" +
                "  9  20\n" +
                "    /  \\\n" +
                "   15   7\n" +
                "return its bottom-up level order traversal as:\n" +
                "[\n" +
                "  [15,7],\n" +
                "  [9,20],\n" +
                "  [3]\n" +
                "]";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            get(lists, 0, root);
            Collections.reverse(lists);
            return lists;
        }

        private void get(List<List<Integer>> lists, int level, TreeNode node) {
            if (node == null) {
                return;
            }
            if (lists.size() == level) {
                lists.add(level, new ArrayList<Integer>());
            }
            get(lists, level + 1, node.left);
            get(lists, level + 1, node.right);
            lists.get(level).add(node.val);
        }
    }
}
