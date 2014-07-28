package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _24_Single_Number_II extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given an array of integers, every element appears three times except for one. Find that single one.\n" +
                "Note:\n" +
                "Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int singleNumber(int[] A) {
            return 0;
        }
    }
}
