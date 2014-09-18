package com.leetcode.onlinejudge.problems.sketchbook;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Xu on 9/18/14.
 */
public class CC150_2_4 extends BaseProblem implements IProblem {
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
        return null;
    }

    @Override
    public void run() {
        ListNode a = ListNode.getListNode(3, 1, 5);
        ListNode b = ListNode.getListNode(5, 9, 2);
        print(addList(a, b));
    }

    public ListNode addList(ListNode a, ListNode b) {
        int remain = 0;
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        while (a != null && b != null) {
            int i = a == null ? 0 : a.val;
            int j = b == null ? 0 : b.val;
            remain += i + j;
            next.next = new ListNode(remain % 10);
            remain /= 10;
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
            next = next.next;
        }
        return dummy.next;
    }
}
