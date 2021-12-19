package com.pqq.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pqq
 * @create ${year}-12-18 20:55
 */
class Phone implements Runnable{

    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS()");
        sendMail();
    }

    public synchronized void sendMail()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t #########invoked seneMail()");
    }

    Lock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        lock.lock();


        try {
            System.out.println(Thread.currentThread().getId()+"\t invoke get()");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }

    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t #########invoked set()");
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();  //17

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();
    }

}
