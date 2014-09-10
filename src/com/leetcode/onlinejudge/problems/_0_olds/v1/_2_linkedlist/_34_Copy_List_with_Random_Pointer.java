package com.leetcode.onlinejudge.problems._0_olds.v1._2_linkedlist;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.RandomListNode;

import java.util.HashMap;

/**
 * Created by Who on 2014/7/31.
 */
public class _34_Copy_List_with_Random_Pointer extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.\n" +
                "Return a deep copy of the list.";
    }

    @Override
    public void run() {
        RandomListNode r1 = RandomListNode.getRandomListNode(1, 2, 3, 4, 5, 6, 7, 8);
        print(r1);
        RandomListNode r2 = new Solution1().copyRandomList(r1);
        print(r2);
    }

    // A better solution without HashMap.
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null)
                return null;
            RandomListNode p = head;
            // copy every node and insert to list
            while (p != null) {
                RandomListNode copy = new RandomListNode(p.label);
                copy.next = p.next;
                p.next = copy;
                p = copy.next;
            }

            print(head);

            // copy random pointer for each new node
            p = head;
            while (p != null) {
                if (p.random != null)
                    p.next.random = p.random.next;
                p = p.next.next;
            }
            // break list to two
            p = head;
            RandomListNode newHead = head.next;
            while (p != null) {
                RandomListNode temp = p.next;
                p.next = temp.next;
                if (temp.next != null)
                    temp.next = temp.next.next;
                p = p.next;
            }
            return newHead;
        }
    }

    // My HashMap solution. Get wrong answer.
    public class Solution1 {
        public RandomListNode copyRandomList(RandomListNode head) {
            HashMap<RandomListNode, Integer> oldMap = new HashMap<RandomListNode, Integer>();
            HashMap<Integer, RandomListNode> dummyMap = new HashMap<Integer, RandomListNode>();
            RandomListNode next = head;
            RandomListNode dummy = new RandomListNode(0);
            RandomListNode dummyNext = dummy;
            int index = 0;
            while (next != null) {
                dummyNext.next = new RandomListNode(next.label);
                dummyMap.put(index, dummyNext.next);
                oldMap.put(next, index++);
                next = next.next;
                dummyNext = dummyNext.next;
            }
            next = head;
            index = 0;
            while (next != null) {
                if (next.random != null) {
                    int i = oldMap.get(next.random);
                    dummyMap.get(index).random = dummyMap.get(i);
                }
                index++;
                next = next.next;
            }
            return dummy.next;
        }
    }
}
