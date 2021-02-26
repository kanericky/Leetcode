package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question83 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newNode = deleteDuplicates(node1);

        while(newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode current = head;

        while(current.next != null){
            if(current.next.val == current.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}
