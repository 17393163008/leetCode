package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-22 9:40
 */
public class 最长回文串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
        {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        //s.charAt(i)每次会检查下标越界，因此先转换成字符数组，这一步非必需
        char[] charArray = s.toCharArray();

        //枚举所有长度严格大于的子串charArray[i...j]
        for(int i = 0; i < len-1;i++)
        {
            for (int j = 0; j < len; j++) {
                if(j-i+1>maxLen && validPalindromic(charArray,i,j))
                {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 验证子串 s[left..right]是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right)
    {
        while(left < right)
        {
            if(charArray[left]!=charArray[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "jlkahksabcbasfakldjfhasdklfhaksdf";
        最长回文串 s1s = new 最长回文串();
        String s1 = s1s.longestPalindrome(s);
        System.out.println(s1);
    }
}
