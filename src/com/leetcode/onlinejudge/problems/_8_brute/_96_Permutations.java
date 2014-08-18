package com.leetcode.onlinejudge.problems._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _96_Permutations extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given a collection of numbers, return all possible permutations.\n" +
                "For example,\n" +
                "[1,2,3] have the following permutations:\n" +
                "[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].";
    }

    @Override
    public void run() {
        new Solution().permute(new int[]{1, 2, 2});
    }

    public class Solution {
        public List<List<Integer>> permute(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            while (getNext(lists, num)) {

            }
            return lists;
        }

        private boolean getNext(List<List<Integer>> lists, int[] num) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i : num) {
                list.add(i);
            }
            lists.add(list);
            // Find partition.
            int partition = -1;
            for (int i = num.length - 1; i > 0; i--) {
                if (num[i] > num[i - 1]) {
                    partition = i - 1;
                    break;
                }
            }
            if (partition == -1) {
                return false;
            }
            // Find change.
            int change = -1;
            for (int i = num.length - 1; i > 0; i--) {
                if (num[i] > num[partition]) {
                    change = i;
                    break;
                }
            }
            // Swap.
            swap(num, partition, change);
            // Reverse.
            int start = partition + 1;
            int end = num.length - 1;
            while (start < end) {
                swap(num, start, end);
                start++;
                end--;
            }
            return true;
        }

        private void swap(int[] num, int a, int b) {
            int temp = num[a];
            num[a] = num[b];
            num[b] = temp;
        }
    }
}
