package com.leetcode.onlinejudge.problems._0_olds.v1._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/7/24.
 */
public class _4_Search_in_Rotated_Sorted_Array_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Follow up for \"Search in Rotated Sorted Array\": What if duplicates are allowed?\n" +
                "Would this affect the run-time complexity? How and why?\n" +
                "Write a function to determine if a given target is in the array.";
    }

    @Override
    public void run() {
        int[] a = new int[]{4, 5, 6, 7, 7, 0, 1, 2, 2, 2, 4, 4};
        a = new int[]{1, 3, 1, 1, 1};
        print(new Solution().search(a, 4));
        print(new Solution().search(a, 5));
        print(new Solution().search(a, 6));
        print(new Solution().search(a, 7));
        print(new Solution().search(a, 0));
        print(new Solution().search(a, 1));
        print(new Solution().search(a, 2));
        print(new Solution().search(a, 100));
        print(new Solution().search(a, 200));
        print(new Solution().search(a, 3));
    }

    public class Solution {
        public boolean search(int[] A, int target) {
            return find(A, 0, A.length - 1, target);
        }

        private boolean check(int[] A, int start, int end) {
            for (int i = start; i < end; i++)
                if (A[i] != A[end]) return false;
            return true;
        }

        private boolean find(int[] A, int start, int end, int target) {
            if (start > end) return false;
            int middle = start + (end - start) / 2;
            if (target == A[middle]) return true;
            if (A[start] < A[middle] || A[start] == A[middle] && check(A, start, middle)) {
                if (A[start] <= target && target < A[middle])
                    return find(A, start, middle - 1, target);
                else return find(A, middle + 1, end, target);
            } else {
                if (A[middle] < target && target <= A[end])
                    return find(A, middle + 1, end, target);
                else return find(A, start, middle - 1, target);
            }
        }
    }
}
