package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/30.
 */
public class _31_Remove_Nth_Node_From_End_of_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a linked list, remove the nth node from the end of list and return its head.\n" +
                "For example,\n" +
                "   Given linked list: 1->2->3->4->5, and n = 2.\n" +
                "   After removing the second node from the end, the linked list becomes 1->2->3->5.\n" +
                "Note:\n" +
                "Given n will always be valid.\n" +
                "Try to do this in one pass.";
    }

    @Override
    public void run() {
        ListNode l1 = ListNode.getListNode(1, 2, 3, 4, 5);
        ListNode l2 = ListNode.getListNode(1);
        print(new Solution().removeNthFromEnd(l1, 1));
    }

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int counter = 1;
            ListNode next = head;
            ListNode pre = head;
            while (next.next != null) {
                next = next.next;
                counter++;
                if (counter > n + 1)
                    pre = pre.next;
            }
            if (counter == n) return head.next;
            pre.next = pre.next.next;
            return head;
        }
    }

    public class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = 1;
            ListNode next = head;
            while (next.next != null) {
                length++;
                next = next.next;
            }
            if (n == length) return head.next;
            next = head;
            for (int i = 0; i < length - n - 1; i++)
                next = next.next;
            next.next = next.next.next;
            return head;
        }
    }
}
