package com.pqq.leetcode;

import java.util.Date;

/**
 * Created by liujiawei on 2018/7/6.
 */
public class TestSleep implements Runnable{

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(new Date());
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        TestSleep sleep = new TestSleep();

        Thread thread = new Thread(sleep);
        thread.start();

    }
}