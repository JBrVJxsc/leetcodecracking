package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

import java.util.Stack;

/**
 * Created by Who on 2014/7/29.
 */
public class _30_Rotate_List extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a list, rotate the list to the right by k places, where k is non-negative.\n" +
                "For example:\n" +
                "Given 1->2->3->4->5->NULL and k = 2,\n" +
                "return 4->5->1->2->3->NULL.";
    }

    @Override
    public void run() {
        ListNode l1 = ListNode.getListNode(1, 2, 3, 4, 5);
        ListNode l2 = ListNode.getListNode(1);
        print(new Solution().rotateRight(l2, 1));
    }

    public class Solution {
        public ListNode rotateRight(ListNode head, int n) {
            return null;
        }
    }

    // My wrong answer.
    public class Solution1 {
        public ListNode rotateRight(ListNode head, int n) {
            if (head == null || n == 0) return head;
            ListNode next = head;
            Stack<ListNode> nodeStack = new Stack<ListNode>();
            int count = 0;
            while (next != null) {
                nodeStack.push(next);
                next = next.next;
                count++;
            }
            if (n >= count) return head;
            ListNode result = null;
            ListNode tail = null;
            for (int i = 0; i < n; i++) {
                result = nodeStack.pop();
                if (i == 0) tail = result;
            }
            if (!nodeStack.empty())
                nodeStack.pop().next = null;
            else return result;
            tail.next = head;
            return result;
        }
    }
}
