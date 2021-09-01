package easy.collection;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @date 2021/9/1
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        while (p1 != p2){
            p1 = p1 == null ? headB :p1.next;
            p2 = p2 == null ? headA :p2.next;
        }
        return p1;
    }
}
