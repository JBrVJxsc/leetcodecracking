package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Who on 2014/7/25.
 */
public class _6_Longest_Consecutive_Sequence extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an unsorted array of integers, find the length of the longest consecutive elements sequence.\n" +
                "For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.\n" +
                "Your algorithm should run in O(n) complexity.";
    }

    @Override
    public void run() {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        ints = new int[]{1, 0, -1};
        print(new Solution().longestConsecutive(ints));
    }

    public class Solution {
        public int longestConsecutive(int[] num) {
            Set<Integer> set = new HashSet<Integer>();
            int max = 1;
            for (int e : num)
                set.add(e);
            for (int e : num) {
                int left = e - 1;
                int right = e + 1;
                int count = 1;
                while (set.contains(left)) {
                    count++;
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    count++;
                    set.remove(right);
                    right++;
                }
                max = Math.max(count, max);
            }
            return max;
        }

        public int longestConsecutive1(int[] num) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i : num)
                set.add(i);
            int max = 1;
            for (int i : num) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;

                set.remove(i);
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }
                max = max > count ? max : count;
            }
            return max;
        }

        public int longestConsecutive2(int[] num) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i : num) set.add(i);
            int max = 1;
            for (int i : num) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                set.remove(i);
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }
                max = Math.max(max, count);
            }
            return max;
        }

        public int longestConsecutive3(int[] num) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i : num) set.add(i);
            int max = 1;
            for (int i : num) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                set.remove(i);
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }
                max = Math.max(max, count);
            }
            return max;
        }

        public int longestConsecutive4(int[] num) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i : num) set.add(i);
            int max = 1;
            for (int i : num) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                set.remove(i);
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }
                max = Math.max(max, count);
            }
            return max;
        }

        public int longestConsecutive5(int[] num) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i : num) set.add(i);
            int max = 1;
            for (int i : num) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                set.remove(i);
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
