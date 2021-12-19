package com.pqq.leetcode;

import java.util.List;

/**
 * @author pqq
 * @create ${year}-09-14 11:07
 */
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}

public class _删除链表的倒数第n个 {
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        //创建辅助头结点，head，fast和slow都指向这个辅助头结点
        ListNode1 fast = new ListNode1(0);
        fast.next = head;
        head = fast;
        ListNode1 slow = fast;

        //fast指针先走n+1个单位
        for (int i = 0; i <= n; i++)
        {
            fast = fast.next;

        }

        //fast指针和slow指针一起移动，直到fast指针指向空后，slow指针则指向倒数第n+1个节点
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        //删除倒数第n个节点
        slow.next = slow.next.next;

        //由于我们设置了辅助头结点，所以head.next才是链表的首元节点
        return head.next;
    }
}
