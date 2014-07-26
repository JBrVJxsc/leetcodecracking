package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/7/26.
 */
public class _15_Trapping_Rain_Water extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.\n" +
                "For example, \n" +
                "Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.";
    }

    @Override
    public void run() {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        print(new Solution().trap(a));
    }

    public class Solution {
        public int trap(int[] A) {
            return 0;
        }
    }

    // Got TLE.
    public class Solution1 {
        public int trap(int[] A) {
            int[] copy = Arrays.copyOf(A, A.length);
            Arrays.sort(copy);
            int total = 0;
            for (int i = 0; i < copy.length; i++) {
                if (i == 0 || copy[i] != copy[i - 1]) {
                    int flag = copy[i];
                    int counter = 0;
                    boolean start = false;
                    for (int j = 0; j < A.length; j++)
                        if (A[j] >= flag) {
                            start = true;
                            total += counter;
                            counter = 0;
                        } else if (start) counter++;
                }
            }
            return total;
        }
    }
}
