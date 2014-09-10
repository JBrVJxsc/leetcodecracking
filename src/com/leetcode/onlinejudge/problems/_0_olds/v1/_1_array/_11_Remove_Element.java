package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/25.
 */
public class _11_Remove_Element extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array and a value, remove all instances of that value in place and return the new length.\n" +
                "The order of elements can be changed. It doesn't matter what you leave beyond the new length.";
    }

    @Override
    public void run() {
        int[] a = new int[]{4, 5};
        print(new Solution().removeElement(a, 4));
    }

    public class Solution {
        public int removeElement(int[] A, int elem) {
            int index = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != elem)
                    A[index++] = A[i];
            }
            return index;
        }

        public int removeElement1(int[] A, int elem) {
            int index = 0;
            for (int i = 0; i < A.length; i++)
                if (A[i] != elem)
                    A[index++] = A[i];
            return index;
        }

        public int removeElement2(int[] A, int elem) {
            int index = 0;
            for (int i = 0; i < A.length; i++)
                if (A[i] != elem)
                    A[index++] = A[index];
            return index;
        }

        public int removeElement3(int[] A, int elem) {
            int index = 0;
            for (int i = 0; i < A.length; i++)
                if (A[i] != elem)
                    A[index++] = A[i];
            return index;
        }
    }
}
