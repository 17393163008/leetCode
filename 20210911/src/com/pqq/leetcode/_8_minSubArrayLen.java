package com.pqq.leetcode;

import java.util.Random;

/**
 * @author pqq
 * @create ${year}-09-12 13:25
 */
public class _8_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums)
    {
        int left = 0;
        int total = 0;
        int ret = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++)
        {
            total += nums[right];
            while(total > target)
            {
                ret = Math.min(ret,right-left+1);
                total -= nums[left++];
            }
        }
        return ret > nums.length ? 0 : ret;
    }
}
