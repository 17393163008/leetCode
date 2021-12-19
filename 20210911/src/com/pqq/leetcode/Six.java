package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-12 11:34
 */
public class Six {
    public int[] twoSum(int[] nums, int target)
    {
        if(nums==null || nums.length == 0)
        {
            return new int[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            int sum = nums[left]+nums[right];
            if(sum == target)
                return new int[]{left,right};
            else if(sum < target)
            {
                left++;
            }else
            {
                right--;
            }
        }
        return  new int[0];
    }
}
