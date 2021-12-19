package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-14 8:41
 */
public class _删除字符判断是否回文 {
    public boolean validPalindrome(String s)
    {
        for(int left = 0, right = s.length()-1; left < right; left++,right--)
        {
            //如果不相等，则分两种情况，删除左边的元素或者删除右边的元素，再判断是否相等
            if(s.charAt(left) != s.charAt(right))
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
        }
        return true;
    }

    private boolean isPalindrome(String s, int left,int right)
    {
        while(left < right)
        {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
