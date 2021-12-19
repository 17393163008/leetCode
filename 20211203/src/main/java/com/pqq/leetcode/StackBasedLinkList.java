package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-12-03 10:08
 */
public class StackBasedLinkList {
    //定义栈顶指针
    private Node top = null;

    //定义栈节点
    private static class Node{
        //栈节点数据域
        private int data;
        //站节点指针域
        private Node next;

        //构造函数
        public Node(int dasta, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    public void push(int value){
        //创建一个栈节点
        Node newNode = new Node(value,null);
        //判断栈是否为空
        if(top == null){
            //如果栈为空，则将入站的值作为站的第一个元素
            top = newNode;

        }else{
            //否则插入栈节点前
            newNode.next = top;
            top = newNode;
        }
    }


    public int pop(){
        if(top == null)
            return -1;

        int value = top.data;

        return value;
    }

    public void printAll(){
        //将栈指针赋值给p
        Node p = top;
        //循环遍历栈（遍历单链表）
        while(p!=null){
            System.out.println(p.data + "");

            p = p.next;
        }
        System.out.println();
    }
}
