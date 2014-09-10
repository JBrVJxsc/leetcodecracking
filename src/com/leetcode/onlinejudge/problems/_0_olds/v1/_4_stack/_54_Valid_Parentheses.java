package com.leetcode.onlinejudge.problems._0_olds.v1._4_stack;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/8/10.
 */
public class _54_Valid_Parentheses extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.\n" +
                "The brackets must close in the correct order, \"()\" and \"()[]{}\" are all valid but \"(]\" and \"([)]\" are not.";
    }

    @Override
    public void run() {
        print(new Solution().isValid("()"));
    }

    public class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.empty() && isPair(c, stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.empty();
        }

        private boolean isPair(char c1, char c2) {
            if (c1 == ')') {
                return c2 == '(';
            }
            if (c1 == '}') {
                return c2 == '{';
            }
            if (c1 == ']') {
                return c2 == '[';
            }
            return false;
        }
    }
}
