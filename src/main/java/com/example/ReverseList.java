package com.example;

public class ReverseList {
    //    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
