package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/27.
 */
public class _16_Rotate_Image extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "You are given an n × n 2D matrix representing an image.\n" +
                "Rotate the image by 90 degrees (clockwise).\n" +
                "Follow up: " +
                "Could you do this in-place?";
    }

    @Override
    public void run() {
        int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        new Solution().rotate1(matrix);
    }

    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n - i; j++)
                    swap(matrix, i, j, n - 1 - j, n - 1 - i);
            for (int i = 0; i < n / 2; i++)
                for (int j = 0; j < n; j++)
                    swap(matrix, i, j, n - 1 - i, j);
        }

        public void rotate1(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n - i; j++)
                    swap(matrix, i, j, n - 1 - j, n - 1 - i);
            for (int i = 0; i < n / 2; i++)
                for (int j = 0; j < n; j++)
                    swap(matrix, i, j, n - 1 - i, j);
        }

        public void rotate2(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n - i; j++)
                    swap(matrix, i, j, n - 1 - j, n - 1 - i);
            for (int i = 0; i < n / 2; i++)
                for (int j = 0; j < n; j++)
                    swap(matrix, i, j, n - 1 - i, j);
        }

        private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
            int temp = matrix[x1][y1];
            matrix[x1][y1] = matrix[x2][y2];
            matrix[x2][y2] = temp;
        }
    }
}
