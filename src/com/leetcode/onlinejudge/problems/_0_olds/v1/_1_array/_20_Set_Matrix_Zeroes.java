package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/28.
 */
public class _20_Set_Matrix_Zeroes extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a m × n matrix, if an element is 0, set its entire row and column to 0. Do it in place.\n" +
                "Follow up: Did you use extra space?\n" +
                "A straight forward solution using O(mn) space is probably a bad idea.\n" +
                "A simple improvement uses O(m + n) space, but still not the best solution.\n" +
                "Could you devise a constant space solution?";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public void setZeroes(int[][] matrix) {
            int rowNum = matrix.length;
            int columnNum = matrix[0].length;
            boolean rowHasZero = false;
            boolean columnHasZero = false;
            for (int i = 0; i < rowNum; i++)
                if (matrix[i][0] == 0) {
                    columnHasZero = true;
                    break;
                }
            for (int i = 0; i < columnNum; i++)
                if (matrix[0][i] == 0) {
                    rowHasZero = true;
                    break;
                }
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][j] == 0)
                        matrix[0][j] = matrix[i][0] = 0;
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[0][j] == 0 || matrix[i][0] == 0)
                        matrix[i][j] = 0;
            if (rowHasZero)
                for (int i = 0; i < columnNum; i++)
                    matrix[0][i] = 0;
            if (columnHasZero)
                for (int i = 0; i < rowNum; i++)
                    matrix[i][0] = 0;
        }

        public void setZeroes1(int[][] matrix) {
            int rowNum = matrix.length;
            int columnNum = matrix[0].length;
            boolean rowHasZero = false;
            boolean columnHasZero = false;
            for (int i = 0; i < rowNum; i++)
                if (matrix[i][0] == 0) {
                    columnHasZero = true;
                    break;
                }
            for (int i = 0; i < columnNum; i++) {
                if (matrix[0][i] == 0) {
                    rowHasZero = true;
                    break;
                }
            }
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            if (rowHasZero)
                for (int i = 0; i < columnNum; i++)
                    matrix[0][i] = 0;
            if (columnHasZero)
                for (int i = 0; i < rowNum; i++)
                    matrix[i][0] = 0;
        }

        public void setZeroes2(int[][] matrix) {
            int rowNum = matrix.length;
            int columnNum = matrix[0].length;
            boolean rowHasZero = false;
            boolean columnHasZero = false;
            for (int i = 0; i < rowNum; i++)
                if (matrix[i][0] == 0) {
                    columnHasZero = true;
                    break;
                }
            for (int i = 0; i < columnNum; i++)
                if (matrix[0][i] == 0) {
                    rowHasZero = true;
                    break;
                }
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            if (rowHasZero)
                for (int i = 0; i < columnNum; i++)
                    matrix[0][i] = 0;
            if (columnHasZero)
                for (int i = 0; i < rowNum; i++)
                    matrix[i][0] = 0;
        }

        public void setZeroes3(int[][] matrix) {
            int rowNum = matrix.length;
            int columnNum = matrix[0].length;
            boolean rowHasZero = false;
            boolean columnHasZero = false;
            for (int i = 0; i < rowNum; i++)
                if (matrix[i][0] == 0) {
                    columnHasZero = true;
                    break;
                }
            for (int i = 0; i < columnNum; i++)
                if (matrix[0][i] == 0) {
                    rowHasZero = true;
                    break;
                }
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][j] == 0)
                        matrix[i][0] = matrix[0][j] = 0;
            for (int i = 1; i < rowNum; i++)
                for (int j = 1; j < columnNum; j++)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            if (rowHasZero)
                for (int i = 0; i < columnNum; i++)
                    matrix[0][i] = 0;
            if (columnHasZero)
                for (int i = 0; i < rowNum; i++)
                    matrix[i][0] = 0;
        }
    }
}
