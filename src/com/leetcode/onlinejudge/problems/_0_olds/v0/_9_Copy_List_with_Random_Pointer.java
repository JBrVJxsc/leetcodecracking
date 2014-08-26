package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.RandomListNode;

import java.util.ArrayList;

/**
 * Created by Who on 2014/6/28.
 */
public class _9_Copy_List_with_Random_Pointer extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getName() {
        return "[UNSOLVED]Copy List with Random Pointer";
    }

    @Override
    public String getSummary() {
        return "A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.\n" +
                "Return a deep copy of the list.";
    }

    @Override
    public void run() {
        RandomListNode root = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        root.next = node1;
        RandomListNode node2 = new RandomListNode(2);
        node1.next = node2;
        RandomListNode node3 = new RandomListNode(3);
        node2.next = node3;
        root.random = node1;
        node1.random = node2;
        node2.random = root;
        node3.random = node3;
        RandomListNode copied = new Solution().copyRandomList(root);
    }

    public class Solution {

        private int getIndex(RandomListNode pointer, RandomListNode head) {
            RandomListNode node = head;
            int index = -1;
            while (node != null) {
                index++;
                if (pointer.random == node) {
                    break;
                }
                node = node.next;
            }
            return index;
        }

        private RandomListNode getRandomListNode(int index, RandomListNode head) {
            if (index < 0) {
                return null;
            }
            RandomListNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) {
                return null;
            }
            //Copy the basic nodes first.
            RandomListNode newRandomListNode = new RandomListNode(head.label);
            RandomListNode pointer = newRandomListNode;
            RandomListNode node = head.next;
            while (node != null) {
                RandomListNode newNode = new RandomListNode(node.label);
                pointer.next = newNode;
                pointer = newNode;
                node = node.next;
            }
            //Get the index of the random nodes of each nodes.
            node = head;
            ArrayList<Integer> mapArrayList = new ArrayList<Integer>();
            while (node != null) {
                mapArrayList.add(getIndex(node, head));
                node = node.next;
            }
            //Get the random nodes for each nodes.
            node = newRandomListNode;
            int counter = 0;
            while (node != null) {
                node.random = getRandomListNode(mapArrayList.get(counter), newRandomListNode);
                node = node.next;
                counter++;
            }
            return newRandomListNode;
        }
    }
}
