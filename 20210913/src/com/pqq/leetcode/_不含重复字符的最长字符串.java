package com.pqq.leetcode;

import sun.security.jgss.HttpCaller;

import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-13 20:38
 */
public class _不含重复字符的最长字符串 {
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();  //新建一个hashmap对象

        int left = 0;    //角标标记
        int maxLen = 0;  //最长子串长度
        for(int right = 0; right < s.length(); right++)   //窗口向右边开始滑动
        {
            Integer val = map.get(s.charAt(right));    //判断这个位置是否有之前的统计记录
            if(val != null)
            {
                left = Math.max(left,val+1);
            }
            maxLen = Math.max(maxLen,right-left+1);
            map.put(s.charAt(right),right);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcadfgh";
        _不含重复字符的最长字符串 a = new _不含重复字符的最长字符串();
        System.out.println(a.lengthOfLongestSubstring(s));
    }
}
