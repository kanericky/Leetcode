package leetcode;

import tools.ListNode;

/**
 * @author kanericky
 * @version 1.0
 * 两数相加，链表、递归
 */

public class Question002 {

    //无需创建类实例
    private Question002(){}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //currentSum记录当前位的和，currentFlag记录当前的进位
        int currentSum, currentFlag = 0;
        //ListNode result 记录答案，res作为返回指针
        ListNode result = new ListNode(0), res = result;

        //实现位对齐
        while(l1 != null && l2 != null){
            currentSum = l1.val + l2.val + currentFlag;
            currentFlag = currentSum / 10;
            result.next = new ListNode(currentSum % 10);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        //处理多余位
        while(l1 != null){
            currentSum = l1.val + currentFlag;
            currentFlag = currentSum / 10;
            result.next = new ListNode(currentSum % 10);
            result = result.next;
            l1 = l1.next;
        }

        while(l2 != null){
            currentSum = l2.val + currentFlag;
            currentFlag = currentSum / 10;
            result.next = new ListNode(currentSum % 10);
            result = result.next;
            l2 = l2.next;
        }

        //如果处理完所有位后仍有进位，则进位
        if(currentFlag != 0){
            result.next = new ListNode(currentFlag);
        }

        //return的是res的next，res是一个临时节点
        return res.next;
    }
}
