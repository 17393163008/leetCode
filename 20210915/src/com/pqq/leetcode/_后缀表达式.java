package com.pqq.leetcode;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * @author pqq
 * @create ${year}-09-15 13:49
 */
public class _后缀表达式 {
    public int eavlPRN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();
        for(String c: tokens)
        {
            switch (c)
            {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(calc(num1,num2,c));
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    private Integer calc(int a, int b, String op) {
        switch (op)
        {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            default:
                return a/b;
        }
    }
}
