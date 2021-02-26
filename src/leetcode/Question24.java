package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newList = swapPairs(node1);

        while(newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node1 = head, node2;
        if(node1 != null && node1.next != null){
            node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            head = node2;
            while(node1.next != null && node1.next.next != null){
                node2 = node1.next.next;
                node1.next.next = node2.next;
                node2.next = node1.next;
                node1.next = node2;
                node1 = node2.next;
            }
        }
        return head;
    }

    public static ListNode swapInPairs(ListNode head){
        ListNode prev = head, current;
        if(head != null && head.next != null){
            current = prev.next;
            prev.next = current.next;
            current.next = prev;
            head = prev;
            while(prev.next != null && prev.next.next != null){
                current = prev.next.next;
                prev.next.next = current.next;
                current.next = prev.next;
                prev.next = current;
                prev = current.next;
            }
        }

        return head;
    }
}
