package com.pqq.test;

/**
 * @author pqq
 * @create ${year}-12-16 12:25
 */
public class T1 {
    volatile int n = 0;

    public void add(){
        n++;
    }

    public static void main(String[] args) {
        String s = "wo";
        System.out.println("wo".equals(s));
    }
}
