package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _22_Candy extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "There are N children standing in a line. Each child is assigned a rating value.\n" +
                "You are giving candies to these children subjected to the following requirements:\n" +
                "Each child must have at least one candy.\n" +
                "Children with a higher rating get more candies than their neighbors.\n" +
                "What is the minimum candies you must give?";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 2, 3};
        print(new Solution().candy(a));
    }

    public class Solution {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            left[0] = 1;
            right[ratings.length - 1] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i])
                    left[i] = left[i - 1] + 1;
                else left[i] = 1;
                int ri = ratings.length - 1 - i;
                if (ratings[ri] > ratings[ri + 1])
                    right[ri] = right[ri + 1] + 1;
                else right[ri] = 1;
            }
            int total = 0;
            for (int i = 0; i < ratings.length; i++)
                total += Math.max(left[i], right[i]);
            return total;
        }

        public int candy1(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int total = 0;
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            left[0] = right[ratings.length - 1] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i])
                    left[i] = left[i - 1] + 1;
                else left[i] = 1;
                if (ratings[ratings.length - 1 - i] > ratings[ratings.length - i])
                    right[ratings.length - 1 - i] = ratings[ratings.length - i] + 1;
                else
                    right[ratings.length - 1 - i] = 1;
            }
            for (int i = 0; i < ratings.length; i++)
                total += Math.max(left[i], right[i]);
            return total;
        }

        public int candy2(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int total = 0;
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            left[0] = right[ratings.length - 1] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1])
                    left[i] = left[i - 1] + 1;
                else left[i] = 1;
                if (ratings[ratings.length - 1 - i] > ratings[ratings.length - i])
                    right[ratings.length - 1 - i] = right[ratings.length - i] + 1;
                else right[ratings.length - 1 - i] = 1;
            }
            for (int i = 0; i < ratings.length; i++)
                total += Math.max(left[i], right[i]);
            return total;
        }

        public int candy3(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int total = 0;
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            left[0] = right[ratings.length - 1] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1])
                    left[i] = left[i - 1] + 1;
                else left[i] = 1;
                if (ratings[ratings.length - 1 - i] > ratings[ratings.length - i])
                    right[ratings.length - 1 - i] = right[ratings.length - i];
                else right[ratings.length - 1 - i] = 1;
            }
            for (int i = 0; i < ratings.length; i++)
                total += Math.max(left[i], right[i]);
            return total;
        }
    }

    // My (n^3)/2 solution. Got TLE.
    public class Solution1 {
        public int candy(int[] ratings) {
            if (ratings.length == 1) return 1;
            int[] nums = new int[ratings.length];
            nums[0] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1])
                    nums[i] = nums[i - 1] + 1;
                else if (ratings[i] <= ratings[i - 1]) {
                    nums[i] = 1;
                    if (nums[i - 1] == 1)
                        addOne(nums, ratings, i - 1);
                }
            }
            int total = 0;
            for (int i : nums)
                total += i;
            return total;
        }

        private void addOne(int[] nums, int[] ratings, int index) {
            if (index < 0) return;
            nums[index]++;
            if (index >= 1 && ratings[index - 1] > ratings[index] && nums[index - 1] == nums[index])
                addOne(nums, ratings, index - 1);
        }
    }

    // Solution with O(n) complexity of space. It's better than my final one, but it's hard to remember.
    public class Solution2 {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) {
                return 0;
            }
            int[] nums = new int[ratings.length];
            nums[0] = 1;

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    nums[i] = nums[i - 1] + 1;
                } else {
                    nums[i] = 1;
                }
            }
            int res = nums[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                int cur = 1;
                if (ratings[i] > ratings[i + 1]) {
                    cur = nums[i + 1] + 1;
                }
                res += Math.max(cur, nums[i]);
                nums[i] = cur;
            }
            return res;
        }
    }
}
