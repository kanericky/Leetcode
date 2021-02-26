package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question328 {
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

        ListNode newList = oddEvenList(node1);

        while(newList != null){
            System.out.println(newList.val);
            newList = newList.next;
        }

    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        int counter =  2;
        ListNode list = head, listOdd = head, listEven = head.next;
        ListNode listEvenMarker = listEven;
        list = list.next;

        while(list != null && list.next != null){
            counter++;
            if(counter % 2 == 1){
                listOdd.next = list.next;
                listOdd = listOdd.next;
            }else{
                listEven.next = list.next;
                listEven = listEven.next;
            }
            list = list.next;
        }

        listOdd.next = listEvenMarker;
        listEven.next = null;

        return head;
    }
}
