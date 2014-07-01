package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/30.
 */
public class p33 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Climbing Stairs";
    }

    @Override
    public String getSummary() {
        return "You are climbing a stair case. It takes n steps to reach to the top.\n" +
                "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int climbStairs(int n) {
            return 0;
        }
    }
}
