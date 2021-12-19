package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-21 10:07
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

}

public class 两数相加 {
    int carry = 0; //记录进位

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        //定义终止条件，当l1,l2指针都为null且进位为0->null
        if (l1 == null && l2 == null && carry == 0)
            return null;
        //当有一条链表为null且进位为0时，next指针直接指向另一条链表，返回
        if (l1 != null && l2 == null && carry == 0)
            return l1;
        else if (l1 == null && l2!=null && carry == 0)
            return l2;

        //sum = 两链表指针位置上的数字加上进位
        int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
        //计算进位
        int value = sum%10;
        ListNode node = new ListNode(value);

        //递归算出这个node的next指向
        node.next = addTwoNumber((l1==null?null:l1.next),(l2==null?null:l2.next));
        return node;
    }
}
