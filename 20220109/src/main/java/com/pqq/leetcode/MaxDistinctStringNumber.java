package com.pqq.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘勤强
 * @create 2021-01-09 11:26
 */
public class MaxDistinctStringNumber {
    public int lengthOfLongestSubstring(String s)
    {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> ooc = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动1
        int rk = -1,ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(i != 0)
            {
                //左指针向右移动一格，移除一个字符
                ooc.remove(s.charAt(i-1));
            }
            while(rk+1 < n && !ooc.contains(s.charAt(rk+1)))
            {
                //不断地移动右指针
                ooc.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第一到rk个字符是一个极长的无重复字符串
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
