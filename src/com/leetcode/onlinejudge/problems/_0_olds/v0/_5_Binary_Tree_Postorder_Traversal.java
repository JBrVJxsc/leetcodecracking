package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/6/25.
 */
public class _5_Binary_Tree_Postorder_Traversal extends BaseProblem implements IProblem {

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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        print(new Solution().postorderTraversal(root));
    }

    public class Solution {

        private void get(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                get(list, node.left);
            }
            if (node.right != null) {
                get(list, node.right);
            }
            list.add(node.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            get(list, root);
            return list;
        }
    }
}
