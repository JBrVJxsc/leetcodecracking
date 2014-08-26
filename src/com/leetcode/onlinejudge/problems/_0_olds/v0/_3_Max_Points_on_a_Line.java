package com.leetcode.onlinejudge.problems._0_olds.v0;

import com.leetcode.base.Parameter;
import com.leetcode.common.Random;
import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;
import com.leetcode.onlinejudge.common.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Who on 2014/6/24.
 */
public class _3_Max_Points_on_a_Line extends BaseProblem implements IProblem {

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
        return "Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.";
    }

    @Override
    public void run() {
        Parameter<Integer> number = new Parameter<Integer>(1000);
        set(number);
        Point[] points = getPoints(number.getValue());
        points = new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        print(new Solution().maxPoints(points));
        points = new Point[]{new Point(0, 0), new Point(-1, -1), new Point(2, 2)};
        print(new Solution().maxPoints(points));
        points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)};
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
                    return Double.POSITIVE_INFINITY;
                } else if (point1.y < point2.y) {
                    return Double.POSITIVE_INFINITY;
                } else {
                    return Double.NEGATIVE_INFINITY;
                }
            }
            return (double) (point2.y - point1.y) / (double) (point2.x - point1.x);
        }

        private int getMaximum(ArrayList<Point> pointArrayList, Point point) {
            int max = 0;
            double flag = Double.MAX_VALUE;
            int counter = 0;
            int originalPointNumber = 0;
            for (int i = 0; i < pointArrayList.size(); i++) {
                double slope = getSlope(pointArrayList.get(i), point);
                if (slope == Double.NEGATIVE_INFINITY) {
                    originalPointNumber++;
                } else {
                    break;
                }
            }
            for (int i = originalPointNumber; i < pointArrayList.size(); i++) {
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
            return max + originalPointNumber;
        }

        public int maxPoints(Point[] points) {

            if (points.length == 2) {
                return 2;
            }

            int maxNumber = 0;

            ArrayList<Point> pointArrayList = new ArrayList<Point>();
            for (int i = 0; i < points.length; i++) {
                pointArrayList.add(points[i]);
            }
            for (int i = 0; i < points.length; i++) {
                Collections.sort(pointArrayList, new Comparator<Point>() {

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
}
