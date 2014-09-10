package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/7/29.
 */
public class _29_Remove_Duplicates_from_Sorted_List_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.\n" +
                "For example,\n" +
                "Given 1->2->3->3->4->4->5, return 1->2->5.\n" +
                "Given 1->1->1->2->3, return 2->3.";
    }

    @Override
    public void run() {
        ListNode n1 = ListNode.getListNode(1, 2, 3, 3, 4, 4, 5);
        ListNode n2 = ListNode.getListNode(1, 1, 1, 2, 3);
        ListNode n3 = ListNode.getListNode(1, 2, 2);
        print(new Solution().deleteDuplicates(n1));
        print(new Solution().deleteDuplicates(n2));
        print(new Solution().deleteDuplicates(n3));
    }

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode result = new ListNode(0);
            ListNode next = result;
            ListNode nextValid;
            do {
                nextValid = getNextNod(head);
                next.next = nextValid;
                if (nextValid != null) {
                    head = nextValid.next;
                    next = next.next;
                }
            } while (nextValid != null);
            return result.next;
        }

        private ListNode getNextNod(ListNode node) {
            if (node == null) return null;
            if (node.next == null || node.val != node.next.val) return node;
            ListNode next = node.next.next;
            while (next != null) {
                if (next.val != node.val)
                    break;
                next = next.next;
            }
            if (next == null)
                return null;
            return getNextNod(next);
        }
    }
}
