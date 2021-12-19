package com.pqq.leetcode;

import javafx.scene.effect.Reflection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pqq
 * @create ${year}-09-15 19:22
 */
public class RecentCounter {
    Queue<Integer> q = new LinkedList<>();
    int q_len = 0;

    public RecentCounter()
    {

    }

    public int ping(int t)
    {
        q.offer(t);
        q_len++;

        while(q.peek() < t-3000)
        {
            q.poll();
            q_len--;

        }
        return q_len;
    }


}
