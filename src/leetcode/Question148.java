package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 */
public class Question148 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        return mergeSortList(head, null);
    }

    public static ListNode mergeSortList(ListNode head, ListNode tail){
        if(head == null) return null;

        //head.next == tail意味着两个指针中间只有一个节点，return head
        if(head.next == tail){
            head.next = null;
            return head;
        }

        //使用快慢指针找到中间节点
        ListNode fast = head, slow = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) {
                fast = fast.next;
            }
        }

        ListNode midNode = slow;
        //list1代表"前1/2链表"，分治思想
        ListNode list1 = mergeSortList(head, midNode);
        //list2代表"后1/2链表"，注意使用tail传入而不是null（中间List的tail不是null）
        ListNode list2 = mergeSortList(midNode, tail);
        //进行merge并返回
        return merge(list1, list2);
    }

    /**
     * 将list1和list2按升序进行merge合并
     * @param node1 startNode of list1
     * @param node2 startNode of list2
     * @return a new LinkedList with sorted list
     */
    private static ListNode merge(ListNode node1, ListNode node2) {
        //创建一个临时head用来存放新的sorted list
        ListNode tempHead = new ListNode(0);
        ListNode temp1 = node1, temp2 = node2, temp = tempHead;

        //遍历list1,list2，每次取其中一个值进行比较&归并
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        //查看是否还有剩余的list，直接合并
        if(temp1 != null){
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }

        return tempHead.next;
    }

    //Practice//
    private static ListNode mergeSortListPractice(ListNode head, ListNode tail){
        if(head == null) return null;

        if(head.next == tail){
            head.next = null;
            return head;
        }

        ListNode fast = head, slow = head;
        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }

        ListNode midNode = slow;
        ListNode list1 = mergeSortListPractice(head, midNode);
        ListNode list2 = mergeSortListPractice(midNode, tail);
        return mergePractice(list1, list2);

    }

    private static ListNode mergePractice(ListNode list1, ListNode list2){
        ListNode tempHead = new ListNode(0);
        ListNode temp1 = list1, temp2 = list2, temp = tempHead;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if(temp1 != null){
            temp.next = temp1;
        }else if (temp2 != null){
            temp.next = temp2;
        }

        return tempHead.next;

    }

}
