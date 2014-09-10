package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/29.
 */
public class _28_Remove_Duplicates_from_Sorted_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a sorted linked list, delete all duplicates such that each element appear only once.\n" +
                "For example,\n" +
                "Given 1->1->2, return 1->2.\n" +
                "Given 1->1->2->3->3, return 1->2->3.";
    }

    @Override
    public void run() {
        print(new Solution().deleteDuplicates(ListNode.getListNode(1, 1, 2)));
        print(new Solution().deleteDuplicates(ListNode.getListNode(1, 1, 2, 3, 3)));
        print(new Solution().deleteDuplicates(ListNode.getListNode(1, 1, 1)));
    }

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            check(head);
            return head;
        }

        private void check(ListNode node) {
            if (node == null || node.next == null) return;
            if (node.val == node.next.val) {
                node.next = node.next.next;
                check(node);
            } else check(node.next);
        }
    }
}
