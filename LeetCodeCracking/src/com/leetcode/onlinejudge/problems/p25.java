package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class p25 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Best Time to Buy and Sell Stock";
    }

    @Override
    public String getSummary() {
        return "Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.";
    }

    @Override
    public void run() {
        int[] prices = new int[]{10, 2, 3, 4, 5, 6, 7, 10, 9};
        prices = new int[]{1, 3, 2, 1};
        print(new Solution().maxProfit(prices));
    }

    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) {
                return 0;
            }
            if (prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int currentPrice = prices[prices.length - 1];
            int max = 0;
            for (int i = prices.length - 2; i >= 0; i--) {
                if (prices[i] >= currentPrice) {
                    currentPrice = prices[i];
                    continue;
                }
                for (int j = i; j >= 0; j--) {
                    max = (max < currentPrice - prices[j]) ? currentPrice - prices[j] : max;
                }
                currentPrice = prices[i];
            }
            return max;
        }
    }
}
