package com.leetcode.onlinejudge.problems._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/8/9.
 */
public class _52_Simplify_Path extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given an absolute path for a file (Unix-style), simplify it.\n" +
                "For example,\n" +
                "path = \"/home/\", => \"/home\"\n" +
                "path = \"/a/./b/../../c/\", => \"/c\"\n" +
                "Corner Cases:\n" +
                "Did you consider the case where path = \"/../\"?\n" +
                "In this case, you should return \"/\".\n" +
                "Another corner case is the path might contain multiple slashes '/' together, such as \"/home//foo/\".\n" +
                "In this case, you should ignore redundant slashes and return \"/home/foo\".";
    }

    @Override
    public void run() {
        print(new Solution().simplifyPath("/home/"));
        print(new Solution().simplifyPath("/a/./b/../../c/"));
        print(new Solution().simplifyPath("/../"));
        print(new Solution().simplifyPath("/home//foo/"));
    }

    public class Solution {
        // 384ms for 252 test cases
        public String simplifyPath(String path) {
            if (path == null)
                return null;
            if (path.length() == 0)
                return "/";
            int n = path.length();
            Stack<String> stack = new Stack<String>();
            String[] directories = path.split("/");     // Separate path by "/"
            for (String dir : directories) {
                if (dir.length() != 0) {
                    if (dir.equals("..")) {     // Go up to its parent
                        if (!stack.empty())
                            stack.pop();
                    } else if (!dir.equals(".")) {  // Enter its subdirectory
                        stack.push(dir);
                    }
                }
                // No redundant "/"
            }
            // Construct simplified path
            if (stack.empty())  // No subdirectory
                return "/";
            StringBuilder result = new StringBuilder();
            for (String s : stack.toArray(new String[stack.size()]))
                result.append("/" + s);
            return result.toString();
        }
    }
}
