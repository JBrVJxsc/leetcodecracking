package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/6.
 */
public class _36_Linked_List_Cycle_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a linked list, return the node where the cycle begins. If there is no cycle, return null.\n" +
                "Follow up:\n" +
                "Can you solve it without using extra space?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }
            if (fast == null || fast.next == null) return null;
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
