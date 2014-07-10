package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/25.
 */
public class p6 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "[UNSOLVED]LRU Cache";
    }

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

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void set(int key, int value) {

        }
    }
}
