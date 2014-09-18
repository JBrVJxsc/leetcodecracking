package com.leetcode.onlinejudge.problems.sketchbook;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Xu on 9/18/14.
 */
public class CC150_2_1 extends BaseProblem implements IProblem {
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
        ListNode listNode = ListNode.getListNode(1, 2, 3, 4, 2, 2, 5, 3, 0);
        print(listNode.toString());
        removeDuplicate(listNode);
        print(listNode.toString());
    }

    private void removeDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur = head.next;
        ListNode preCur = head;
        ListNode next = head.next;
        ListNode preNext = head;
        while (next != null) {
            ListNode n = head;
            while (n != null && n.val != next.val && n != cur) {
                n = n.next;
            }
            if (n == cur) {
                preNext.next = next.next;
                next.next = cur.next;
                preCur.next = next;
                preCur = next;
                cur = preCur.next;
                next = preNext.next;
            } else {
                preNext = preNext.next;
                next = next.next;
            }
        }
        preCur.next = null;
    }
}
