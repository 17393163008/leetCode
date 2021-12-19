package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-11 11:10
 */
public class Four {
    public int singleNumber(int[] nums)
    {
        int ones = 0, twos = 0;
        for(int num: nums)
        {
            ones = ones  ^ num & ~ twos;
            twos = twos ^ num & ~ones;

        }
        return ones;
    }

    public static void main(String[] args) {

        int[] ones = {1,0,1,1};
        Four four = new Four();
        int i = four.singleNumber(ones);
        System.out.println(i);
    }
}
