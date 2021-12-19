package com.pqq.leetcode;

import java.util.Stack;

/**
 * @author pqq
 * @create ${year}-09-15 14:13
 */
public class _小行星碰撞 {
    public int[] asteroidCollision(int[] asteroids)
    {
        Stack<Integer> s = new Stack<>();  //新建一个整数类型的栈对象
        int p = 0;   //小行星的小标，记录当前行星是第几颗
        while(p < asteroids.length)  //当所有的小行星没有全部遍历结束，则继续
        {
            if(s.empty() || s.peek() < 0 || asteroids[p] > 0)
            {
                s.push(asteroids[p]);
            }else if(s.peek() <= -asteroids[p])
            {
                if(s.pop() < -asteroids[p])
                    continue;
            }
            p++;
        }
        int[] ret = new int[s.size()];
        for(int i = ret.length-1; i >= 0; i--)
        {
            ret[i] = s.pop();
        }
        return ret;
    }
}
