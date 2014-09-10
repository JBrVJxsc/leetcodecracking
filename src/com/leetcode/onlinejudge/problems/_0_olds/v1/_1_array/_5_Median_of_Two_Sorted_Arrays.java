package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/24.
 */
public class _5_Median_of_Two_Sorted_Arrays extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted\n" +
                "arrays. The overall run time complexity should be O(log(m + n)).";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{5, 6, 7, 8};
        double median = new Solution().findMedianSortedArrays(a, b);
        print();
        print("The median is: " + median);
    }

    public class Solution {
        public double findMedianSortedArrays(int A[], int B[]) {
            int k = A.length + B.length;
            return (A.length + B.length) % 2 != 0 ? findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1) : (findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2) + findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1)) / 2;
        }

        private int findK(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;
            if (aLen > bLen) return findK(B, bStart, bEnd, A, aStart, aEnd, k);

            if (aStart > aEnd) return B[bStart + k - 1];
            if (bStart > bEnd) return A[aStart + k - 1];
            if (k == 1) return Math.min(A[aStart], B[bStart]);

            int midA = Math.min(k / 2, aLen);
            int midB = k - midA;

            if (A[aStart + midA - 1] < B[bStart + midB - 1])
                return findK(A, aStart + midA, aEnd, B, bStart, bEnd, k - midA);
            else if (A[aStart + midA - 1] > B[bStart + midB - 1])
                return findK(A, aStart, aEnd, B, bStart + midB, bEnd, k - midB);
            else return A[aStart + midA - 1];
        }

        private int findK1(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;
            if (aLen > bLen) return findK1(B, bStart, bEnd, A, aStart, aEnd, k);

            if (aStart > aEnd) return B[bStart + k - 1];
            if (bStart > bEnd) return A[aStart + k - 1];
            if (k == 1) return Math.min(A[aStart], B[bStart]);

            int midA = Math.min(k / 2, aLen);
            int midB = k - midA;

            if (A[aStart + midA - 1] < B[bStart + midB - 1])
                return findK1(A, aStart + midA, aEnd, B, bStart, bEnd, k - midA);
            else if (A[aStart + midA - 1] > B[bStart + midB - 1])
                return findK1(A, aStart, aEnd, B, bStart + midB, bEnd, k - midB);
            else return A[aStart + midA - 1];
        }

        private int findK2(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;
            if (aLen > bLen) return findK2(B, bStart, bEnd, A, aStart, aEnd, k);

            if (aStart > aEnd) return B[bStart + k - 1];
            if (bStart > bEnd) return A[aStart + k - 1];
            if (k == 1) return Math.min(A[aStart], B[bStart]);

            int midA = Math.min(k / 2, aLen);
            int midB = k - midA;

            if (A[aStart + midA - 1] < B[bStart + midB - 1])
                return findK2(A, aStart + midA, aEnd, B, bStart, bEnd, k - midA);
            else if (A[aStart + midA - 1] > B[bStart + midB - 1])
                return findK2(A, aStart, aEnd, B, bStart + midB, bEnd, k - midB);
            else return A[aStart + midA - 1];
        }
    }
}
