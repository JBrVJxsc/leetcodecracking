package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/11.
 */
public class _63_Binary_Tree_Zigzag_Level_Order_Traversal extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).\n" +
                "For example:\n" +
                "Given binary tree {3,9,20,#,#,15,7},\n" +
                "    3\n" +
                "   / \\\n" +
                "  9  20\n" +
                "    /  \\\n" +
                "   15   7\n" +
                "return its zigzag level order traversal as:\n" +
                "[\n" +
                "  [3],\n" +
                "  [20,9],\n" +
                "  [15,7]\n" +
                "]";
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        print(new Solution().zigzagLevelOrder(root));
    }

    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            get(lists, 0, root, true);
            return lists;
        }

        private void get(List<List<Integer>> lists, int level, TreeNode node, boolean leftToRight) {
            if (node == null) {
                return;
            }
            if (lists.size() == level) {
                lists.add(level, new ArrayList<Integer>());
            }
            if (leftToRight) {
                lists.get(level).add(node.val);
            } else {
                lists.get(level).add(0, node.val);
            }
            get(lists, level + 1, node.left, !leftToRight);
            get(lists, level + 1, node.right, !leftToRight);
        }
    }
}
