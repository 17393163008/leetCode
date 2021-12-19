package com.pqq.leetcode;

/**
 * Created by liujiawei on 2018/7/6.
 */
public class TestEatNoodleInMall implements Runnable{


    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                System.out.println("面馆准备了" + i + "份材料");
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        TestEatNoodleInMall eatNoodleInMall = new TestEatNoodleInMall();
        Thread thread = new Thread(eatNoodleInMall,"");
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            if(i == 9)
                System.out.println("小明吃完了面");
        }


    }



}