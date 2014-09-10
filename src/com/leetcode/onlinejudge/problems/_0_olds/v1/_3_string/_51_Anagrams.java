package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.*;

/**
 * Created by Who on 2014/8/9.
 */
public class _51_Anagrams extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given an array of strings, return all groups of strings that are anagrams.\n" +
                "Note: All inputs will be in lower-case.";
    }

    @Override
    public void run() {
        print(new Solution().anagrams(new String[]{"tea", "and", "ate", "eat", "den"}));
    }

    public class Solution {
        public List<String> anagrams(String[] strs) {
            HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
            for (String i : strs) {
                char[] chars = i.toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (hashMap.containsKey(s)) {
                    hashMap.get(s).add(i);
                } else {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    arrayList.add(i);
                    hashMap.put(s, arrayList);
                }
            }
            ArrayList<String> result = new ArrayList<String>();
            Iterator<ArrayList<String>> iterator = hashMap.values().iterator();
            while (iterator.hasNext()) {
                ArrayList<String> arrayList = iterator.next();
                if (arrayList.size() > 1) {
                    for (String i : arrayList) {
                        result.add(i);
                    }
                }
            }
            return result;
        }
    }
}
