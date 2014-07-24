package com.leetcode.onlinejudge.problems;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/24.
 */
public class _5_Median_of_Two_Sorted_Arrays extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted\n" +
                "arrays. The overall run time complexity should be O(log(m + n)).";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{5, 6, 7, 8, 9, 10};
        double median = new Solution().findMedianSortedArrays(a, b);
        print();
        print("The median is: " + median);
    }

    public class Solution {
        public double findMedianSortedArrays(int A[], int B[]) {
            int k = A.length + B.length;
            return k % 2 == 0 ? (findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1) +
                    findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2)) / 2
                    : findK(A, 0, A.length - 1, B, 0, B.length - 1, k / 2 + 1);
        }

        //返回两个数组中第k大的元素。
        public double findK(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
            // 假设A的大小永远小于等于B的大小。
            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;
            if (aLen > bLen) return findK(B, bStart, bEnd, A, aStart, aEnd, k); //a的长度比b的小。

            if (aStart > aEnd) return B[bStart + k - 1];
            if (bStart > bEnd) return A[aStart + k - 1];
            if (k == 1) return Math.min(A[aStart], B[bStart]);
            int midA = Math.min(k / 2, aLen);
            int midB = k - midA;
            //如果a的第midA大的元素比b的第midB大的元素小，
            //那么删掉a的前midA个元素，在剩余的数中找第k-midA大的。
            if (A[aStart + midA - 1] < B[bStart + midB - 1])
                return findK(A, aStart + midA, aEnd, B, bStart, bEnd, k - midA);
            else if (A[aStart + midA - 1] > B[bStart + midB - 1])
                return findK(A, aStart, aEnd, B, bStart + midB, bEnd, k - midB);
            else
                return A[aStart + midA - 1];
        }
    }

    public class Solution1 {
        public double findMedianSortedArrays(int A[], int B[]) {
            int m = A.length;
            int n = B.length;

            if ((m + n) % 2 != 0) // odd
                return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
            else { // even
                return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                        + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
            }
        }

        public int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

            print();
            print("k: " + k + ", aStart: " + aStart + ", aEnd: " + aEnd + ", bStart: " + bStart + ", bEnd: " + bEnd);
            print("A[]:");
            print(A, aStart, aEnd);
            print("B[]:");
            print(B, bStart, bEnd);

            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;

            print("aLen: " + aLen + ", bLen: " + bLen);

            // Handle special cases
            if (aLen == 0)
                return B[bStart + k];
            if (bLen == 0)
                return A[aStart + k];
            if (k == 0)
                return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

            int aMid = aLen * k / (aLen + bLen); // a's middle count
            int bMid = k - aMid - 1; // b's middle count

            print("aMid: " + aMid + ", bMid: " + bMid);

            // make aMid and bMid to be array index
            aMid = aMid + aStart;
            bMid = bMid + bStart;

            print("aMid: " + aMid + ", bMid: " + bMid + " (Index)");

            if (A[aMid] > B[bMid]) {
                k = k - (bMid - bStart + 1);
                aEnd = aMid;
                bStart = bMid + 1;
            } else {
                k = k - (aMid - aStart + 1);
                bEnd = bMid;
                aStart = aMid + 1;
            }

            return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
        }
    }
}
