package com.pqq.test;

import java.util.Stack;

/**
 * @author pqq
 * @create ${year}-12-16 22:54
 */
public class StackTest {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if(isNum(token)){
                stack.push(Integer.valueOf(token));
            }else{
                int s2 = stack.pop();
                int s1 = stack.pop();
                if("+".equals(token)){
                    stack.push(s2+s1);
                }
                else if("-".equals(token)){
                    stack.push(s1-s2);
                }
                else if("*".equals(token)){
                    stack.push(s2*s1);
                }
                else if("/".equals(token)){
                    stack.push(s1/s2);
                }
            }

        }
        return stack.pop();
    }

    public static boolean isNum(String str){
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)?false:true;
    }

    public static void main(String[] args) {


    }
}
