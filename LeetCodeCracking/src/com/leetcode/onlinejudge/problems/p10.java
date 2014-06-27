package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/6/27.
 */
public class p10 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "[UNSOLVED]Linked List Cycle II";
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

        private int hit(ListNode slow, ListNode fast) {
            int hit = 0;
            if (fast == null || fast.next == null) {
                hit = -1;
            } else if (slow == fast || slow == fast.next) {
                hit = 1;
            }
            return hit;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (true) {
                int result = hit(slow, fast);
                return null;
            }
        }
    }


}
