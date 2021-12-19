package com.pqq.leetcode;

import java.util.*;

/**
 * @author pqq
 * @create ${year}-09-14 19:43
 */
public class _访问O容器 {
    private Map<Integer, Integer> num_idx = new HashMap<>();
    private List<Integer> nums = new ArrayList<>();

    Random rand = new Random();

//    public RandomizedSet()
//    {
//
//    }

    public boolean insert(int val)
    {
        if(num_idx.containsKey(val)==true)
            return false;
        int idx = nums.size();
        num_idx.put(val,idx);
        nums.add(val);
        return true;
    }


    public boolean remove(int val)
    {
        if(num_idx.containsKey(val) == false)
            return false;
        int idx = num_idx.get(val);
        int last_num = nums.get(nums.size()-1);
        num_idx.put(last_num,idx);
        nums.set(idx,last_num);

        num_idx.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom()
    {
        int idx = rand.nextInt(nums.size());
        return nums.get(idx);

    }

}
