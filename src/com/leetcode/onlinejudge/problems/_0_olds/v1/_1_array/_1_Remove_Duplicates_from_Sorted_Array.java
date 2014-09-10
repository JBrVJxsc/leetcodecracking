package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/22.
 */
public class _1_Remove_Duplicates_from_Sorted_Array extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a sorted array, remove the duplicates in place such that each element appear only once\n" +
                "and return the new length.\n" +
                "Do not allocate extra space for another array, you must do this in place with constant memory.\n" +
                "For example, Given input array A = [1,1,2],\n" +
                "Your function should return length = 2, and A is now [1,2].";
    }

    @Override
    public void run() {
        int[] a = new int[]{0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6};
        a = new int[]{1, 1, 2};
        print(new Solution().removeDuplicates(a));
    }

    public class Solution {
        public int removeDuplicates(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int front = A[0];
            int currentPointer = 1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] != front) {
                    front = A[currentPointer] = A[i];
                    currentPointer++;
                }
            }
            return currentPointer;
        }

        public int removeDuplicates1(int[] A) {
            if (A == null || A.length == 0)
                return 0;
            int pointer = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[pointer] != A[i])
                    A[++pointer] = A[i];
            }
            return pointer + 1;
        }

        public int removeDuplicates2(int[] A) {
            if (A == null || A.length == 0) return 0;
            int pointer = 0;
            for (int i = 1; i < A.length; i++)
                if (A[pointer] != A[i])
                    A[++pointer] = A[i];
            return pointer + 1;
        }

        public int removeDuplicates3(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates4(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[index] != A[i])
                    A[++index] = A[i];
            }
            return index + 1;
        }

        public int removeDuplicates5(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[index] != A[i])
                    A[++index] = A[i];
            }
            return index + 1;
        }

        public int removeDuplicates6(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates7(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[index++] = A[i];
            return index + 1;
        }

        public int removeDuplicates8(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates9(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates10(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i])
                    A[++index] = A[i];
            return index + 1;
        }
    }
}
