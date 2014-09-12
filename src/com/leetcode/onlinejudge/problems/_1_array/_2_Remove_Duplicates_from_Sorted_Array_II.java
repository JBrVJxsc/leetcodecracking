package com.leetcode.onlinejudge.problems._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Xu on 9/10/14.
 */
public class _2_Remove_Duplicates_from_Sorted_Array_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public String getSummary() {
        return "Follow up for \"Remove Duplicates\":\n" +
                "What if duplicates are allowed at most twice?\n" +
                "For example,\n" +
                "Given sorted array A = [1,1,1,2,2,3],\n" +
                "Your function should return length = 5, and A is now [1,1,2,2,3].";
    }

    @Override
    public void run() {
        int[] ints = new int[]{1, 1, 1, 2, 2, 3};
        new Solution().removeDuplicates(ints);
    }

    public class Solution {
        public int removeDuplicates(int[] A) {
            if (A == null) {
                return 0;
            }
            if (A.length <= 2) {
                return A.length;
            }
            int index = 2;
            for (int i = 2; i < A.length; i++) {
                if (A[i] != A[index - 2]) {
                    A[index++] = A[i];
                }
            }
            return index;
        }
    }
}
