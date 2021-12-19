package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-10-12 17:18
 */
public class ThreeNumberSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        ArrayList<List<Integer>> lists = new ArrayList<>();

        //对数组进行排序
        Arrays.sort(nums);
        //枚举a
        for(int i = 0; i < n; i++)
        {
            //当两个数组
            if(i>0 && nums[i] == nums[i-1])
            {
                continue;
            }

            int target = -nums[i];   //将第一个数字进行取反，比较第一个数字和后两个数字之后是否相等

            //第三个数字从后面往前面走
            int k = n-1;

            //遍历第二个数字
            for(int j = i+1; j<n;j++)
            {
                if(j>i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }

                while(nums[j]+nums[k] > target)
                {
                    if(j >= k)
                    {
                        break;
                    }
                    k--;
                }

                if(nums[i] + nums[j] + nums[k] == 0 && j < k)
                {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    lists.add(integers);
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        ThreeNumberSum threeNumberSum = new ThreeNumberSum();
        List<List<Integer>> lists = threeNumberSum.threeSum(nums);
        System.out.println(lists);
    }

}
