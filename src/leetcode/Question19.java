package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode nthNode = removeNthFromEnd(node1, 1);
        while(nthNode != null){
            System.out.println(nthNode.val);
            nthNode = nthNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode slow = head, fast = head;

        for(int i = 0; i < n ; i++){
            fast = fast.next;
        }

        if(fast == null){
            head = head.next;
        }else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            if(slow.next != null && slow.next.next != null){
                slow.next = slow.next.next;
            }else{
                slow.next = null;
            }
        }
        return head;

    }

}
