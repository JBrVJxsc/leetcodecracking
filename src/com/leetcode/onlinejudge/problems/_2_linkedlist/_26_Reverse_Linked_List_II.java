package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/29.
 */
public class _26_Reverse_Linked_List_II extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Reverse a linked list from position m to n. Do it in-place and in one-pass.\n" +
                "For example:\n" +
                "Given 1->2->3->4->5->NULL, m = 2 and n = 4,\n" +
                "return 1->4->3->2->5->NULL.\n" +
                "Note:\n" +
                "Given m, n satisfy the following condition:\n" +
                "1 ≤ m ≤ n ≤ length of list.";
    }

    @Override
    public void run() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l2.next = l1;
        l3.next = l2;
        l4.next = l3;
        l5.next = l4;
        ListNode node = new Solution().reverseBetween(l5, 2, 4);
    }

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int count = m - 1;
            ListNode start = head;
            while (count != 0) {
                start = start.next;
                count--;
            }
            reverse(start, m, n);
            return head;
        }

        private void reverse(ListNode node, int start, int end) {
            if (start >= end) return;
            int count = end - start;
            ListNode target = node;
            while (count != 0) {
                target = target.next;
                count--;
            }
            int temp = target.val;
            target.val = node.val;
            node.val = temp;
            reverse(node.next, ++start, --end);
        }
    }
}