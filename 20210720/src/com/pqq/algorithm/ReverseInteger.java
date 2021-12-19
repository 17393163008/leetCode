package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-22 16:25
 */
public class ReverseInteger {
    public int reverse(int x)
    {
        long n = 0;
        while(x!=0)
        {
            n = (n*10 + x %10);
            x = x/10;
        }
        return n==n ? (int) n : 0;
    }

    public static void main(String[] args) {
        ReverseInteger RI = new ReverseInteger();
        System.out.println(RI.reverse(-123));
    }
}
