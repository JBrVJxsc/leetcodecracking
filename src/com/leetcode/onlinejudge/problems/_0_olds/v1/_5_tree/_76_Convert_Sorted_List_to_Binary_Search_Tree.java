package com.leetcode.onlinejudge.problems._0_olds.v1._5_tree;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;
import com.leetcode.onlinejudge.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/14.
 */
public class _76_Convert_Sorted_List_to_Binary_Search_Tree extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            ListNode next = head;
            List<Integer> list = new ArrayList<Integer>();
            while (next != null) {
                list.add(next.val);
                next = next.next;
            }
            return convert(list, 0, list.size() - 1);
        }

        private TreeNode convert(List<Integer> list, int start, int end) {
            if (start > end) {
                return null;
            }
            int middle = start + (end - start) / 2;
            TreeNode node = new TreeNode(list.get(middle));
            node.left = convert(list, start, middle - 1);
            node.right = convert(list, middle + 1, end);
            return node;
        }
    }
}
