package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/29.
 */
public class _27_Partition_List extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.\n" +
                "You should preserve the original relative order of the nodes in each of the two partitions.\n" +
                "For example,\n" +
                "Given 1->4->3->2->5->2 and x = 3,\n" +
                "return 1->2->2->4->3->5.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public ListNode partition(ListNode head, int x) {
            return null;
        }
    }
}
