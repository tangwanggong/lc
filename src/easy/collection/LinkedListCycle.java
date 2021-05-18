package easy.collection;

import structure.ListNode;

/**

 * @create: 2018/9/29 11:30
 **/
public class LinkedListCycle {
    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * Follow up:
     * Can you solve it without using extra space?
     * A每次走一步，B每次走两步,如果是环形,则迟早会相遇，好乐观的算法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
