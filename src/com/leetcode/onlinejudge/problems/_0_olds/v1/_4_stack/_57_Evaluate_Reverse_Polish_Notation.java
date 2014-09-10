package com.leetcode.onlinejudge.problems._0_olds.v1._4_stack;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/8/10.
 */
public class _57_Evaluate_Reverse_Polish_Notation extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
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
        print(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        print(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        print(new Solution().evalRPN(new String[]{"0", "3", "/"}));
    }

    public class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < tokens.length; i++) {
                String s = tokens[i];
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (s.equals("-")) {
                    int o1 = stack.pop();
                    int o2 = stack.pop();
                    stack.push(o2 - o1);
                } else if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (s.equals("/")) {
                    int o1 = stack.pop();
                    int o2 = stack.pop();
                    stack.push(o2 / o1);
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }
            return stack.pop();
        }
    }
}
