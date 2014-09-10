package com.leetcode.onlinejudge.problems._0_olds.v1._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _94_Subsets extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a set of distinct integers, S, return all possible subsets.\n" +
                "Note:\n" +
                "Elements in a subset must be in non-descending order.\n" +
                "The solution set must not contain duplicate subsets.\n" +
                "For example,\n" +
                "If S = [1,2,3], a solution is:\n" +
                "[\n" +
                "  [3],\n" +
                "  [1],\n" +
                "  [2],\n" +
                "  [1,2,3],\n" +
                "  [1,3],\n" +
                "  [2,3],\n" +
                "  [1,2],\n" +
                "  []\n" +
                "]";
    }

    @Override
    public void run() {

    }

    public class Solution {
        public List<List<Integer>> subsets(int[] S) {
            if (S.length == 0) {
                return null;
            }
            Arrays.sort(S);
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            for (int i = S.length - 1; i >= 0; i--) {
                int size = lists.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> list = new ArrayList<Integer>(lists.get(j));
                    list.add(0, S[i]);
                    lists.add(lists.size(), list);
                }
                List<Integer> cur = new ArrayList<Integer>();
                cur.add(S[i]);
                lists.add(lists.size(), cur);
            }
            lists.add(new ArrayList<Integer>());
            return lists;
        }
    }
}
