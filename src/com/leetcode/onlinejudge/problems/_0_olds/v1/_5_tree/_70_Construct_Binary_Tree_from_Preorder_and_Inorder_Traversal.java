package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/12.
 */
public class _70_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given preorder and inorder traversal of a tree, construct the binary tree.\n" +
                "Note:\n" +
                "You may assume that duplicates do not exist in the tree.";
    }

    @Override
    public void run() {
        print(new Solution().buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
    }

    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        }

        private TreeNode build(int[] in, int inS, int inE, int[] pre, int pS, int pE) {
            if (inS > inE || pS > pE) {
                return null;
            }
            TreeNode root = new TreeNode(pre[pS]);
            int index = inS;
            for (; index <= inE; index++) {
                if (in[index] == root.val) {
                    break;
                }
            }
            root.left = build(in, inS, index - 1, pre, pS + 1, pS + 1 + (index - inS - 1));
            root.right = build(in, index + 1, inE, pre, pS + 1 + (index - inS - 1) + 1, pE);
            return root;
        }
    }
}
