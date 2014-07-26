package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/26.
 */
public class _14_Valid_Sudoku extends BaseProblem implements IProblem {
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
}
