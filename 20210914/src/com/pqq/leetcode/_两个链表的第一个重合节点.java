package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-14 14:39
 */
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}

public class _两个链表的第一个重合节点 {
    public ListNode2 getIntersectionNode(ListNode2 headA, ListNode2 headB)
    {
        ListNode2 curA = headA;
        ListNode2 curB = headB;
        while(curA != curB)
        {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
