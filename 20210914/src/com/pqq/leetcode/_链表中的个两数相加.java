package com.pqq.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author pqq
 * @create ${year}-09-14 15:02
 */
class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4() {
    }

    ListNode4(int val) {
        this.val = val;
    }

    ListNode4(int val, ListNode4 next) {
        this.val = val;
        this.next = next;
    }
}

public class _链表中的个两数相加 {
    public ListNode4 addTwoNumber(ListNode4 l1, ListNode4 l2) {
        //设置两个栈，将两个链表分别入栈
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //ans保存相加后的链表头
        ListNode4 ans = null;
        //bit 保存进位值
        int bit = 0;

        //将两个栈中的数据同时 出栈，可以达到右端对齐的效果
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (stack1.isEmpty()) {
                sum += stack2.pop();
            } else if (stack2.isEmpty()) {
                sum += stack1.pop();
            } else {
                sum += (stack1.pop() + stack2.pop());

            }

            //更新相加后的值，以及进位值

            sum += bit;
            bit = sum / 10;
            sum %= 10;
            //将相加后的值，作为一个节点插入
            ListNode4 node = new ListNode4(sum);
            node.next = ans;
            ans = node;

        }

        //注意：最后一次相加可能有进位，需要进行判断，是否需要再创建一个新的节点
        if(bit > 0)
        {
            ListNode4 node = new ListNode4(bit);
            node.next = ans;
            ans = node;
        }

        //返回结果
        return ans;
    }
}
