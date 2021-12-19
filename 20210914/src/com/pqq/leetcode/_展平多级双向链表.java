package com.pqq.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author pqq
 * @create ${year}-09-14 19:12
 */
class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;
};

public class _展平多级双向链表 {
    public Node1 flatten(Node1 head)
    {
        //栈
        Deque<Node1> q = new ArrayDeque<>();
        Node1 n = head;
        while(head != null)
        {
            if(head.child != null)
            {
                if(head.next != null)
                    q.push(head.next);
                //连接
                head.next = head.child;
                head.child.prev = head;
                //断开
                Node1 m = head.child;
                head.child = null;

                head= m;
            }else{
                if(head.next!=null)
                {
                    head = head.next;
                }else{
                    Node1 l = head;
                    if(!q.isEmpty())
                    {
                        head = q.pop();
                    }else
                        break;
                    //连接
                    l.next = head;
                    head.prev = l;
                }
            }
        }
        return n;
    }
}
