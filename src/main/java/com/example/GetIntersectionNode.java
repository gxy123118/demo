package com.example;

public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//    输出：Intersected at '8'
//    解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//    从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//    在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//            — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
//            换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
//
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA=hA==null?headA:hA.next;
            hB=hB==null?headB:hB.next;
        }
        return hA;
    }
}
