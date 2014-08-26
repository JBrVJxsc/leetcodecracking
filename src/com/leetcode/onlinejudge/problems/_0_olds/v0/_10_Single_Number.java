package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/28.
 */
public class _10_Single_Number extends BaseProblem implements IProblem {

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
        return "[HELPED]Single Number";
    }

    @Override
    public String getSummary() {
        return "Given an array of integers, every element appears twice except for one. Find that single one.\n" +
                "Note:\n" +
                "Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?";
    }

    @Override
    public void run() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        print(new Solution().singleNumber(ints));
    }

    public class Solution {
        public int singleNumber(int[] A) {
            int x = 0;
            for (int i : A) {
                x ^= i;
            }
            return x;
        }
    }
}
