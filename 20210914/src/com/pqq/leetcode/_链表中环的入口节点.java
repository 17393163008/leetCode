
package com.pqq.leetcode;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;

/**
 * @author pqq
 * @create ${year}-09-14 11:31
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class _链表中环的入口节点 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                ListNode point = head;
                while(point != slow)
                {
                    point = point.next;
                    slow = slow.next;
                }
                return point;
            }
        }
        return null;
    }
}
