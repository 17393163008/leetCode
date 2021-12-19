package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-09-13 20:22
 */
public class _字符串中所有的变位词 {
    public List<Integer> findAnagrams(String s, String p)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(s.length() < p.length())
            return ans;

        int left = 0,right = 0;
        int[] count = new int[26];
        while(right < p.length())
        {
            count[p.charAt(right)-'a']++;
            count[s.charAt(right)-'a']--;
            right++;
        }

        if(allZero(count))
            ans.add(left);
        while(right < s.length())
        {
            count[s.charAt(right++)-'a']--;
            count[s.charAt(left++)-'a']++;
            if(allZero(count))
                ans.add(left);
        }
        return ans;
    }

    private boolean allZero(int[] arr)
    {
        for(int num : arr)
        {
            if(num != 0)
            {
                return false;
            }
        }
        return true;
    }

}
