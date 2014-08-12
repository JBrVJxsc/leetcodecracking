package com.leetcode.onlinejudge.common;

/**
 * Created by Who on 2014/6/30.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
