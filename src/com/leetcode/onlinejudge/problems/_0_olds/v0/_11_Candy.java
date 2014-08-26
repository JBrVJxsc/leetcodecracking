package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class _11_Candy extends BaseProblem implements IProblem {

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
        return "[UNSOLVED: TLE]Candy";
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
        int[] ratings = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2};
        ratings = new int[]{1, 2, 2};
        ratings = new int[]{2, 1};
        ratings = new int[12000];
        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = 12000 - i;
        }
        print(new Solution().candy(ratings));
    }

    public class Solution {

        private int[] numbers = null;
        private int[] ratings = null;

        private void backCheck(int index) {
            if (index < 1) {
                return;
            }
            if (ratings[index] < ratings[index - 1]) {
                if (numbers[index] >= numbers[index - 1]) {
                    numbers[index - 1] = numbers[index] + 1;
                    backCheck(index - 1);
                }
            }
        }

        public int candy(int[] ratings) {
            if (ratings == null) {
                return 0;
            }
            if (ratings.length == 1) {
                return 1;
            }
            this.ratings = ratings;
            numbers = new int[this.ratings.length];
            numbers[0] = 1;
            for (int i = 1; i < this.ratings.length; i++) {
                if (this.ratings[i] > this.ratings[i - 1]) {
                    numbers[i] = numbers[i - 1] + 1;
                } else {
                    numbers[i] = 1;
                }
                backCheck(i);
            }
            int count = 0;
            for (int i : numbers) {
                count += i;
            }
            return count;
        }
    }
}
