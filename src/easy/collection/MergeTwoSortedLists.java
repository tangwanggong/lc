package easy.collection;

import structure.ListNode;

/**
 * @create: 2018/9/20 9:24
 **/
public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     * 递归添加元素
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        merge(listNode,l1,l2);
        return listNode.next;
    }
    public void merge(ListNode listNode,ListNode l1,ListNode l2){
        if(l1 == null){
            listNode.next = l2;
            return;
        }
        if(l2 == null){
            listNode.next = l1;
            return;
        }
        if(l1.val<l2.val){
            listNode.next = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            listNode.next = new ListNode(l2.val);
            l2 = l2.next;
        }
        merge(listNode.next,l1,l2);
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
