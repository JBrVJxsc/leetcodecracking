package com.leetcode.onlinejudge.common;

import com.leetcode.common.Random;

import java.util.HashMap;

/**
 * Created by Who on 2014/6/28.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }

    public static RandomListNode getRandomListNode(int... lables) {
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        int index = 0;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode next = dummy;
        for (int i : lables) {
            next.next = new RandomListNode(i);
            map.put(index++, next.next);
            next = next.next;
        }
        next = dummy;
        while (next.next != null) {
            index = Random.getInt(lables.length + 1);
            if (index != lables.length)
                next.next.random = map.get(Random.getInt(lables.length));
            next = next.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        RandomListNode next = this;
        String string = "";
        while (next != null) {
            if (next.next != null)
                string += next.label + " (" + (next.random == null ? "NULL" : next.random.label) + ") -> ";
            else string += next.label + " (" + (next.random == null ? "NULL" : next.random.label) + ") -> NULL";
            next = next.next;
        }
        return string;
    }
}
