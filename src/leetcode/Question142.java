package leetcode;

public class Question142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        do{
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);

        fast = head;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}

