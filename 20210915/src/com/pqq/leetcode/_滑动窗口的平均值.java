package com.pqq.leetcode;

import com.sun.glass.ui.Size;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pqq
 * @create ${year}-09-15 19:16
 */
public class _滑动窗口的平均值 {
    Queue<Integer> queue;
    int size;
    double sum;

    public _滑动窗口的平均值(int size){
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val)
    {
        sum += val;
        if(queue.size() == size)
            sum-=queue.poll();
        queue.offer(val);
        return sum/queue.size();
    }
}
