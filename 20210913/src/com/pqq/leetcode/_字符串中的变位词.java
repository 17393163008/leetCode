package com.pqq.leetcode;

import java.util.Arrays;

/**
 * @author pqq
 * @create ${year}-09-13 20:01
 */
public class _字符串中的变位词 {
    public boolean checkInclusion(String s1, String s2)
    {
        int[] arr1 = new int[26];   //定义26个字母长度的数组
        int[] arr2 = new int[26];
        if(s1.length()>s2.length())       //如果第一个数组的长度大于第二个，那么肯定不满足题意
        {
            return false;
        }
        for(int i = 0; i < s1.length(); i++)   //遍历第一个数组
        {
            arr1[s1.charAt(i)-'a']++;    //对每个字母出现的次数进行计数
            arr2[s2.charAt(i)-'a']++;
        }
        for(int i = s1.length(); i < s2.length(); i++)
        {
            if(Arrays.equals(arr1,arr2))
            {
                return true;
            }
            arr2[s2.charAt(i-s1.length())-'a']--;
            arr2[s2.charAt(i)-'a']++;
        }
        return Arrays.equals(arr1,arr2);

    }


}
