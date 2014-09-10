package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/13.
 */
public class _71_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given inorder and postorder traversal of a tree, construct the binary tree.";
    }

    @Override
    public void run() {
        print(new Solution().buildTree(new int[]{-1}, new int[]{-1}));
    }

    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] in, int inS, int inE, int[] post, int pS, int pE) {
            if (inS > inE || pS > pE) {
                return null;
            }
            TreeNode root = new TreeNode(post[pE]);
            int index = inS;
            for (; index < inE; index++) {
                if (in[index] == root.val) {
                    break;
                }
            }
            root.left = build(in, inS, index - 1, post, pS, pS + (index - inS - 1));
            root.right = build(in, index + 1, inE, post, pS + (index - inS - 1) + 1, pE - 1);
            return root;
        }
    }
}
