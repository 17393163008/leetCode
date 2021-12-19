package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-13 9:39
 */
public class _左右两边子数组的和相等 {
    public int pivotIndex(int[] nums)
    {
        int total = 0;
        for(int num: nums)
        {
            total+=num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            //总和减去当前子数组和等于当前子数组减去当前值，则满足条件
            if(sum-nums[i] == total-sum)
                return i;

        }
        //若没有满足条件的值，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        _左右两边子数组的和相等 a = new _左右两边子数组的和相等();
        System.out.println(a.pivotIndex(nums));
    }
}
