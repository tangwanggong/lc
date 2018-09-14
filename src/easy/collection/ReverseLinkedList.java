package easy.collection;

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Tang
 * @create: 2018/9/14 9:56
 **/
public class ReverseLinkedList {
    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     * 没有一点点思想- -
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        List<Integer> list = new ArrayList();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        ListNode listNode = new ListNode(list.get(list.size()-1));
        ListNode l = listNode;
        for (int i=list.size()-2;i>=0;i--){
            listNode.next = new ListNode(list.get(i));
            listNode = listNode.next;
        }
        return l;
    }
}