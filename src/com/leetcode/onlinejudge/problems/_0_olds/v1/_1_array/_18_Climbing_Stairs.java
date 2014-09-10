package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.base.Parameter;
import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/27.
 */
public class _18_Climbing_Stairs extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "You are climbing a stair case. It takes n steps to reach to the top.\n" +
                "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?";
    }

    @Override
    public String getNote() {
        return "You should know what is DP (Dynamic Programming).";
    }

    @Override
    public void run() {
        Parameter<Integer> num = new Parameter<Integer>(1);
        set(num);
        print(new Solution().climbStairs3(num.getValue()));
    }

    public class Solution {
        public int climbStairs(int n) {
            if (n == 0) {
                return 1;
            }
            int[] a = new int[n + 1];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i <= n; ++i) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[n];
        }

        public int climbStairs1(int n) {
            if (n == 0) return 1;
            int[] a = new int[n + 1];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[n];
        }

        public int climbStairs2(int n) {
            if (n == 0) return 1;
            int[] a = new int[n + 1];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[n];
        }

        public int climbStairs3(int n) {
            if (n == 0) return 1;
            int[] a = new int[n + 1];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[n];
        }
    }
}
