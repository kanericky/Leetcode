package leetcode;

import tools.ListNode;

import java.util.List;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        slow = slow.next;

        while(slow != null){
            if(slow.val != head.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode startNode){
        ListNode prev = null;
        ListNode next;

        while(startNode != null){
            next = startNode.next;
            startNode.next = prev;
            prev = startNode;
            startNode = next;
        }
        return prev;
    }

}
