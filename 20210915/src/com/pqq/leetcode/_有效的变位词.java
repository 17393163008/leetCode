package com.pqq.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-15 8:34
 */
public class _有效的变位词 {
    public boolean isAnagram(String s,String t)
    {
        if(s.length()!=t.length() || s.equals(t))
        {
            return false;
        }

        HashMap<Character, Integer> arr = new HashMap<>();
        for(char i : s.toCharArray())
        {
            arr.put(i,arr.getOrDefault(i,0)+1);
        }
        for(char j : t.toCharArray())
        {
            if(!arr.containsKey(j)|| arr.get(j)==0)
            {
                return false;
            }
            arr.put(j,arr.get(j)-1);
        }
        return true;
    }
}
