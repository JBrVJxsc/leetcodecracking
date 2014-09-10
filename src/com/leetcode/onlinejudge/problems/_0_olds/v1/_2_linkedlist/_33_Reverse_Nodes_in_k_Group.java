package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/30.
 */
public class _33_Reverse_Nodes_in_k_Group extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
        ListNode l1 = ListNode.getListNode(1, 2, 3, 4, 5);
        ListNode l2 = ListNode.getListNode(1, 2, 3, 4, 5, 6);
        ListNode l3 = ListNode.getListNode(1, 2, 3, 4, 5, 6);
//        print(new Solution().reverseKGroup(l1, 2));
//        print(new Solution().reverseKGroup(l2, 3));
        ListNode dummy = ListNode.getListNode(0);
        dummy.next = l3;
        print(new Solution().reverse(dummy, dummy.getLastOne().next));
        print(dummy);
    }

    // A better solution.
    public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            int i = 0;
            while (head != null) {
                i++;
                if (i % k == 0) {
                    pre = reverse(pre, head.next);
                    head = pre.next;
                } else {
                    head = head.next;
                }
            }
            return dummy.next;
        }

        public ListNode reverse(ListNode pre, ListNode next) {
            ListNode start = pre.next;
            ListNode cur = start.next;
            while (cur != next) {
                start.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = start.next;
            }
            return start;
        }
    }

    // My stupid solution.
    public class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k < 2) return head;
            int counter = 0;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode preStart = dummy;
            ListNode start = head;
            ListNode end = head;
            while (end != null) {
                counter++;
                if (counter % k == 0) {
                    reverse(preStart, start, 0, k - 1);
                    // Because start is at the end now.
                    preStart = start;
                    end = start = preStart.next;
                    continue;
                }
                end = end.next;
            }
            return dummy.next;
        }

        private void reverse(ListNode preStartNode, ListNode startNode, int start, int end) {
            if (start >= end) return;
            ListNode preEndNode = startNode;
            int count = end - start;
            while (count > 1) {
                preEndNode = preEndNode.next;
                count--;
            }
            ListNode endNode = preEndNode.next;
            if (preEndNode == startNode) {
                startNode.next = endNode.next;
                endNode.next = startNode;
                preStartNode.next = endNode;
            } else {
                ListNode tempStartNext = startNode.next;
                startNode.next = endNode.next;
                preEndNode.next = startNode;
                preStartNode.next = endNode;
                endNode.next = tempStartNext;
                // End is at the start point now.
                reverse(endNode, endNode.next, ++start, --end);
            }
        }
    }
}
