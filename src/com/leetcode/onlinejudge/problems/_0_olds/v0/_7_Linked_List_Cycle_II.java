package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/6/27.
 */
public class _7_Linked_List_Cycle_II extends BaseProblem implements IProblem {

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
        return "[HELPED]Linked List Cycle II";
    }

    @Override
    public String getSummary() {
        return "Given a linked list, return the node where the cycle begins. If there is no cycle, return null.\n" +
                "Follow up:\n" +
                "Can you solve it without using extra space?";
    }

    @Override
    public void run() {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        ListNode node10 = new ListNode(10);
        node9.next = node10;
        ListNode node11 = new ListNode(11);
        node10.next = node11;
        ListNode node12 = new ListNode(12);
        node11.next = node12;
        ListNode node13 = new ListNode(13);
        node12.next = node13;
        ListNode node14 = new ListNode(14);
        node13.next = node14;
        ListNode node15 = new ListNode(15);
        node14.next = node15;
        ListNode node16 = new ListNode(16);
        node15.next = node16;
        ListNode node17 = new ListNode(17);
        node16.next = node17;
        ListNode node18 = new ListNode(18);
        node17.next = node18;
        ListNode node19 = new ListNode(19);
        node18.next = node19;
        ListNode node20 = new ListNode(20);
        node19.next = node20;
        ListNode node21 = new ListNode(21);
        node20.next = node21;
        ListNode node22 = new ListNode(22);
        node21.next = node22;
        ListNode node23 = new ListNode(23);
        node22.next = node23;
        ListNode node24 = new ListNode(24);
        node23.next = node24;
        ListNode node25 = new ListNode(25);
        node24.next = node25;
        ListNode node26 = new ListNode(26);
        node25.next = node26;
        ListNode node27 = new ListNode(27);
        node26.next = node27;
        ListNode node28 = new ListNode(28);
        node27.next = node28;
        node28.next = node24;
        print(new Solution().detectCycle(root).val);
    }

    public class Solution {

        private int hit(ListNode slow, ListNode fast) {
            int hit = 0;
            if (fast == null || fast.next == null) {
                hit = -1;
            } else if (slow == fast || slow == fast.next) {
                hit = 1;
            }
            return hit;
        }

        private ListNode cycleHit(ListNode test, ListNode cycle) {
            //Because there must be a cycle, so there is no need to check if these two args are null.
            ListNode start = cycle;
            ListNode cycling = cycle.next;
            while (true) {
                if (test == cycling) {
                    return test;
                }
                if (start == cycling) {
                    return null;
                }
                cycling = cycling.next;
            }
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (true) {
                int result = hit(slow, fast);
                if (result < 0) {
                    return null;
                } else if (result > 0) {
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            //So, if the code runs in here, it means that there have to have a cycle.
            ListNode test = head;
            while (true) {
                ListNode hit = cycleHit(test, slow);
                if (hit != null) {
                    return hit;
                }
                test = test.next;
            }
        }
    }
}
