package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/6/24.
 */
public class _2_Evaluate_Reverse_Polish_Notation extends BaseProblem implements IProblem {

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
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
        String[] tokensOne = new String[]{"2", "1", "+", "3", "*"};
        String[] tokensTwo = new String[]{"4", "13", "5", "/", "+"};
        String[] tokensThree = new String[]{"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        print(new Solution().evalRPN(tokensOne));
        print(new Solution().evalRPN(tokensTwo));
        print(new Solution().evalRPN(tokensThree));
    }

    public class Solution {
        private String operators = "+-*/";
        private Stack<Integer> stackOperand = new Stack<Integer>();

        private int operate(String operator, int first, int second) {
            if (operator.equals("+")) {
                return second + first;
            } else if (operator.equals("-")) {
                return second - first;
            } else if (operator.equals("*")) {
                return second * first;
            } else if (operator.equals("/")) {
                return second / first;
            }
            return 0;
        }

        public int evalRPN(String[] tokens) {
            int answer = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (operators.contains(tokens[i])) {
                    answer = operate(tokens[i], stackOperand.pop(), stackOperand.pop());
                    stackOperand.push(answer);
                } else {
                    stackOperand.push(Integer.parseInt(tokens[i]));
                }
            }
            if (tokens.length == 1) {
                return Integer.parseInt(tokens[0]);
            }
            return answer;
        }
    }
}
