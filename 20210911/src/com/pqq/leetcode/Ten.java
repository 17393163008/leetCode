package com.pqq.leetcode;

import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-12 18:21
 */
public class Ten {
    public int subarraySum(int[] nums, int k)
    {
        int pre_sum = 0;
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i : nums)
        {
            pre_sum+=i;
            ret+=map.getOrDefault(pre_sum-k,0);
            map.put(pre_sum,map.getOrDefault(pre_sum,0)+1);
        }
        return ret;

    }
}
