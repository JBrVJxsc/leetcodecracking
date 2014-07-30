package com.leetcode.onlinejudge.common;

/**
 * Created by Who on 2014/6/27.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode getLastOne() {
        ListNode next = this;
        while (next.next != null) {
            next = next.next;
        }
        return next;
    }

    public static ListNode getListNode(int... values) {
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int value : values) {
            next.next = new ListNode(value);
            next = next.next;
        }
        return root.next;
    }

    @Override
    public String toString() {
        ListNode next = this;
        String string = "";
        while (next != null) {
            if (next.next != null)
                string += next.val + " -> ";
            else string += next.val + " -> NULL";
            next = next.next;
        }
        return string;
    }
}