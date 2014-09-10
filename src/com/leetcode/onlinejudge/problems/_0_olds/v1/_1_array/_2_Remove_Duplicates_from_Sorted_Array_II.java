package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/23.
 */
public class _2_Remove_Duplicates_from_Sorted_Array_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Follow up for \"Remove Duplicates\": What if duplicates are allowed at most twice?\n" +
                "For example, Given sorted array A = [1,1,1,2,2,3],\n" +
                "Your function should return length = 5, and A is now [1,1,2,2,3]";
    }

    @Override
    public void run() {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        print(new Solution().removeDuplicates(a));
    }

    public class Solution {
        public int removeDuplicates(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates1(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++) {
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            }
            return index + 1;
        }

        public int removeDuplicates2(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicates3(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicate4(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            return index + 1;
        }

        public int removeDuplicate5(int[] A) {
            if (A == null || A.length == 0) return 0;
            int index = 0;
            int occurrence = 2;
            for (int i = 1; i < A.length; i++)
                if (A[index] != A[i] || index >= occurrence - 1 && A[index] != A[index - (occurrence - 1)] || index < occurrence - 1)
                    A[++index] = A[i];
            return index + 1;
        }
    }
}