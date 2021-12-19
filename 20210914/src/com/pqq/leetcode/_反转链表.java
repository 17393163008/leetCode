package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-14 14:48
 */

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}

public class _反转链表 {
    public ListNode3 reverseList(ListNode3 head) {
        ListNode3 ans = null;
        while (head != null) {
            //反转当前节点前，需要先将当前节点后面剩下对的链表保存
            ListNode3 restList = head.next;
            head.next = ans;  //将当前节点反转
            ans = head; //更新已被反转的链表的首元节点
            head = restList; //更新剩下链表的首元节点

        }
        return ans; //返回反转后的链表的首元节点
    }
}
