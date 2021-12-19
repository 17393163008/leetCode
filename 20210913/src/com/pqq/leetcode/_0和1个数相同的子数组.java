package com.pqq.leetcode;

import java.util.HashMap;

/**
 * @author pqq
 * @create ${year}-09-13 9:25
 */
public class _0和1个数相同的子数组 {
    public int findMaxLength(int[] nums)
    {
        HashMap<Integer,Integer> map = new HashMap<>();   //新建一个hashmap对象
        map.put(0,-1);     //将0映射为-1，方便后面的抵消
        int pre_sum = 0;              //前缀和为0
        int ret = 0;                  //最大子数组长度和变量设置为0
        for (int i = 0; i < nums.length; i++) {
            pre_sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(pre_sum))           //如果这个数字为0
            {
                ret = Math.max(ret,i-map.get(pre_sum));


            }else{
                map.put(pre_sum,i);   //将1加入
            }


        }
        return ret;
    }
}
