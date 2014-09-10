package com.leetcode.onlinejudge.problems._0_olds.v1._4_stack;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/8/10.
 */
public class _55_Longest_Valid_Parentheses extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.\n" +
                "For \"(()\", the longest valid parentheses substring is \"()\", which has length = 2.\n" +
                "Another example is \")()())\", where the longest valid parentheses substring is \"()()\", which has length = 4.";
    }

    @Override
    public void run() {
        print(new Solution().longestValidParentheses("(()())"));
        print(new Solution().longestValidParentheses(")(())(()()))("));
        print(new Solution().longestValidParentheses(")()())"));
    }

    public class Solution {
        public int longestValidParentheses(String s) {
            int maxLen = 0;
            int start = 0;
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (stack.empty()) {
                        start = i + 1;
                    } else {
                        stack.pop();
                        maxLen = stack.empty() ? Math.max(maxLen, i - start + 1) : Math.max(maxLen, i - stack.peek());
                    }
                }
            }
            return maxLen;
        }
    }
}
