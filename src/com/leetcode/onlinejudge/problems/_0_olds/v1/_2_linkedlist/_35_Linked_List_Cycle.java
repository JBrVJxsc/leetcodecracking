package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/31.
 */
public class _35_Linked_List_Cycle extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a linked list, determine if it has a cycle in it.\n" +
                "Follow up: Can you solve it without using extra space?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }

    public class Solution1 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null) {
                if (fast.next == null || fast.next.next == null) return false;
                if (fast.next == slow || fast.next.next == slow) return true;
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                if (fast.next == slow || fast.next.next == slow) return true;
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }
}
