package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/6/30.
 */
public class _21_Remove_Duplicates_from_Sorted_List extends BaseProblem implements IProblem {

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
        return "Given a sorted linked list, delete all duplicates such that each element appear only once.\n" +
                "For example,\n" +
                "Given 1->1->2, return 1->2.\n" +
                "Given 1->1->2->3->3, return 1->2->3.";
    }

    @Override
    public void run() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);
        ListNode node = new Solution().deleteDuplicates(root);
    }

    public class Solution {

        private ListNode getNext(ListNode head, int val) {
            ListNode node = head;
            while (node != null) {
                if (node.val != val) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            while (node != null) {
                node.next = getNext(node.next, node.val);
                node = node.next;
            }
            return head;
        }
    }
}
