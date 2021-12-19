package com.pqq.leetcode;

import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-15 8:53
 */
public class _外星语言是否排序 {
    public boolean isAlienSorted(String[] words,String order)
    {
        int[] map = new int[26];
        for(int i = 0; i < 26; i++)
            map[order.charAt(i)-'a'] = i;   //数组模拟哈希，记录键值对<字母，下标>
        for(int i = 0; i < words.length-1; i++) //比较相邻字符串在题目所给的字典序大小
        {
            String a = words[i],b = words[i+1];
            int i1 = 0,i2=0,l1 = a.length(),l2 = b.length();
            while(i1 < l1 || i2 < l2)  //比较a，b的每个字符
            {
                int index1 = i1 < l1 ? map[a.charAt(i1++)-'a']:-1;
                int index2 = i2 < l2 ? map[b.charAt(i2++)-'a'] : -1;
                if(index1<index2)
                    break;
                else if(index1 > index2)
                    return false;
            }
        }
        return true;


    }
}
