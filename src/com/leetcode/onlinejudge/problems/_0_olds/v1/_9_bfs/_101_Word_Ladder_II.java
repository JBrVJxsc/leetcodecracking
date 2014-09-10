package com.leetcode.onlinejudge.problems._0_olds.v1._9_bfs;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.*;

/**
 * Created by Who on 2014/8/24.
 */
public class _101_Word_Ladder_II extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:\n" +
                "Only one letter can be changed at a time\n" +
                "Each intermediate word must exist in the dictionary\n" +
                "For example,\n" +
                "Given:\n" +
                "start = \"hit\"\n" +
                "end = \"cog\"\n" +
                "dict = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]\n" +
                "Return\n" +
                "  [\n" +
                "    [\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],\n" +
                "    [\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]\n" +
                "  ]\n" +
                "Note:\n" +
                "All words have the same length.\n" +
                "All words contain only lowercase alphabetic characters.";
    }

    @Override
    public String getNote() {
        return "UNSOLVED";
    }

    @Override
    public void run() {
        Set<String> dict = new HashSet<String>();
        dict.add("ted");
        dict.add("tex");
        dict.add("red");
        dict.add("tax");
        dict.add("tad");
        dict.add("den");
        dict.add("rex");
        dict.add("pee");
        print(new Solution().findLadders("red", "tax", dict));
    }

    // My wrong solution.
    public class Solution {
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            List<List<String>> lists = new ArrayList<List<String>>();
            List<List<String>> tempLists = new ArrayList<List<String>>();
            Queue<String> queue = new ArrayDeque<String>();
            queue.add(start);
            List<String> startList = new ArrayList<String>();
            startList.add(start);
            tempLists.add(startList);
            while (!queue.isEmpty()) {
                String curString = queue.remove();
                List<String> curList = null;
                for (int i = tempLists.size() - 1; i >= 0; i--) {
                    if (tempLists.get(i).get(tempLists.get(i).size() - 1).equals(curString)) {
                        curList = tempLists.get(i);
                        break;
                    }
                }
                for (int i = 0; i < curString.length(); i++) {
                    char[] chars = curString.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String str = String.valueOf(chars);
                        if (str.equals(end)) {
                            curList.add(end);
                            if (lists.size() != 0 && lists.get(lists.size() - 1).size() < curList.size()) {
                                return lists;
                            } else {
                                lists.add(curList);
                            }
                        }
                        if (dict.contains(str) && !str.equals(curString)) {
                            dict.remove(str);
                            queue.add(str);
                            List<String> list = new ArrayList<String>(curList);
                            list.add(str);
                            tempLists.add(list);
                        }
                    }
                }
            }
            return lists;
        }
    }
}
