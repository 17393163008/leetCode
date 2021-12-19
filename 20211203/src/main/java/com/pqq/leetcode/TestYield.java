package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-12-05 8:51
 */

public class TestYield implements Runnable{

    public void run() {
        if(Thread.currentThread().getName().equals("A")){
            Thread.currentThread().yield();
            System.out.println(Thread.currentThread().getName());
        }else{
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestYield yield = new TestYield();
        Thread thread = new Thread(yield,"A");
        Thread thread1 = new Thread(yield,"B");
//        thread.join();
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
    }


}
