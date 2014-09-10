package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/30.
 */
public class _32_Swap_Nodes_in_Pairs extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a linked list, swap every two adjacent nodes and return its head.\n" +
                "For example, Given 1->2->3->4, you should return the list as 2->1->4->3.\n" +
                "Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.";
    }

    @Override
    public void run() {
        ListNode l1 = ListNode.getListNode(1, 2, 3, 4, 5);
        l1 = ListNode.getListNode(1, 2);
        print(new Solution().swapPairs(l1));
    }

    // My better solution.
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prePreNode = dummy;
            ListNode preNode = prePreNode.next;
            ListNode next = preNode.next;
            while (next != null) {
                preNode.next = next.next;
                next.next = preNode;
                prePreNode.next = next;
                prePreNode = prePreNode.next.next;
                preNode = prePreNode.next;
                next = preNode == null ? null : preNode.next;
            }
            return dummy.next;
        }
    }

    // My first solution.
    public class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            // Swap the first two nodes.
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            head = next;

            // Handle the rest of the nodes.
            int count = 0;
            ListNode prePreNode = head;
            ListNode preNode = prePreNode.next;
            next = preNode.next;
            while (next != null) {
                count++;
                if (count % 2 == 0) {
                    preNode.next = next.next;
                    next.next = preNode;
                    prePreNode.next = next;
                    preNode = prePreNode.next;
                    next = preNode.next;
                }
                next = next.next;
                preNode = preNode.next;
                prePreNode = prePreNode.next;
            }
            return head;
        }
    }
}
