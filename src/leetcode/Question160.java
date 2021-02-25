package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode listA = headA;
        ListNode listB = headB;

        while(listA != listB){
            listA = listA == null ? headB : listA.next;
            listB = listB == null ? headA : listB.next;
        }

        return listA;
    }
}
