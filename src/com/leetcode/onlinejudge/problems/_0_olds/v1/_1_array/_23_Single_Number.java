package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _23_Single_Number extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array of integers, every element appears twice except for one. Find that single one.\n" +
                "Note:\n" +
                "Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int singleNumber(int[] A) {
            int num = 0;
            for (int i : A)
                num ^= i;
            return num;
        }

        public int singleNumber1(int[] A) {
            int num = 0;
            for (int i : A)
                num ^= i;
            return num;
        }
    }
}
