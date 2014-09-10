package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashMap;

/**
 * Created by Who on 2014/8/7.
 */
public class _38_LRU_Cache extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.\n" +
                "get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.\n" +
                "set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.";
    }

    @Override
    public void run() {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        cache.set(2, 3);
        cache.set(4, 1);
        print(cache.get(1));
        print(cache.get(2));
    }

    public class LRUCache {
        private HashMap<Integer, Node> map
                = new HashMap<Integer, Node>();
        private Node head;
        private Node end;
        private int capacity;
        private int len;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            len = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node latest = map.get(key);
                removeNode(latest);
                setHead(latest);
                return latest.val;
            } else {
                return -1;
            }
        }

        public void removeNode(Node node) {
            Node cur = node;
            Node pre = cur.pre;
            Node post = cur.next;

            if (pre != null) {
                pre.next = post;
            } else {
                head = post;
            }

            if (post != null) {
                post.pre = pre;
            } else {
                end = pre;
            }
        }

        public void setHead(Node node) {
            node.next = head;
            node.pre = null;
            if (head != null) {
                head.pre = node;
            }

            head = node;
            if (end == null) {
                end = node;
            }
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                oldNode.val = value;
                removeNode(oldNode);
                setHead(oldNode);
            } else {
                Node newNode =
                        new Node(key, value);
                if (len < capacity) {
                    len++;
                } else {
                    map.remove(end.key);
                    end = end.pre;
                    if (end != null) {
                        end.next = null;
                    }
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    class Node {
        public int val;
        public int key;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            val = value;
            this.key = key;
        }
    }
}
