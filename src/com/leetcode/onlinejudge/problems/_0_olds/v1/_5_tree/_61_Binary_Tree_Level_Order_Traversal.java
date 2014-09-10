package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.*;

/**
 * Created by Who on 2014/8/10.
 */
public class _61_Binary_Tree_Level_Order_Traversal extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).\n" +
                "For example:\n" +
                "Given binary tree {3,9,20,#,#,15,7},\n" +
                "    3\n" +
                "   / \\\n" +
                "  9  20\n" +
                "    /  \\\n" +
                "   15   7\n" +
                "return its level order traversal as:\n" +
                "[\n" +
                "  [3],\n" +
                "  [9,20],\n" +
                "  [15,7]\n" +
                "]";
    }

    @Override
    public void run() {

    }

    // A better version.
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            get(lists, 0, root);
            return lists;
        }

        private void get(List<List<Integer>> lists, int level, TreeNode node) {
            if (node == null) {
                return;
            }
            if (lists.size() == level) {
                lists.add(level, new ArrayList<Integer>());
            }
            lists.get(level).add(node.val);
            get(lists, level + 1, node.left);
            get(lists, level + 1, node.right);
        }
    }

    // My version with too much codes.
    public class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
            if (root != null) {
                get(hashMap, 0, root);
            }
            List<Integer>[] list = new List[hashMap.size()];
            Iterator iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = (Map.Entry) iterator.next();
                list[entry.getKey()] = entry.getValue();
            }
            for (List<Integer> l : list) {
                lists.add(l);
            }
            return lists;
        }

        private void get(HashMap<Integer, List<Integer>> hashMap, int level, TreeNode node) {
            if (node == null) {
                return;
            }
            List<Integer> list;
            if (hashMap.containsKey(level)) {
                list = hashMap.get(level);
            } else {
                list = new ArrayList<Integer>();
                hashMap.put(level, list);
            }
            list.add(node.val);
            if (node.left == null && node.right == null) {
                return;
            }
            get(hashMap, level + 1, node.left);
            get(hashMap, level + 1, node.right);
        }
    }
}
