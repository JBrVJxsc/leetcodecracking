package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.TreeNode;

/**
 * Created by Who on 2014/8/14.
 */
public class _75_Convert_Sorted_Array_to_Binary_Search_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array where elements are sorted in ascending order, convert it to a height balanced BST.";
    }

    @Override
    public void run() {
        TreeNode node = new Solution().sortedArrayToBST(new int[]{1, 2, 3});
    }

    public class Solution {
        public TreeNode sortedArrayToBST(int[] num) {
            return convert(num, 0, num.length - 1);
        }

        private TreeNode convert(int[] num, int start, int end) {
            if (start > end) {
                return null;
            }
            int middle = start + (end - start) / 2;
            TreeNode node = new TreeNode(num[middle]);
            node.left = convert(num, start, middle - 1);
            node.right = convert(num, middle + 1, end);
            return node;
        }
    }
}
