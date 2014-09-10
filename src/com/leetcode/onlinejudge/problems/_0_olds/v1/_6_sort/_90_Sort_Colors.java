package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/18.
 */
public class _90_Sort_Colors extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.\n" +
                "Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.\n" +
                "Note:\n" +
                "You are not suppose to use the library's sort function for this problem.\n" +
                "Follow up:\n" +
                "A rather straight forward solution is a two-pass algorithm using counting sort.\n" +
                "First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.\n" +
                "Could you come up with an one-pass algorithm using only constant space?";
    }

    @Override
    public void run() {
        int[] colors = new int[]{2, 2, 1, 1, 2, 0, 0, 1, 2, 0, 0, 1};
        new Solution().sortColors(colors);
        print(colors);
    }

    public class Solution {
        public void sortColors(int[] A) {
            int red = 0;
            int blue = A.length - 1;
            for (int i = 0; i < blue + 1; ) {
                if (A[i] == 0) {
                    A[i++] = A[red];
                    A[red++] = 0;
                } else if (A[i] == 2) {
                    A[i] = A[blue];
                    A[blue--] = 2;
                } else {
                    i++;
                }
            }
        }
    }
}
