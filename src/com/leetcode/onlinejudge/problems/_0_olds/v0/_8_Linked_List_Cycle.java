package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

/**
 * Created by Who on 2014/6/27.
 */
public class _8_Linked_List_Cycle extends BaseProblem implements IProblem {

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
        return "Given a linked list, determine if it has a cycle in it.\n" +
                "Follow up:\n" +
                "Can you solve it without using extra space?";
    }

    @Override
    public void run() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = root.next.next;
        print(new Solution().hasCycle(root));
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

        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (true) {
                int result = hit(slow, fast);
                if (result > 0) {
                    return true;
                } else if (result < 0) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }
}
