package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/29.
 */
public class _26_Reverse_Linked_List_II extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Reverse a linked list from position m to n. Do it in-place and in one-pass.\n" +
                "For example:\n" +
                "Given 1->2->3->4->5->NULL, m = 2 and n = 4,\n" +
                "return 1->4->3->2->5->NULL.\n" +
                "Note:\n" +
                "Given m, n satisfy the following condition:\n" +
                "1 ≤ m ≤ n ≤ length of list.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            return null;
        }
    }
}
