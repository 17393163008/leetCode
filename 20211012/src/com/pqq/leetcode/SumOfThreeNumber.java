package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-10-12 16:58
 */
public class SumOfThreeNumber {
    public List<List<Integer>> threeSum(int[] nums) {
        //1、根据题意，需要创建一个list用于存储三元组的结果集
        //ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //2、获取nums的长度
        int n = nums.length;

        //3、枚举a
        for(int first = 0; first < n; first++)
        {
            //需要与上一次枚举的数字不一样
            if(first > 0 && nums[first] == nums[first-1])
            {
                continue;
            }

            //c对应的指针初始指向数组的最右端
            int third = n-1;
            int target = -nums[first];

            //枚举b

            //b从a的后一位开始遍历，知道数组结束为止
            for(int second = first+1;second < n;second++)
            {
                //前一个条件是为了防止second向左边越界
                if(second>first+1 && nums[second] == nums[second-1])
                {
                    continue;
                }

                while(second < third && nums[second]+nums[third] > target)
                {
                    --third;
                }

                //如果指针重合，随着b后续的增加
                //就不会满足a+b+c=0并且b<c的c存在了，此时就可以退出循环

                if(second ==third)
                {
                    break;
                }

                if(nums[second] + nums[third] == nums[first])
                {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    lists.add(l);
                }
            }



        }
        return lists;
    }
}
