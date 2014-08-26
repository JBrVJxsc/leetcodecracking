package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Who on 2014/6/29.
 */
public class _17_Best_Time_to_Buy_and_Sell_Stock_II extends BaseProblem implements IProblem {

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
        return "[HELPED: TLE]Best Time to Buy and Sell Stock II";
    }

    @Override
    public String getSummary() {
        return "Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).";
    }

    @Override
    public void run() {
        int[] prices = new int[]{10, 21, 13, 41, 50, 16, 27, 10, 39};
        //prices = new int[]{1, 3, 2, 1};
        print(new Solution().maxProfit(prices));
    }

    public class Solution {


        public int maxProfit(int[] prices) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }

        private int maxProfit_MINE(int[] prices) {
            ArrayList<Profit> profitArrayList = new ArrayList<Profit>();
            ArrayList<Price> priceArrayList = new ArrayList<Price>();
            for (int i = 0; i < prices.length; i++) {
                priceArrayList.add(new Price(i, prices[i]));
            }
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] < prices[j]) {
                        profitArrayList.add(new Profit(priceArrayList.get(i), priceArrayList.get(j)));
                    }
                }
            }
            Collections.sort(profitArrayList);
            int sum = 0;
            for (Profit profit : profitArrayList) {
                sum += profit.useProfit();
            }
            return sum;
        }

        public class Price {
            public int index = 0;
            public int price = 0;
            public boolean used = false;

            public Price(int index, int price) {
                this.index = index;
                this.price = price;
            }
        }

        public class Profit implements Comparable<Profit> {
            public Price low = null;
            public Price high = null;

            private int getProfit() {
                return high.price - low.price;
            }

            public Profit(Price low, Price high) {
                this.low = low;
                this.high = high;
            }

            public int useProfit() {
                if (low.used || high.used) {
                    return 0;
                } else {
                    print(low.price + ", " + high.price);
                    low.used = true;
                    high.used = true;
                    return high.price - low.price;
                }
            }

            @Override
            public int compareTo(Profit o) {
                return Integer.compare(o.getProfit(), getProfit());
            }
        }
    }
}
