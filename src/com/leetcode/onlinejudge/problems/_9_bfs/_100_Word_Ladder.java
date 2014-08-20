package com.leetcode.onlinejudge.problems._9_bfs;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Who on 2014/8/18.
 */
public class _100_Word_Ladder extends BaseProblem implements IProblem {
    @Override
    public String getSummary() {
        return "Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:\n" +
                "Only one letter can be changed at a time\n" +
                "Each intermediate word must exist in the dictionary\n" +
                "For example,\n" +
                "Given:\n" +
                "start = \"hit\"\n" +
                "end = \"cog\"\n" +
                "dict = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]\n" +
                "As one shortest transformation is \"hit\" -> \"hot\" -> \"dot\" -> \"dog\" -> \"cog\",\n" +
                "return its length 5.\n" +
                "Note:\n" +
                "Return 0 if there is no such transformation sequence.\n" +
                "All words have the same length.\n" +
                "All words contain only lowercase alphabetic characters.";
    }

    @Override
    public void run() {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        print(new Solution().ladderLength("hit", "cog", dict));
    }

    // My TLE solution.
    public class Solution {

        private int minLen = 0;

        public int ladderLength(String start, String end, Set<String> dict) {
            if (!start.equals(end)) {
                Set<String> starts = new HashSet<String>();
                starts.add(start);
                ladder(starts, end, dict, 2);
            }
            return minLen;
        }

        private void ladder(Set<String> starts, String end, Set<String> dict, int len) {
            if (len > minLen && minLen != 0 || starts.size() == 0) {
                return;
            }
            Set<String> set = new HashSet<String>();
            for (String str : starts) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String s = String.valueOf(chars);
                        if (s.equals(end)) {
                            if (minLen != 0) {
                                minLen = Math.min(minLen, len);
                            } else {
                                minLen = len;
                            }
                            return;
                        }
                        if (dict.contains(s) && !s.equals(str)) {
                            set.add(s);
                        }
                    }
                }
            }
            ladder(set, end, dict, len + 1);
        }
    }
}
