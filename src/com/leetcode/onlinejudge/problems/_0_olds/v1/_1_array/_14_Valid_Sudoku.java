package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/26.
 */
public class _14_Valid_Sudoku extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules\n" +
                "http://sudoku.com.au/TheRules.aspx .\n" +
                "The Sudoku board could be partially filled, where empty cells are filled with the character '.'.\n" +
                "Note:\n" +
                "A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Row.
            for (int i = 0; i < 9; i++) {
                boolean[] used = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;
                    int value = Integer.valueOf(String.valueOf(board[i][j]));
                    if (used[value - 1])
                        return false;
                    else used[value - 1] = true;
                }
            }

            // Column.
            for (int i = 0; i < 9; i++) {
                boolean[] used = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] == '.') continue;
                    int value = Integer.valueOf(String.valueOf(board[j][i]));
                    if (used[value - 1])
                        return false;
                    else used[value - 1] = true;
                }
            }

            // Nine range.
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean[] used = new boolean[9];
                    for (int k = 3 * i; k < 3 * i + 3; k++)
                        for (int l = 3 * j; l < 3 * j + 3; l++) {
                            if (board[k][l] == '.') continue;
                            int value = Integer.valueOf(String.valueOf(board[k][l]));
                            if (used[value - 1])
                                return false;
                            else used[value - 1] = true;
                        }
                }
            }
            return true;
        }
    }
}
