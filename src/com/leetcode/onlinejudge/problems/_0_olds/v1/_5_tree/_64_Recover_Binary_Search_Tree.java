package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/12.
 */
public class _64_Recover_Binary_Search_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Two elements of a binary search tree (BST) are swapped by mistake.\n" +
                "Recover the tree without changing its structure.\n" +
                "Note:\n" +
                "A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?";
    }

    @Override
    public void run() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        new Solution().recoverTree(root);
    }

    public class Solution {
        public void recoverTree(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            inorder(list, root);
            TreeNode first = null;
            TreeNode second = null;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).val > list.get(i + 1).val) {
                    first = list.get(i);
                    break;
                }
            }
            for (int i = list.size() - 1; 0 < i; i--) {
                if (list.get(i).val < list.get(i - 1).val) {
                    second = list.get(i);
                    break;
                }
            }
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        private void inorder(List<TreeNode> list, TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(list, node.left);
            list.add(node);
            inorder(list, node.right);
        }
    }
}
