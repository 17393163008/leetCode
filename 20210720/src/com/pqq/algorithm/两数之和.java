package com.pqq.algorithm;

/**
 * @author pqq
 * @create ${year}-07-20 10:53
 */
public class 两数之和 {
    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};
        if(nums.length==2){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
