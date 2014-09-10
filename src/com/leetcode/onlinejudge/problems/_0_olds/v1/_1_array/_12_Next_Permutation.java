package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/7/25.
 */
public class _12_Next_Permutation extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.\n" +
                "If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).\n" +
                "The replacement must be in-place, do not allocate extra memory.\n" +
                "Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.\n" +
                "1,2,3 → 1,3,2\n" +
                "3,2,1 → 1,2,3\n" +
                "1,1,5 → 1,5,1";
    }

    @Override
    public String getNote() {
        return "1. From right to left, find the first digit (PartitionNumber) which violates the increase trend.\n" +
                "2. From right to left, find the first digit which is larger than PartitionNumber, call it ChangeNumber.\n" +
                "3. Swap PartitionNumber and ChangeNumber.\n" +
                "4. Reverse all the digit on the right of partition index.\n" +
                "5. If there is no PartitionNumber found, reverse the whole array.";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 2, 3};
        Solution solution = new Solution();
        Arrays.sort(a);
        while (solution.nextPermutation(a))
            print(a);
    }

    public class Solution {
        public boolean nextPermutation(int[] num) {
            // Find the partition index.
            int partitionIndex = -1;
            for (int i = num.length - 2; i >= 0; i--) {
                if (num[i] < num[i + 1]) {
                    partitionIndex = i;
                    break;
                }
            }

            if (partitionIndex == -1) {
                reverse(num, 0);
                return false;
            }

            // Find the change index.
            int changeIndex = -1;
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] > num[partitionIndex]) {
                    changeIndex = i;
                    break;
                }
            }

            // Swap.
            swap(num, partitionIndex, changeIndex);
            // Reverse.
            reverse(num, partitionIndex + 1);
            return true;
        }

        private void swap(int[] A, int a, int b) {
            int temp = A[b];
            A[b] = A[a];
            A[a] = temp;
        }

        private void reverse(int[] A, int start) {
            int s = start;
            int e = A.length - 1;
            while (s < e)
                swap(A, s++, e--);
        }
    }
}
