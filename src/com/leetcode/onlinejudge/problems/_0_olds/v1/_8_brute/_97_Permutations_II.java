package com.leetcode.onlinejudge.problems._0_olds.v1._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _97_Permutations_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a collection of numbers that might contain duplicates, return all possible unique permutations.\n" +
                "For example,\n" +
                "[1,1,2] have the following unique permutations:\n" +
                "[1,1,2], [1,2,1], and [2,1,1].";
    }

    @Override
    public String getNote() {
        return "Same code with last problem.";
    }

    @Override
    public void run() {

    }

    public class Solution {

        public List<List<Integer>> permuteUnique(int[] num) {
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
