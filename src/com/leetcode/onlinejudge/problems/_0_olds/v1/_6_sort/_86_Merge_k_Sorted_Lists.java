package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/16.
 */
public class _86_Merge_k_Sorted_Lists extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.";
    }

    @Override
    public void run() {
        List<ListNode> listNodes = new ArrayList<ListNode>();
        listNodes.add(new ListNode(1));
        listNodes.add(new ListNode(0));
        print(new Solution().mergeKLists(listNodes));
    }

    public class Solution {
        public ListNode mergeKLists(List<ListNode> lists) {
            while (lists.contains(null)) {
                lists.remove(null);
            }
            if (lists.size() == 0) {
                return null;
            }
            if (lists.size() == 1) {
                return lists.get(0);
            }
            ListNode dummy = new ListNode(-1);
            ListNode next = dummy;
            ListNode l1 = lists.get(0);
            for (int i = 1; i < lists.size(); i++) {
                ListNode l2 = lists.get(i);
                while (l1 != null && l2 != null) {
                    if (l1.val > l2.val) {
                        next.next = l2;
                        l2 = l2.next;
                    } else {
                        next.next = l1;
                        l1 = l1.next;
                    }
                    next = next.next;
                }
                next.next = l1 == null ? l2 : l1;
                l1 = dummy.next;
                if (i < lists.size() - 1) {
                    dummy = new ListNode(-1);
                    next = dummy;
                }
            }
            return dummy.next;
        }
    }
}
