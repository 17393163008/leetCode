package com.pqq.leetcode;

import javax.sound.sampled.ReverbType;

/**
 * @author pqq
 * @create ${year}-09-14 15:58
 */
public class _重排链表 {
    public void reorderList(ListNode head)
    {
        //找到中间节点
        ListNode mid = findMid(head);
        //通过中间节点，将链表分为两部分，左边一部分不动，将右边一部分翻转，
        ListNode curA = head;
        ListNode curB = reverse(mid.next);  //中间节点划分到左边部分
        mid.next = null;  //将链表一分为二
        //将两个链表合并
        merge(curA,curB);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        int flag = 1;
        //设定一个标记，辅助交叉遍历两个链表
        //flag为奇数则插入l1的节点，flag为偶数则插入l2的节点
        ListNode head = new ListNode(0);
        while(l1!=null || l2 != null)
        {
            if(flag % 2 == 0)
            {
                head.next = l2;
                l2 = l2.next;
            }else{
                head.next = l1;
                l1 = l1.next;
            }
            flag++;
            head = head.next;
        }
        return head.next;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode reverseList = null;
        while(head!=null)
        {
            ListNode next = head.next;
            head.next = reverseList;
            reverseList = head;
            head = next;
        }
        return reverseList;
    }


    private ListNode findMid(ListNode head) {
        //创建一个辅助头结点
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        //从辅助头结点开始，快指针一次走过两个单位，慢指针一次走一个单位
        //当快指针.next == null或者快指针 == null则表名，slow指向了中间节点

        ListNode slow = tmp,fast = tmp;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
