package com.leetcode.onlinejudge.problems._9_bfs;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

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

    }

    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            return 0;
        }
    }
}
