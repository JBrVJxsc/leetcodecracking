package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashMap;

/**
 * Created by Who on 2014/7/25.
 */
public class _7_Two_Sum extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array of integers, find two numbers such that they add up to a specific target number.\n" +
                "The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.\n" +
                "You may assume that each input would have exactly one solution.\n" +
                "Input: numbers={2, 7, 11, 15}, target=9\n" +
                "Output: index1=1, index2=2";
    }

    @Override
    public void run() {
        int[] a = new int[]{2, 7, 11, 15};
        print(new Solution().twoSum(a, 9));
    }

    public class Solution {
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (hashMap.get(target - numbers[i]) != null) {
                    result[0] = hashMap.get(target - numbers[i]) + 1;
                    result[1] = i + 1;
                } else {
                    hashMap.put(numbers[i], i);
                }
            }
            return result;
        }

        public int[] twoSum1(int[] numbers, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (hashMap.get(target - numbers[i]) != null) {
                    result[0] = hashMap.get(target - numbers[i]) + 1;
                    result[1] = i + 1;
                } else {
                    hashMap.put(numbers[i], i);
                }
            }
            return result;
        }

        public int[] twoSum2(int[] numbers, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (hashMap.get(target - numbers[i]) != null) {
                    result[0] = hashMap.get(target - numbers[i]) + 1;
                    result[1] = i + 1;
                } else {
                    hashMap.put(numbers[i], i);
                }
            }
            return result;
        }

        public int[] twoSum3(int[] numbers, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (hashMap.get(target - numbers[i]) != null) {
                    result[0] = hashMap.get(target - numbers[i]) + 1;
                    result[1] = i + 1;
                } else {
                    hashMap.put(numbers[i], i);
                }
            }
            return result;
        }
    }

    public int[] twoSumBrute(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
        return null;
    }
}
