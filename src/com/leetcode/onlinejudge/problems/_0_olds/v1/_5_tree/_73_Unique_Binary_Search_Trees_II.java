package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/14.
 */
public class _73_Unique_Binary_Search_Trees_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.\n" +
                "For example,\n" +
                "Given n = 3, your program should return all 5 unique BST's shown below.\n" +
                "   1         3     3      2      1\n" +
                "    \\       /     /      / \\      \\\n" +
                "     3     2     1      1   3      2\n" +
                "    /     /       \\                 \\\n" +
                "   2     1         2                 3";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<TreeNode> generateTrees(int n) {
            return gen(1, n);
        }

        private List<TreeNode> gen(int start, int end) {
            List<TreeNode> nodes = new ArrayList<TreeNode>();
            if (start > end) {
                nodes.add(null);
                return nodes;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = gen(start, i - 1);
                List<TreeNode> right = gen(i + 1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        nodes.add(node);
                    }
                }
            }
            return nodes;
        }
    }
}
