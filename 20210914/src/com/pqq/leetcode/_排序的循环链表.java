package com.pqq.leetcode;

import java.time.Instant;

/**
 * @author pqq
 * @create ${year}-09-14 19:25
 */
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class _排序的循环链表 {
    public Node insert(Node head,int insertVal)
    {
        if(head == null)
        {
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }
        Node max = null;
        Node cur = head;
        do{
            if(insertVal >= cur.val && insertVal <= cur.next.val)
            {
                Node temp = new Node(insertVal,cur.next);
                cur.next = temp;
                return head;
            }
            if(cur.val > cur.next.val)
            {
                max = cur;
            }
            cur = cur.next;
        }while(cur!=head);
        max = max == null ? cur:max;
        Node temp = new Node(insertVal, max.next);
        max.next = temp;
        return head;
    }
}
