package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/7/27.
 */
public class _19_Gray_Code extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "The gray code is a binary numeral system where two successive values differ in only one bit.\n" +
                "Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.\n" +
                "For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:\n" +
                "00 - 0\n" +
                "01 - 1\n" +
                "11 - 3\n" +
                "10 - 2\n" +
                "Note:\n" +
                "For a given n, a gray code sequence is not uniquely defined.\n" +
                "For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.\n" +
                "For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.";
    }

    @Override
    public void run() {
        print(new Solution().grayCode(2));
    }

    public class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> list = new ArrayList<Integer>();
            int total = (int) Math.pow(2, n);
            for (int i = 0; i < total; i++) {
                list.add(i ^ (i / 2));
            }
            return list;
        }

        public List<Integer> grayCode1(int n) {
            List<Integer> list = new ArrayList<Integer>();
            int total = (int) Math.pow(2, n);
            for (int i = 0; i < total; i++)
                list.add(i ^ (i / 2));
            return list;
        }

        public List<Integer> grayCode2(int n) {
            List<Integer> list = new ArrayList<Integer>();
            int total = (int) Math.pow(2, n);
            for (int i = 0; i < total; i++) {
                list.add(i ^ (i / 2));
            }
            return list;
        }

        public List<Integer> grayCode3(int n) {
            List<Integer> list = new ArrayList<Integer>();
            int total = (int) Math.pow(2, n);
            for (int i = 0; i < total; i++) {
                list.add(i ^ (i / 2));
            }
            return list;
        }
    }
}
