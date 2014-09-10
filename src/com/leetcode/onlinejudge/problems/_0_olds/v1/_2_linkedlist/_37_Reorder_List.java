package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/6.
 */
public class _37_Reorder_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a singly linked list L: L0→L1→…→Ln-1→Ln,\n" +
                "reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…\n" +
                "You must do this in-place without altering the nodes' values.\n" +
                "For example,\n" +
                "Given {1,2,3,4}, reorder it to {1,4,2,3}.";
    }

    @Override
    public void run() {
        ListNode node = ListNode.getListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        node = ListNode.getListNode(1, 2, 3, 4);
        new Solution().reorderList(node);
        print(node);
    }

    public class Solution {
        public void reorderList(ListNode head) {
            // Get count of listNode.
            int counter = 0;
            ListNode next = head;
            while (next != null) {
                counter++;
                next = next.next;
            }
            if (counter < 3) return;
            // Get the listNode of half point.
            int half = counter % 2 == 0 ? counter / 2 : counter / 2 + 1;
            counter = 0;
            ListNode halfPoint = head;
            while (halfPoint != null) {
                counter++;
                if (counter == half)
                    break;
                halfPoint = halfPoint.next;
            }
            // Reverse from the half to the end.
            ListNode current = halfPoint.next;
            while (current.next != null) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = halfPoint.next;
                halfPoint.next = temp;
            }
            // Reorder.
            ListNode insertPoint = head;
            while (halfPoint.next != null && insertPoint != null) {
                ListNode temp = halfPoint.next;
                halfPoint.next = temp.next;
                temp.next = insertPoint.next;
                insertPoint.next = temp;
                if (insertPoint.next != null)
                    insertPoint = insertPoint.next.next;
            }
        }
    }

    // My TLE solution.
    public class Solution1 {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode preNext = head;
            ListNode next = head.next;
            while (next.next != null) {
                preNext = preNext.next;
                next = next.next;
            }
            if (next == head) return;
            preNext.next = null;
            next.next = head.next;
            head.next = next;
            reorderList(next.next);
        }
    }
}
