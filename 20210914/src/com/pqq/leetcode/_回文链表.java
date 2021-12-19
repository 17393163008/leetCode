package com.pqq.leetcode;

import java.util.List;

/**
 * @author pqq
 * @create ${year}-09-14 18:57
 */
public class _回文链表 {
    public boolean isPalindrome(ListNode head)
    {
        //找到中间节点
        ListNode mid = findMid(head);

        //将右半部分的链表反转（右半部分链表不包括中间节点）
        ListNode reverseList = reverse(mid.next);
        mid.next = null;  //将两个链表断开
        //判断左半部分的链表和反转之后的右半部分的链表是否对应相等
        while(head != null && reverseList !=null)
        {
            if(head.val!=reverseList.val)
                return false;
            head = head.next;
            reverseList = reverseList.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;

    }

    private ListNode findMid(ListNode head) {
        //设置一个辅助头结点，快慢指针都从辅助头结点出发
        ListNode fast = new ListNode(0);
        ListNode slow = fast;
        fast.next = head;

        //当fast == null 或者 fast.next == null时，代表此时slow指向了中间节点
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
