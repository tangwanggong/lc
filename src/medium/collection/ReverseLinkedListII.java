package medium.collection;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @date 2021/9/13
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween2(head.next,left-1,right-1);
        return head;
    }

    ListNode next  = null;

    public ListNode reverseN(ListNode head,int n){
        if(n == 1){
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = next;
        return last;
    }

}
