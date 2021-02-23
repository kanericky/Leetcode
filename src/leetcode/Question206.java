package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */

public class Question206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
