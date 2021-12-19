package com.pqq.test;

import javax.lang.model.element.VariableElement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pqq
 * @create ${year}-12-16 10:37
 */

class MyData{
    //验证的关键点在于看有没有加关键字volatile的效果对比
    volatile int number = 0;

    public void addT060(){
        this.number = 60;
    }

    public void addPlusPlus(){
        number++;

    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic()
    {
        atomicInteger.getAndIncrement();
    }
}

//验证volatile的可见性
public class VolatileDemo {
    public static void main(String[] args) {   //main是一切方法的运行入口
        MyData myData = new MyData();

        for(int i = 1; i <= 20; i++){
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName()+"\t Atomicinteger number value: " + myData.atomicInteger);
    }
}
