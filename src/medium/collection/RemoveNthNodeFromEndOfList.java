package medium.collection;

import structure.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @date 2021/8/31
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p2 = dummy;
        for (int i = 0; i < n+1; i++) {
            p = p.next;
        }
        while (p!=null){
            p2 = p2.next;
            p = p.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
