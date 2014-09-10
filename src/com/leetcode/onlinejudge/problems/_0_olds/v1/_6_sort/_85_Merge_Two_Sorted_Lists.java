package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _85_Merge_Two_Sorted_Lists extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.";
    }

    @Override
    public void run() {
        ListNode l1 = ListNode.getListNode(-9, 3);
        ListNode l2 = ListNode.getListNode(5, 7);
        print(new Solution().mergeTwoLists(l1, l2));
    }

    // A better solution.
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode next = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    next.next = l2;
                    l2 = l2.next;
                } else {
                    next.next = l1;
                    l1 = l1.next;
                }
                next = next.next;
            }
            next.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }

    public class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            for (; l1 != null && l2 != null; p = p.next) {
                if (l1.val > l2.val) {
                    p.next = l2;
                    l2 = l2.next;
                } else {
                    p.next = l1;
                    l1 = l1.next;
                }
            }
            p.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }

    // My solution with too much codes.
    public class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = l1;
            ListNode preL1 = dummy;
            ListNode curL1 = l1;
            ListNode curL2 = l2;
            while (curL1 != null && curL2 != null) {
                ListNode temp = curL2;
                curL2 = curL2.next;
                if (curL1.val > temp.val) {
                    temp.next = curL1;
                    preL1.next = temp;
                    preL1 = preL1.next;
                } else {
                    while (curL1.next != null && curL1.next.val < temp.val) {
                        curL1 = curL1.next;
                        preL1 = preL1.next;
                    }
                    temp.next = curL1.next;
                    curL1.next = temp;
                    curL1 = temp.next;
                    preL1 = temp;
                }
            }
            if (curL1 == null) {
                preL1.next = curL2;
            }
            return dummy.next;
        }
    }
}
