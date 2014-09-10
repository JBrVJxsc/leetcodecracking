package com.leetcode.onlinejudge.problems._0_olds.v1._3_string;

import com.leetcode.interfaces.IProblem;
import com.leetcode.onlinejudge.BaseProblem;

/**
 * Created by Who on 2014/8/7.
 */
public class _39_Valid_Palindrome extends BaseProblem implements IProblem {
    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public String getSummary() {
        return "Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.\n" +
                "For example,\n" +
                "\"A man, a plan, a canal: Panama\" is a palindrome.\n" +
                "\"race a car\" is not a palindrome.\n" +
                "Note:\n" +
                "Have you consider that the string might be empty? This is a good question to ask during an interview.\n" +
                "For the purpose of this problem, we define empty string as valid palindrome.";
    }

    @Override
    public void run() {
        String s1 = ",,A man, a plan, a canal: Panama";
        s1 = "race a car";
        print(new Solution().isPalindrome(s1));
    }

    // My better solution without recursive method.
    public class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toLowerCase().toCharArray();
            int start = 0;
            int end = chars.length - 1;
            while (start < end) {
                char startChar = chars[start];
                char endChar = chars[end];
                if (!Character.isLetterOrDigit(startChar)) {
                    start++;
                } else if (!Character.isLetterOrDigit(endChar)) {
                    end--;
                } else if (startChar != endChar) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
            return true;
        }
    }

    // My recursively solution.
    public class Solution1 {
        public boolean isPalindrome(String s) {
            char[] chars = s.toLowerCase().toCharArray();
            return check(chars, 0, chars.length - 1);
        }

        private boolean check(char[] chars, int start, int end) {
            if (start >= end) return true;
            char s = chars[start];
            char e = chars[end];
            if (!Character.isLetterOrDigit(s))
                return check(chars, start + 1, end);
            else if (!Character.isLetterOrDigit(e))
                return check(chars, start, end - 1);
            else {
                if (s != e) return false;
                else
                    return check(chars, start + 1, end - 1);
            }
        }
    }
}
