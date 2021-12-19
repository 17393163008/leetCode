package com.pqq.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author pqq
 * @create ${year}-12-18 10:15
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        for(int i = 1; i <= 30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        /**
         * 1. 故障现象
         *      ava.util.ConcurrentModificationException
         *
         * 2. 导致原因
         *  并发争抢导致，参考我们的花名册签名情况
         *  一个人正在写入，另外一个同学过来抢夺，导致数据不一致，并发修改异常
         *
         * 3. 解决方案
         *   3.1 new Vector<>();
         *   3.2 Collections.synchronizedList(new ArrayList<>());
         *   3.3 new CopyOnWriteArrayList<>();
         */
    }


}
