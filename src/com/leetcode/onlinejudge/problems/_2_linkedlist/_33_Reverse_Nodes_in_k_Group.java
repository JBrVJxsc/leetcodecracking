package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/30.
 */
public class _33_Reverse_Nodes_in_k_Group extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.\n" +
                "If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.\n" +
                "You may not alter the values in the nodes, only nodes itself may be changed.\n" +
                "Only constant memory is allowed.\n" +
                "For example,\n" +
                "Given this linked list: 1->2->3->4->5\n" +
                "For k = 2, you should return: 2->1->4->3->5\n" +
                "For k = 3, you should return: 3->2->1->4->5";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            return null;
        }
    }
}
