package com.leetcode.onlinejudge.problems._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

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

    }

    public class Solution {
        public String simplifyPath(String path) {
            return null;
        }
    }
}
