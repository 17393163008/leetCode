package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-14 10:38
 */
public class _统计全部的回文字符串 {
    public int countSubstrings(String s)
    {
        if(s == null || s.length() == 0)
        {
            return 0;

        }
        int count = 0;
        //字符串的每个字符都会作为回文中心进行判断，中心是一个或者两个字符
        for(int i = 0; i < s.length(); ++i)
        {
            count += countPalindrome(s,i,i);
            count += countPalindrome(s,i,i+1);

        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        _统计全部的回文字符串 a= new _统计全部的回文字符串();
        System.out.println(a.countSubstrings("aaa"));
    }
}
