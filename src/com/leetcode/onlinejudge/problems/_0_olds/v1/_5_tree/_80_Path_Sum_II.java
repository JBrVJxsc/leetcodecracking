package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/14.
 */
public class _80_Path_Sum_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.\n" +
                "For example:\n" +
                "Given the below binary tree and sum = 22,\n" +
                "              5\n" +
                "             / \\\n" +
                "            4   8\n" +
                "           /   / \\\n" +
                "          11  13  4\n" +
                "         /  \\    / \\\n" +
                "        7    2  5   1\n" +
                "return\n" +
                "[\n" +
                "   [5,4,11,2],\n" +
                "   [5,8,4,5]\n" +
                "]";
    }

    @Override
    public String getNote() {
        return "The reason that removing the last one inserted: " +
                "If do not do this, the List will be filled with whole tree;" +
                "If do this, you can image that the List is a hand which continually in and out from the tree," +
                "when whole search has been done, the List will be empty.";
    }

    @Override
    public void run() {
        TreeNode node = TreeNode.getTreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1);
        print(node.toArray());
        print(new Solution().pathSum(node, 22));
    }

    public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            get(lists, list, root, sum);
            return lists;
        }

        public void get(List<List<Integer>> lists, List<Integer> list, TreeNode node, int sum) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            if (node.left == null && node.right == null && sum == node.val) {
                lists.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
                return;
            }
            get(lists, list, node.left, sum - node.val);
            get(lists, list, node.right, sum - node.val);
            list.remove(list.size() - 1);
        }
    }

    // My wrong solution.
    public class Solution1 {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            get(lists, new ArrayList<Integer>(), root, sum);
            return lists;
        }

        private void get(List<List<Integer>> lists, List<Integer> list, TreeNode node, int sum) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            if (node.val == sum && node.left == null && node.right == null) {
                lists.add(new ArrayList<Integer>(list));
            }
            get(lists, list, node.left, sum - node.val);
            get(lists, list, node.right, sum - node.val);
        }
    }
}
