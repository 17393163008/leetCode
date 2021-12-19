package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-23 17:54
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int flag = x;
        int reverseNumber = 0;
        if(x < 0)
        {
            return false;
        }
        else
        {
            while (x!=0)
            {
                int temp = x%10;
                reverseNumber = reverseNumber*10+temp;
                x/=10;
            }
            if (reverseNumber==flag)
            {
                return true;
            }else
            {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(12321));
    }
}
