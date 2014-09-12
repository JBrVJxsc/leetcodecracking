package com.leetcode.onlinejudge.problems._1_array;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Xu on 9/10/14.
 */
public class _1_Remove_Duplicates_from_Sorted_Array extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public String getSummary() {
        return "Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.\n" +
                "Do not allocate extra space for another array, you must do this in place with constant memory.\n" +
                "For example,\n" +
                "Given input array A = [1,1,2],\n" +
                "Your function should return length = 2, and A is now [1,2].";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public int removeDuplicates(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int currentPointer = 1;
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] != A[i]) {
                    A[currentPointer++] = A[i];
                }
            }
            return currentPointer;
        }
    }
}
