package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

import java.util.Stack;

/**
 * Created by Who on 2014/7/29.
 */
public class _27_Partition_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
        print(new Solution().partition(ListNode.getListNode(1, 4, 3, 2, 5, 2), 3));
        print(new Solution().partition(ListNode.getListNode(2, 1), 2));
    }

    public class Solution {
        public ListNode partition(ListNode head, int x) {
            Stack<ListNode> nodeStack = new Stack<ListNode>();
            ListNode next = head;
            while (next != null) {
                nodeStack.push(next);
                next = next.next;
            }
            while (!nodeStack.empty()) {
                ListNode node = nodeStack.pop();
                check(node, x);
            }
            return head;
        }

        private void check(ListNode node, int x) {
            if (node.next == null) return;
            if (node.val >= x && node.next.val < x) {
                int temp = node.next.val;
                node.next.val = node.val;
                node.val = temp;
                check(node.next, x);
            }
        }
    }
}
