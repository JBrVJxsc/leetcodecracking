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
public class _8_3Sum extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.\n" +
                "Note:\n" +
                "Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)\n" +
                "The solution set must not contain duplicate triplets.\n" +
                "    For example, given array S = {-1 0 1 2 -1 -4},\n" +
                "    A solution set is:\n" +
                "    (-1, 0, 1)\n" +
                "    (-1, -1, 2)";
    }

    @Override
    public void run() {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        a = new int[]{0, 0, 0, 0};
        List<List<Integer>> list = new Solution().threeSum(a);
        print(list);
    }

    public class Solution {

        public List<List<Integer>> threeSum(int[] num) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                if (i == 0 || num[i] > num[i - 1]) {
                    int negate = -num[i];
                    int start = i + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[start]);
                            subList.add(2, num[end]);
                            list.add(subList);
                            start++;
                            end--;
                            while (start < end && num[start] == num[start - 1]) start++;
                            while (start < end && num[end] == num[end + 1]) end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            }
            return list;
        }

        public List<List<Integer>> threeSum1(int[] num) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                if (i == 0 || num[i - 1] < num[i]) {
                    int negate = -num[i];
                    int start = i + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[start]);
                            subList.add(2, num[end]);
                            list.add(subList);
                            start++;
                            end--;
                            while (start < end && num[start] == num[start - 1]) start++;
                            while (start < end && num[end] == num[end + 1]) end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            }
            return list;
        }

        public List<List<Integer>> threeSum2(int[] num) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                if (i == 0 || num[i - 1] < num[i]) {
                    int negate = -num[i];
                    int start = i + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[start]);
                            subList.add(2, num[end]);
                            list.add(subList);
                            start++;
                            end--;
                            while (start < end && num[start] == num[start - 1]) start++;
                            while (start < end && num[end] == num[end + 1]) end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            }
            return list;
        }

        public List<List<Integer>> threeSum3(int[] num) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length; i++) {
                if (i == 0 || num[i - 1] < num[i]) {
                    int negate = -num[i];
                    int start = i + 1;
                    int end = num.length - 1;
                    while (start < end) {
                        if (num[start] + num[end] == negate) {
                            ArrayList<Integer> subList = new ArrayList<Integer>();
                            subList.add(0, num[i]);
                            subList.add(1, num[start]);
                            subList.add(2, num[end]);
                            list.add(subList);
                            start++;
                            end--;
                            while (start < end && num[start] == num[start - 1]) start++;
                            while (start < end && num[end] == num[end + 1]) end--;
                        } else if (num[start] + num[end] < negate) start++;
                        else end--;
                    }
                }
            }
            return list;
        }
    }

    // It's O(n^2*log(n)). There is a better one above.
    public class Solution1 {
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            HashSet<List<Integer>> listMap = new HashSet<List<Integer>>();

            for (int i = 0; i < num.length; i++)
                for (int j = i + 1; j < num.length; j++)
                    if (binarySearch(num, j + 1, num.length - 1, -num[i] - num[j])) {
                        ArrayList<Integer> subList = new ArrayList<Integer>();
                        subList.add(0, num[i]);
                        subList.add(1, num[j]);
                        subList.add(2, -num[i] - num[j]);
                        if (!listMap.contains(subList)) {
                            list.add(subList);
                            listMap.add(subList);
                        }
                    }
            return list;
        }

        private boolean binarySearch(int[] A, int start, int end, int target) {
            if (start > end) return false;
            int middle = start + (end - start) / 2;
            if (target == A[middle]) return true;
            if (target < A[middle])
                return binarySearch(A, start, middle - 1, target);
            else return binarySearch(A, middle + 1, end, target);
        }

        public List<List<Integer>> threeSum1(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            HashSet<List<Integer>> listMap = new HashSet<List<Integer>>();
            for (int i = 0; i < num.length; i++)
                for (int j = i + 1; j < num.length; j++)
                    if (binarySearch1(num, j + 1, num.length - 1, -num[i] - num[j])) {
                        ArrayList<Integer> subList = new ArrayList<Integer>();
                        subList.add(0, num[i]);
                        subList.add(1, num[j]);
                        subList.add(2, -num[i] - num[j]);
                        if (!listMap.contains(subList)) {
                            list.add(subList);
                            listMap.add(subList);
                        }
                    }
            return list;
        }

        private boolean binarySearch1(int[] A, int start, int end, int target) {
            if (start > end) return false;
            int middle = start + (end - start) / 2;
            if (target == A[middle]) return true;
            if (target < A[middle])
                return binarySearch1(A, start, middle - 1, target);
            else return binarySearch1(A, middle + 1, end, target);
        }
    }
}
