package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _88_Sort_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Sort a linked list in O(n log n) time using constant space complexity.";
    }

    @Override
    public void run() {
        ListNode l1 = ListNode.getListNode(7, 7, 7, 8, 8, 8, 8, 9, 9, 5, 4, 3, 2);
        print(new Solution().sortList(l1));
    }

    // A better merge sort solution with constant space complexity.
    public class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode temp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(temp);
            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(0);
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

    // My first merge sort version with no constant space complexity.
    public class Solution1 {
        public ListNode sortList(ListNode head) {
            int length = 0;
            ListNode next = head;
            while (next != null) {
                length++;
                next = next.next;
            }
            return sort(head, length);
        }

        private ListNode sort(ListNode node, int length) {
            if (node == null) {
                return null;
            }
            if (length == 1) {
                return node;
            }
            int half = length / 2;
            ListNode next = node;
            int counter = 0;
            while (counter < half) {
                next = next.next;
                counter++;
            }
            ListNode left = sort(node, half);
            ListNode right = sort(next, length - half);
            return merge(left, half, right, length - half);
        }

        private ListNode merge(ListNode l1, int l1Len, ListNode l2, int l2Len) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode next = dummy;
            while (l1Len > 0 && l2Len > 0) {
                if (l1.val > l2.val) {
                    next.next = new ListNode(l2.val);
                    l2 = l2.next;
                    l2Len--;
                } else {
                    next.next = new ListNode(l1.val);
                    l1 = l1.next;
                    l1Len--;
                }
                next = next.next;
            }
            if (l1Len > 0) {
                while (l1Len > 0) {
                    next.next = new ListNode(l1.val);
                    l1 = l1.next;
                    next = next.next;
                    l1Len--;
                }
            } else if (l2Len > 0) {
                while (l2Len > 0) {
                    next.next = new ListNode(l2.val);
                    l2 = l2.next;
                    next = next.next;
                    l2Len--;
                }
            }
            return dummy.next;
        }
    }
}
