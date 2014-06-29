package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/29.
 */
public class p26 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Best Time to Buy and Sell Stock II";
    }

    @Override
    public String getSummary() {
        return "Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int maxProfit(int[] prices) {
            return 0;
        }
    }
}
