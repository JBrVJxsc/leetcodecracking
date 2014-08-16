package com.leetcode.onlinejudge.problems._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeLinkNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _82_Populating_Next_Right_Pointers_in_Each_Node extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Follow up for problem \"Populating Next Right Pointers in Each Node\".\n" +
                "What if the given tree could be any binary tree? Would your previous solution still work?\n" +
                "Note:\n" +
                "You may only use constant extra space.\n" +
                "For example,\n" +
                "Given the following binary tree,\n" +
                "         1\n" +
                "       /  \\\n" +
                "      2    3\n" +
                "     / \\    \\\n" +
                "    4   5    7\n" +
                "After calling your function, the tree should look like:\n" +
                "         1 -> NULL\n" +
                "       /  \\\n" +
                "      2 -> 3 -> NULL\n" +
                "     / \\    \\\n" +
                "    4-> 5 -> 7 -> NULL";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public void connect(TreeLinkNode root) {

        }
    }
}
