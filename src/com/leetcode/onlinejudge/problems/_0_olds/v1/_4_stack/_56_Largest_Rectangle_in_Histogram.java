package com.leetcode.onlinejudge.problems._0_olds.v1._4_stack;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Who on 2014/8/10.
 */
public class _56_Largest_Rectangle_in_Histogram extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.\n" +
                "Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].\n" +
                "The largest rectangle is shown in the shaded area, which has area = 10 unit.\n" +
                "For example,\n" +
                "Given height = [2,1,5,6,2,3],\n" +
                "return 10.";
    }

    @Override
    public void run() {
        print(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public class Solution {
        public int largestRectangleArea(int[] height) {
            int max = 0;
            int i = 0;
            int[] h = Arrays.copyOf(height, height.length + 1);
            Stack<Integer> stack = new Stack<Integer>();
            while (i < h.length) {
                if (stack.empty() || h[stack.peek()] <= h[i]) {
                    stack.push(i++);
                } else {
                    int l = stack.pop();
                    max = Math.max(max, h[l] * (stack.empty() ? i : i - stack.peek() - 1));
                }
            }
            return max;
        }
    }

    // My TLE solution.
    public class Solution1 {
        public int largestRectangleArea(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int h = 1;
            int max = 0;
            while (true) {
                int curMax = 0;
                int counter = 0;
                boolean none = true;
                for (int i = 0; i < height.length; i++) {
                    int j = height[i];
                    if (j >= h) {
                        counter += h;
                        none = false;
                    } else {
                        counter = 0;
                    }
                    curMax = Math.max(curMax, counter);
                }
                if (none) {
                    break;
                }
                max = Math.max(max, curMax);
                h++;
            }
            return max;
        }
    }
}
