package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Who on 2014/7/25.
 */
public class _10_4Sum extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?\n" +
                "Find all unique quadruplets in the array which gives the sum of target.\n" +
                "Note:\n" +
                "• Elements in a quadruplet (a, b, c, d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)\n" +
                "• The solution set must not contain duplicate quadruplets.\n" +
                "For example, given array S = {1 0 -1 0 -2 2}, and target = 0.\n" +
                "A solution set is:\n" +
                "(-1, 0, 0, 1)\n" +
                "(-2, -1, 1, 2)\n" +
                "(-2, 0, 0, 2)";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        a = new int[]{-1, 0, 1, 2, -1, -4};
        print(new Solution().fourSum1(a, -1));
    }

    public class Solution {
        public List<List<Integer>> fourSum(int[] num, int target) {
            HashSet<List<Integer>> listHashSet = new HashSet<List<Integer>>();
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++)
                for (int j = i + 1; j < num.length; j++) {
                    int negate = target - num[i] - num[j];
                    int start = j + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[j]);
                            subList.add(2, num[start]);
                            subList.add(3, num[end]);
                            if (!listHashSet.contains(subList)) {
                                list.add(subList);
                                listHashSet.add(subList);
                            }
                            start++;
                            end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            return list;
        }

        public List<List<Integer>> fourSum1(int[] num, int target) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            HashSet<List<Integer>> listHashSet = new HashSet<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++)
                for (int j = i + 1; j < num.length; j++) {
                    int negate = target - num[i] - num[j];
                    int start = j + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[j]);
                            subList.add(2, num[start]);
                            subList.add(3, num[end]);
                            if (!listHashSet.contains(subList)) {
                                list.add(subList);
                                listHashSet.add(subList);
                            }
                            start++;
                            end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            return list;
        }
    }
}
