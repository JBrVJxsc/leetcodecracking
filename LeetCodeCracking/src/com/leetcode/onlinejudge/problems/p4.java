package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/25.
 */
public class p4 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Sort List ";
    }

    @Override
    public String getSummary() {
        return "Sort a linked list in O(n log n) time using constant space complexity.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public ListNode sortList(ListNode head) {
            return null;
        }
    }

    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
