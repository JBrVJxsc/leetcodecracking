package com.leetcode.onlinejudge.problems._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Who on 2014/8/7.
 */
public class _38_LRU_Cache extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.\n" +
                "get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.\n" +
                "set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.";
    }

    @Override
    public void run() {

    }

    public class LRUCache {

        public class Node {
            public Node preNode = null;
            public Node nextNode = null;
            public int key;
            public int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        private LinkedList<Integer> linkedList = new LinkedList<Integer>();
        private int maxSize = 0;

        public LRUCache(int capacity) {
            maxSize = capacity;
        }

        public int get(int key) {
            return hashMap.get(key);
        }

        public void set(int key, int value) {

        }
    }
}
