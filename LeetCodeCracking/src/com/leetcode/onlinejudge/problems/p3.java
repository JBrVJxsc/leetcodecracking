package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/6/24.
 */
public class p3 extends BaseProblem implements IProblem {
    @Override
    public String getName() {
        return "Max Points on a Line ";
    }

    @Override
    public String getSummary() {
        return "Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.";
    }

    @Override
    public void run() {

    }


    public class Solution {
        public int maxPoints(Point[] points) {
            return 0;
        }

        public class Point {
            int x;
            int y;

            public Point() {
                x = 0;
                y = 0;
            }

            public Point(int a, int b) {
                x = a;
                y = b;
            }
        }
    }
}
