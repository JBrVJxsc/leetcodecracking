package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Stack;

/**
 * Created by Who on 2014/8/9.
 */
public class _52_Simplify_Path extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

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
        print(new Solution().simplifyPath("/."));
        print(new Solution().simplifyPath("/home/"));
        print(new Solution().simplifyPath("/a/./b/../../c/"));
        print(new Solution().simplifyPath("/../"));
        print(new Solution().simplifyPath("/home//foo/"));
    }

    public class Solution {
        public String simplifyPath(String path) {
            if (path == null) {
                return null;
            }
            if (path.trim().length() == 0) {
                return "/";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Stack<String> stack = new Stack<String>();
            String[] paths = path.split("/");
            for (String i : paths) {
                if (i.length() == 0) {
                    continue;
                }
                if (i.equals("..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    if (!i.equals(".")) {
                        stack.push(i);
                    }
                }
            }
            if (stack.size() == 0) {
                return "/";
            }
            for (String i : stack.toArray(new String[stack.size()])) {
                stringBuffer.append("/" + i);
            }
            return stringBuffer.toString();
        }
    }
}
