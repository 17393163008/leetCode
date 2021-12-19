package com.pqq.leetcode;

import com.sun.javafx.scene.CameraHelper;
import sun.misc.LRUCache;

import java.util.LinkedHashMap;

/**
 * @author pqq
 * @create ${year}-09-14 19:53
 */
public class _最近最少使用的缓存 {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

//    public LRUCache(int capcity)
//    {
//        cap = capcity;
//    }

    public int get(int key)
    {
        if(!cache.containsValue(key))
        {
            return -1;
        }
        int val = cache.get(key);
        makeRecently(key);
        return val;
    }

    public void put(int key, int value)
    {
        if(cache.containsValue(key))
        {
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=cap)
        {
            //链表头部就是最久未曾被使用的
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
