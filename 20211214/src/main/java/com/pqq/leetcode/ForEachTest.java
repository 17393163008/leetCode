package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author pqq
 * @create ${year}-12-15 9:45
 */
public class ForEachTest {
    public static void main(String[] args) {
        System.err.println(args.length);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.interrupted();
    }
}
