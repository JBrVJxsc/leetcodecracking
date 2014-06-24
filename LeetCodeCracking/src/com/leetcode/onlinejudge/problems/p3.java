package com.leetcode.onlinejudge.problems;

import com.leetcode.base.Parameter;
import com.leetcode.common.Random;
import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Comparator;

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
        Parameter<Integer> number = new Parameter<Integer>(1000);
        set(number);
        Point[] points = getPoints(number.getValue());
        print(new Solution().maxPoints(points));
    }

    private Point[] getPoints(int number) {
        ArrayList<Point> pointArrayList = new ArrayList<Point>();
        Point[] points = new Point[number];
        int index = 0;
        int range = number;
        while (index != points.length) {
            Point point = new Point(Random.getInt(range), Random.getInt(range));
            //Loop, until get an unique point.
            while (pointArrayList.contains(point)) {
                point = new Point(Random.getInt(range), Random.getInt(range));
            }
            points[index] = point;
            pointArrayList.add(point);
            index++;
        }
        return points;
    }

    public class Solution {

        private Double getSlope(Point point1, Point point2) {
            if (point1.x == point2.x) {
                if (point1.y > point2.y) {
                    return Double.NEGATIVE_INFINITY;
                } else if (point1.y < point2.y) {
                    return Double.NEGATIVE_INFINITY;
                } else {
                    return Double.MIN_VALUE;
                }
            }
            return (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        }

        private int getMaximum(ArrayList<Point> pointArrayList, Point point) {
            int max = 0;
            double flag = Double.MIN_VALUE;
            int counter = 0;
            for (int i = 0; i < pointArrayList.size(); i++) {
                double slope = getSlope(pointArrayList.get(i), point);
                if (flag != slope) {
                    if (counter > max) {
                        max = counter;
                    }
                    flag = slope;
                    counter = 1;
                } else {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
            }
            return max;
        }

        public int maxPoints(Point[] points) {
            int maxNumber = 0;

            ArrayList<Point> pointArrayList = new ArrayList<Point>();
            for (int i = 0; i < points.length; i++) {
                pointArrayList.add(points[i]);
            }
            for (int i = 0; i < points.length; i++) {
                pointArrayList.sort(new Comparator<Point>() {

                    private Point point;

                    public Comparator setPoint(Point point) {
                        this.point = point;
                        return this;
                    }

                    @Override
                    public int compare(Point o1, Point o2) {
                        return getSlope(point, o1).compareTo(getSlope(point, o2));
                    }
                }.setPoint(points[i]));

                int number = getMaximum(pointArrayList, points[i]);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
            return maxNumber;
        }
    }

    private class Point {
        private int x;
        private int y;

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
