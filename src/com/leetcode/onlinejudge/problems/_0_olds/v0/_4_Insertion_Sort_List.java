package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

import java.util.Stack;

/**
 * Created by Who on 2014/6/25.
 */
public class _4_Insertion_Sort_List extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getSummary() {
        return "Sort a linked list using insertion sort.";
    }

    @Override
    public void run() {
        ListNode root = new ListNode(101);
        root.next = new ListNode(100);
        root.next.next = new ListNode(99);
        root.next.next.next = new ListNode(98);
        ListNode rootSorted = new Solution().insertionSortList(root);
    }

    public class Solution {

        private void exc(ListNode node, ListNode next) {
            int val = node.val;
            node.val = next.val;
            next.val = val;
        }

        private int compare(ListNode node, ListNode next) {
            return Integer.compare(node.val, next.val);
        }

        private void sort(ListNode node) {
            if (node.next == null) {
                return;
            }
            if (compare(node, node.next) > 0) {
                exc(node, node.next);
                sort(node.next);
            }
        }

        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode next = head.next;
            Stack<ListNode> stackNode = new Stack<ListNode>();
            stackNode.push(head);
            while (next != null) {
                stackNode.push(next);
                next = next.next;
            }
            while (!stackNode.empty()) {
                sort(stackNode.pop());
            }
            return head;
        }
    }
}
