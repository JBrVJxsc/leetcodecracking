package com.leetcode.onlinejudge.problems._0_olds.v1._7_search;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/18.
 */
public class _93_Search_a_2D_Matrix extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:\n" +
                "Integers in each row are sorted from left to right.\n" +
                "The first integer of each row is greater than the last integer of the previous row.\n" +
                "For example,\n" +
                "Consider the following matrix:\n" +
                "[\n" +
                "  [1,   3,  5,  7],\n" +
                "  [10, 11, 16, 20],\n" +
                "  [23, 30, 34, 50]\n" +
                "]\n" +
                "Given target = 3, return true.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            return search(matrix, matrix[0].length, 0, matrix.length * matrix[0].length - 1, target);
        }

        private boolean search(int[][] matrix, int n, int start, int end, int target) {
            if (start > end) {
                return false;
            }
            int middle = start + (end - start) / 2;
            int im = middle / n;
            int in = middle % n;
            if (matrix[im][in] == target) {
                return true;
            } else if (matrix[im][in] < target) {
                return search(matrix, n, middle + 1, end, target);
            } else {
                return search(matrix, n, start, middle - 1, target);
            }
        }
    }
}
