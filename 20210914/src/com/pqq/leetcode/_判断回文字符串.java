package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-14 8:24
 */
public class _判断回文字符串 {
    public boolean isPalindrome(String s)
    {
        //空字符串为回文字符串
        if(s.length()==0)
            return true;

        //设置左右两个指针
        for(int left = 0, right  =s.length()-1; left < right; left++,right--)
        {
            //跳过无效字符串
            while(!isValid(s.charAt(left)) && left < right)
            {
                left++;
            }

            while(!isValid(s.charAt(right)) && left < right)
            {
                right--;
            }

            //如果两个字符相等(都是大写字母或者小写字母或者数字)，则继续下一个字符的选择
            //如果两个字符不相等，判断是否是两个字母
            //如果两个都是字母，则他们的差的绝对值要是32
            //如果最多只有一个字母，则直接返回false
            if(left < right && s.charAt(left) != s.charAt(right))
            {
                if(!isLetter(s.charAt(left) )&& isLetter(s.charAt(right)) || Math.abs(s.charAt(left)-s.charAt(right))!=32)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char ch)
    {
        return ch >= 48 && ch <= 57 || ch >= 97 && ch <= 122 || ch >= 65 && ch <= 90;

    }

    private boolean isLetter(char ch)
    {
        return ch >=97 && ch <= 122 || ch >= 65 && ch <= 90;
    }

}
