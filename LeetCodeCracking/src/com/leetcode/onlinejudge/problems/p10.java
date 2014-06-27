package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/27.
 */
public class p10 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Linked List Cycle II";
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
            return null;
        }
    }

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
