package hard.collection;

import structure.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @date 2021/8/31
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l+r) >> 1;
        return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return dummy.next;
    }
}
