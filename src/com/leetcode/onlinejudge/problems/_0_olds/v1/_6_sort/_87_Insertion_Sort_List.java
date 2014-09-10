package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/8/16.
 */
public class _87_Insertion_Sort_List extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Sort a linked list using insertion sort.";
    }

    @Override
    public void run() {
        print(new Solution().insertionSortList(ListNode.getListNode(3, 2, 1, 5, 4, 7, 6)));
    }

    public class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode next = head;
            while (next != null) {
                ListNode dummyNext = dummy;
                while (dummyNext.next != null && dummyNext.next.val < next.val) {
                    dummyNext = dummyNext.next;
                }
                ListNode temp = next.next;
                next.next = dummyNext.next;
                dummyNext.next = next;
                next = temp;
            }
            return dummy.next;
        }
    }
}
