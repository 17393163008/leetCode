package com.pqq.leetcode;

import java.util.Stack;

/**
 * @author pqq
 * @create ${year}-09-15 18:40
 */
public class _每日温度 {
    public int[] dailyTemperatures(int[] temperatures)
    {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++)
        {
            while(!stack.empty() && temperatures[stack.peek()]<temperatures[i])
            {
                int index = stack.pop();
                ret[index] = i-index;
            }
            stack.push(i);
        }
        return ret;
    }
}
