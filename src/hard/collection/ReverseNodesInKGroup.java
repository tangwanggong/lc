package hard.collection;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @date 2021/9/13
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head,b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) return a;
            b = b.next;
        }
        ListNode reverse = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return reverse;
    }

    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null,cur = a;
        while (cur != b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
