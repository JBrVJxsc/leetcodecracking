package com.leetcode.onlinejudge.problems._0_olds.v1._8_brute;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Who on 2014/8/18.
 */
public class _99_Letter_Combinations_of_a_Phone_Number extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a digit string, return all possible letter combinations that the number could represent.\n" +
                "A mapping of digit to letters (just like on the telephone buttons) is given below.\n" +
                "Input:Digit string \"23\"\n" +
                "Output: [\"ad\", \"ae\", \"af\", \"bd\", \"be\", \"bf\", \"cd\", \"ce\", \"cf\"].\n" +
                "Note:\n" +
                "Although the above answer is in lexicographical order, your answer could be in any order you want.";
    }

    @Override
    public void run() {
        List<String> list = new Solution().letterCombinations("32");
    }

    public class Solution {

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<String>();
            if (digits.length() == 0) {
                result.add("");
                return result;
            }
            String[] strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            for (int i = 0; i < digits.length(); i++) {
                char[] cs = strings[Integer.parseInt(String.valueOf(digits.charAt(i)))].toCharArray();
                if (result.size() > 0) {
                    int size = result.size();
                    for (int index = 0; index < size; index++) {
                        String s = result.get(index);
                        for (char c : cs) {
                            if (!result.contains(s + String.valueOf(c))) {
                                result.add(s + String.valueOf(c));
                            }
                        }
                    }
                } else {
                    for (char c : cs) {
                        result.add(String.valueOf(c));
                    }
                }
            }
            while (result.get(0).length() < digits.length()) {
                result.remove(0);
            }
            return result;
        }
    }
}
