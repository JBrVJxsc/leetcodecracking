package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/6/29.
 */
public class p22 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Maximum Depth of Binary Tree";
    }

    @Override
    public String getSummary() {
        return "Given a binary tree, find its maximum depth.\n" +
                "The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int maxDepth(TreeNode root) {
            return 0;
        }
    }
}
