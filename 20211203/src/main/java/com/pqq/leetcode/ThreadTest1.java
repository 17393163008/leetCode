package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-12-10 12:59
 */
public class ThreadTest1 {
    int ticket = 1000;

    public static void main(String[] args) {


        MThread myThread = new ThreadTest1().new MThread();

        Thread thread = new Thread(myThread);
        thread.setName("一号窗口");

        Thread thread1 = new Thread(myThread);
        thread1.setName("二号窗口");
        thread.start();
        thread1.start();

    }

    class MThread implements Runnable{



        public void run() {
            while (ticket > 0){


                synchronized (ThreadTest2.class) {


                    if (ticket > 0) {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }
            }
        }



        private void show(){
            if (ticket > 0) {



                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }
        }
    }



}

