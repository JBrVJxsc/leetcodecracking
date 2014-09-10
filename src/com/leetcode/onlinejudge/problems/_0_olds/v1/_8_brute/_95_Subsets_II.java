package com.leetcode.onlinejudge.problems._0_olds.v1._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _95_Subsets_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a collection of integers that might contain duplicates, S, return all possible subsets.\n" +
                "Note:\n" +
                "Elements in a subset must be in non-descending order.\n" +
                "The solution set must not contain duplicate subsets.\n" +
                "For example,\n" +
                "If S = [1,2,2], a solution is:\n" +
                "[\n" +
                "  [2],\n" +
                "  [1],\n" +
                "  [1,2,2],\n" +
                "  [2,2],\n" +
                "  [1,2],\n" +
                "  []\n" +
                "]";
    }

    @Override
    public void run() {
        new Solution().subsetsWithDup(new int[]{1, 2, 2});
    }

    public class Solution {
        public List<List<Integer>> subsetsWithDup(int[] num) {
            if (num.length == 0) {
                return null;
            }
            Arrays.sort(num);
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            for (int i = num.length - 1; i >= 0; i--) {
                int size = lists.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> list = new ArrayList<Integer>(lists.get(j));
                    list.add(0, num[i]);
                    if (!lists.contains(list)) {
                        lists.add(lists.size(), list);
                    }
                }
                List<Integer> cur = new ArrayList<Integer>();
                cur.add(num[i]);
                if (!lists.contains(cur)) {
                    lists.add(lists.size(), cur);
                }
            }
            lists.add(new ArrayList<Integer>());
            return lists;
        }
    }
}
