package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/26.
 */
public class _13_Permutation_Sequence extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "The set [1,2,3,…,n] contains a total of n! unique permutations.\n" +
                "By listing and labeling all of the permutations in order,\n" +
                "We get the following sequence (ie, for n = 3):\n" +
                "\"123\"\n" +
                "\"132\"\n" +
                "\"213\"\n" +
                "\"231\"\n" +
                "\"312\"\n" +
                "\"321\"\n" +
                "Given n and k, return the kth permutation sequence.\n" +
                "Note: Given n will be between 1 and 9 inclusive.";
    }

    @Override
    public void run() {
        Solution solution = new Solution();
        print(solution.getPermutation(3, 1));
    }

    public class Solution {

        public String getPermutation(int n, int k) {
            int[] nums = new int[n];
            int total = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
                total *= nums[i];
            }
            StringBuffer stringBuffer = new StringBuffer();
            k--;
            for (int i = 0; i < n; i++) {
                total /= n - i;
                int selected = k / total;
                stringBuffer.append(nums[selected]);
                for (int j = selected; j < n - i - 1; j++)
                    nums[j] = nums[j + 1];
                k %= total;
            }
            return stringBuffer.toString();
        }

        public String getPermutation1(int n, int k) {
            int[] num = new int[n];
            int permSum = 1;
            for (int i = 0; i < n; i++) {
                num[i] = i + 1;
                permSum *= i + 1;
            }
            StringBuilder sb = new StringBuilder();
            k--;
            for (int i = 0; i < n; i++) {
                permSum = permSum / (n - i);
                int selected = k / permSum;
                sb.append(num[selected]);
                for (int j = selected; j < n - i - 1; j++)
                    num[j] = num[j + 1];
                k = k % permSum;
            }
            return sb.toString();
        }

        public String getPermutation2(int n, int k) {
            int[] nums = new int[n];
            int total = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
                total *= nums[i];
            }
            StringBuffer stringBuffer = new StringBuffer();
            k--;
            for (int i = 0; i < n; i++) {
                total /= n - i;
                int selected = k / total;
                stringBuffer.append(nums[selected]);
                for (int j = selected; j < n - i - 1; j++)
                    nums[j] = nums[j + 1];
                k %= total;
            }
            return stringBuffer.toString();
        }

        public String getPermutation3(int n, int k) {
            int[] nums = new int[n];
            int total = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
                total *= nums[i];
            }
            StringBuffer stringBuffer = new StringBuffer();
            k--;
            for (int i = 0; i < n; i++) {
                total /= n - i;
                int selected = k / total;
                stringBuffer.append(nums[selected]);
                for (int j = selected; j < n - i - 1; j++)
                    nums[j] = nums[j + 1];
                k %= total;
            }
            return stringBuffer.toString();
        }
    }
}
