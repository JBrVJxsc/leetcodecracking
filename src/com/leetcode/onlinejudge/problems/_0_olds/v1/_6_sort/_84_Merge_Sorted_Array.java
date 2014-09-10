package com.leetcode.onlinejudge.problems._0_olds.v1._6_sort;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.Arrays;

/**
 * Created by Who on 2014/8/16.
 */
public class _84_Merge_Sorted_Array extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given two sorted integer arrays A and B, merge B into A as one sorted array.\n" +
                "Note:\n" +
                "You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.";
    }

    @Override
    public void run() {
        int[] a1 = new int[]{4, 5, 6, 0, 0, 0, 0, 0, 0, 0};
        new Solution().merge(a1, 3, new int[]{3, 4}, 2);
        print(a1);
    }

    // A better solution.
    public class Solution {
        public void merge(int A[], int m, int B[], int n) {
            int iA = m - 1;
            int iB = n - 1;
            int index = m + n - 1;
            while (iA >= 0 && iB >= 0) {
                A[index--] = A[iA] >= B[iB] ? A[iA--] : B[iB--];
            }
            while (iB >= 0) {
                A[index--] = B[iB--];
            }
        }
    }

    // My solution with too much codes.
    public class Solution1 {
        public void merge(int A[], int m, int B[], int n) {
            int[] copyA = Arrays.copyOf(A, m);
            int index = 0;
            int iA = 0;
            int iB = 0;
            while (index < m + n) {
                if (iA > m - 1) {
                    A[index] = B[iB];
                    iB++;
                } else if (iB > n - 1) {
                    A[index] = copyA[iA];
                    iA++;
                } else {
                    int a = copyA[iA];
                    int b = B[iB];
                    if (a > b) {
                        A[index] = b;
                        iB++;
                    } else {
                        A[index] = a;
                        iA++;
                    }
                }
                index++;
            }
        }
    }
}
