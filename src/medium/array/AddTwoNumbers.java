package medium.array;

import structure.ListNode;

import java.util.List;

/**
 * @author tangh
 * @date 2020/1/17
 */
public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode last = null;
        while (l1!=null || l2!=null){
            temp.val = (l1==null?0:l1.val) + (l2==null?0:l2.val)+i;
            i=0;
            if(temp.val>9){
                temp.val-=10;
                i = 1;
            }
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            temp.next = new ListNode(0);
            last = temp;
            temp = temp.next;
        }
        if(i==1){
            temp.val=1;
        }
        if(temp.val==0){
            last.next = null;
        }
        return result;
    }

}
