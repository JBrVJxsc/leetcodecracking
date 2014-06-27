package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/6/27.
 */
public class p11 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Linked List Cycle";
    }

    @Override
    public String getSummary() {
        return "Given a linked list, determine if it has a cycle in it.\n" +
                "Follow up:\n" +
                "Can you solve it without using extra space?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            return true;
        }
    }
}
