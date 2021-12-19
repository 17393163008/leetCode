package com.pqq.test;

/**
 * @author pqq
 * @create ${year}-12-16 19:51
 */
public class SingletonDemo {
    private static volatile SingletonDemo singletonDemo = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"  这是构造方法");
    }

    public static SingletonDemo getSingletonDemo(){
        if(singletonDemo == null){
            synchronized (SingletonDemo.class){
                if(singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            new Thread(() -> {
                SingletonDemo.getSingletonDemo();
            }, String.valueOf(i)).start();
        }
    }
}
