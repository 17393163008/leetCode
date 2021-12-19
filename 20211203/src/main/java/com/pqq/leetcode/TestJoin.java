
package com.pqq.leetcode;

import java.util.ArrayList;

/**
 * Created by liujiawei on 2018/7/6.
 */
public class TestJoin implements Runnable{

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        TestJoin eatNoodle = new TestJoin();
        Thread thread = new Thread(eatNoodle,"放水");
        Thread thread2 = new Thread(eatNoodle,"下面");
        Thread thread3 = new Thread(eatNoodle,"吃面");
        Thread thread4 = new Thread(eatNoodle,"洗碗");


        thread.start();

        thread.join();
        thread2.start();

        thread2.join();
        thread3.start();

        thread3.join();
        thread4.start();
    }
}