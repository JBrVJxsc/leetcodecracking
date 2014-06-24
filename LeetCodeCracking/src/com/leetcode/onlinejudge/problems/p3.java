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

        private int getMaximum(ArrayList<PointPlus> pointPlusArrayList) {
            int max = 0;
            double flag = Double.MIN_VALUE;
            int counter = 0;
            for (int i = 0; i < pointPlusArrayList.size(); i++) {
                if (flag != pointPlusArrayList.get(i).getSlope()) {
                    if (counter > max) {
                        max = counter;
                    }
                    flag = pointPlusArrayList.get(i).getSlope();
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
            ArrayList<PointPlus> pointPlusArrayList = new ArrayList<PointPlus>();
            for (int i = 0; i < points.length; i++) {
                pointPlusArrayList.add(new PointPlus(points[i]));
            }
            for (int i = 0; i < points.length; i++) {
                pointPlusArrayList.sort(new Comparator<PointPlus>() {

                    private Point point;

                    private Double getSlope(PointPlus pointPlus) {
                        if (this.point.x == pointPlus.getPoint().x) {
                            if (this.point.y > pointPlus.getPoint().y) {
                                return Double.NEGATIVE_INFINITY;
                            } else if (this.point.y < pointPlus.getPoint().y) {
                                return Double.NEGATIVE_INFINITY;
                            } else {
                                return Double.MIN_VALUE;
                            }
                        }
                        pointPlus.setSlope((double) (pointPlus.getPoint().y - this.point.y) / (double) (pointPlus.getPoint().x - this.point.x));
                        return pointPlus.getSlope();
                    }

                    public Comparator setPoint(Point point) {
                        this.point = point;
                        return this;
                    }

                    @Override
                    public int compare(PointPlus o1, PointPlus o2) {
                        return getSlope(o1).compareTo(getSlope(o2));
                    }
                }.setPoint(points[i]));

                int number = getMaximum(pointPlusArrayList);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }
            return maxNumber;
        }

        public class PointPlus {
            private Point point = null;
            private double slope = 0d;

            public PointPlus(Point point) {
                this.point = point;
            }

            public Point getPoint() {
                return point;
            }

            public double getSlope() {
                return slope;
            }

            public void setSlope(double slope) {
                this.slope = slope;
            }
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
