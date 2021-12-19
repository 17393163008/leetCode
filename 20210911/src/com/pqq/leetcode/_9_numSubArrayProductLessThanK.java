package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-12 18:13
 */
public class _9_numSubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        if(k <= 1)
        {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        //循环变量：num[left..right]里面所有元素的成绩严格小于k
        while(right < len)
        {
            product *= nums[right];
            while(product >= k){
                product /= nums[left];
                left++;
            }
            count += (right-left+1);
            right++;
        }
        return count;
    }
}
