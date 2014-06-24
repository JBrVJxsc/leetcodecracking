package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/24.
 */
public class p2 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Evaluate Reverse Polish Notation";
    }

    @Override
    public String getSummary() {
        return "Evaluate the value of an arithmetic expression in Reverse Polish Notation.\n" +
                "Valid operators are +, -, *, /. Each operand may be an integer or another expression.\n" +
                "Some examples:\n" +
                "  [\"2\", \"1\", \"+\", \"3\", \"*\"] -> ((2 + 1) * 3) -> 9\n" +
                "  [\"4\", \"13\", \"5\", \"/\", \"+\"] -> (4 + (13 / 5)) -> 6";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int evalRPN(String[] tokens) {
            return 0;
        }
    }
}
