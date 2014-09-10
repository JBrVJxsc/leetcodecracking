package com.leetcode.onlinejudge.problems._0_olds.v1._10_dfs;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xu on 9/10/14.
 */
public class _103_Palindrome_Partitioning extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string s, partition s such that every substring of the partition is a palindrome.\n" +
                "Return all possible palindrome partitioning of s.\n" +
                "For example, given s = \"aab\",\n" +
                "Return\n" +
                "  [\n" +
                "    [\"aa\",\"b\"],\n" +
                "    [\"a\",\"a\",\"b\"]\n" +
                "  ]";
    }

    @Override
    public String getNote() {
        return "UNSOLVED";
    }

    @Override
    public void run() {
        new Solution().partition("aab");
    }

    public class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<List<String>>();

            if (s == null || s.length() == 0) {
                return result;
            }

            ArrayList<String> partition = new ArrayList<String>();
            addPalindrome(s, 0, partition, result);

            return result;
        }

        private void addPalindrome(String s, int start, List<String> partition,
                                   List<List<String>> result) {
            //stop condition
            if (start == s.length()) {
                ArrayList<String> temp = new ArrayList<String>(partition);
                result.add(temp);
                return;
            }

            for (int i = start + 1; i <= s.length(); i++) {
                String str = s.substring(start, i);
                if (isPalindrome(str)) {
                    partition.add(str);
                    addPalindrome(s, i, partition, result);
                    partition.remove(partition.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
