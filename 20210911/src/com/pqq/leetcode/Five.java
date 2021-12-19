package com.pqq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pqq
 * @create ${year}-09-11 11:32
 */
public class Five {
    public int maxProduct(String[] words)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for(char c : words[i].toCharArray())
            {
                bitMask |= (1 << (c-'a'));
            }
            map.put(bitMask,Math.max(map.getOrDefault(bitMask,0),words[i].length()));


        }
        int ans = 0;
        for(int x:map.keySet())
        {
            for(int y : map.keySet())
            {
                if((x&y)==0)
                {
                    ans = Math.max(ans,map.get(x)*map.get(y));
                }
            }
        }
        return ans;
    }
}
