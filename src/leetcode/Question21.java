package leetcode;

import tools.ListNode;

/**
 *
 * 21. 合并两个有序链表
 * 难度 简单
 *
 * AUTHOR RUIQI ZHANG
 * DATE 29/10/2020
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */

public class Question21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l10 = new ListNode(7);
        ListNode l11 = new ListNode(7);
        l1.next = l10;
        l10.next =l11;

        ListNode l2 = new ListNode(5);
        ListNode l20 = new ListNode(6);
        ListNode l21 = new ListNode(6);
        l2.next = l20;
        l20.next = l21;

        ListNode newList = mergeTwoLists(l1, l2);
        printList(newList);
    }

    public static void printList(ListNode newList){
        System.out.println("List:");
        while(newList != null){
            System.out.print(newList.val + " " );
            newList = newList.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode startNode = new ListNode(), tempNode = startNode;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            }else{
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = l1 != null ? l1 : l2;
        return startNode.next;
    }


    public static ListNode mergeTwoListsOutdated(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode startNode = null;
        if(l1.val <= l2.val){
            startNode = l1;
            while(l2 != null){
                if(l1.next == null) break;

                int check1 = l1.val;
                int check2 = l1.next.val;

                if(l2.val >= check1 && l2.val < check2){
                    ListNode bufferedNode = l1.next;
                    l1.next = new ListNode(l2.val);
                    l1.next.next = bufferedNode;
                    l1 = l1.next;
                    l2 = l2.next;
                }else{
                    l1 = l1.next;
                }
            }

            if(l2 != null){
                l1.next = l2;
            }
        }

        else if(l1.val > l2.val){
            startNode = l2;
            while(l1 != null){
                if(l2.next == null) break;

                int check1 = l2.val;
                int check2 = l2.next.val;

                if(l1.val >= check1 && l1.val < check2){
                    ListNode bufferedNode = l2.next;
                    l2.next = new ListNode(l1.val);
                    l2.next.next = bufferedNode;
                    l2 = l2.next;
                    l1 = l1.next;
                }else{
                    l2 = l2.next;
                }
            }

            if(l1 != null){
                l2.next = l1;
            }
        }

        // 1->2->4, 1->3->4 */

        return startNode;
    }
}
