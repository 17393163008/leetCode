package com.pqq.leetcode;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author pqq
 * @create ${year}-12-10 13:52
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread = new Thread(mThread);
        Thread thread1 = new Thread(mThread);

        thread.start();
        thread1.start();
    }
}

class MThread implements Runnable{
    private static int ticket = 1000;

    public void run() {
        while (true){
            show();

        }
    }

    private synchronized void show(){
        if (ticket > 0) {



            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }

}
