package com.pqq.algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * @author pqq
 * @create 2021-07-21 10:27
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(rightChar);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        无重复字符的最长子串 str = new 无重复字符的最长子串();
        int maxNum = str.lengthOfLongestSubstring(s);
        System.out.println(maxNum);
    }

}
