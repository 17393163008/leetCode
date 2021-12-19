package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-12-03 10:24
 */
public class ArrayStackTest {
    private String[] items;    //数组
    private int count;    //栈中元素的个数
    private int n;         //站的大小

    //初始化数组，申请一个大小为n的数组空间
    public ArrayStackTest(int n){
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈
    public boolean push(String item){
        //数组空间不够了，直接返回false
        if(count == n){
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    //出栈
    public String pop(){
        if(count == 0){
            return null;
        }
        String value = items[count-1];
        --count;
        return value;
    }

}
