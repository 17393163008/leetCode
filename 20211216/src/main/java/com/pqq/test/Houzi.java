package com.pqq.test;

/**
 * @author pqq
 * @create ${year}-12-16 15:39
 */
public class Houzi {
    static int sum = 1;  //桃子总数

    public static void main(String[] args) {
        for(int i = 0; i < 9; i++){
            sum = (sum+1)*2;
        }
        System.out.println(sum);

        int t = sum;
        for(int j = 0; j < 9; j++){
            t = t/2-1;
        }
        System.out.println(t);
    }
}
