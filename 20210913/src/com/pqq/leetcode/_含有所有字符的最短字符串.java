package com.pqq.leetcode;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-13 20:55
 */
public class _含有所有字符的最短字符串 {
    public String minWindow(String s, String t)
    {
        HashMap<Character,Integer> charToCount = new HashMap<>();
        //将字符串t中的字符加入到HashMap计数
        for(char ch : t.toCharArray())
        {
            charToCount.put(ch,charToCount.getOrDefault(ch,0)+1);

        }
        //count记录hashMap中字符种类的数量
        int count =  charToCount.size();
        //滑动窗口
        int start = 0,end = 0;
        //记录最短字符串的起止点和长度
        int minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        //滑动窗口法
        while(end < s.length() || (count == 0 && end == s.length()))
        {
            if(count > 0)
            {
                char endCh = s.charAt(end);
                if(charToCount.containsKey(endCh))
                {
                    charToCount.put(endCh,charToCount.get(endCh)-1);
                    if(charToCount.get(endCh)==0)
                    {
                        count--;
                    }
                }
                end++;
            }else
            {
                if(end-start < minLength)
                {
                    minLength = end-start;
                    minStart = start;
                    minEnd = end;
                }
                char startCh = s.charAt(start);
                if(charToCount.containsKey(startCh))
                {
                    charToCount.put(startCh,charToCount.get(startCh)+1);
                    if(charToCount.get(startCh) == 1)
                    {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart,minEnd):"";
    }

}
