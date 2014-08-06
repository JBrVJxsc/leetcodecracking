package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/6.
 */
public class _37_Reorder_List extends BaseProblem implements IProblem {
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
        ListNode l1 = ListNode.getListNode(1, 3, 3, 1);
        new Solution1().reorderList(l1);
        print(l1);
    }

    public class Solution {
        public void reorderList(ListNode head) {

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
