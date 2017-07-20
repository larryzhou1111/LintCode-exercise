/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/palindrome-linked-list/
@Language: Java
@Datetime: 17-07-20 19:00
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        
        /* 回文链表
           设计一种方式检查一个链表是否为回文链表
           
           样例
           1->2->1 就是一个回文链表
        */
        
        /* 思路：
           先找到链表的中间节点，然后将后半部分反转，然后逐个比较即可
        */
        
        if(head == null)
            return true;
        
        ListNode middle = findMiddle(head);
        
        middle.next = reverse(middle.next);

        ListNode p1 = head;
        ListNode p2 = middle.next;
        
        while(p1 != null && p2 != null && p1.val == p2.val){
            
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    //快慢指针法，找链表的中间节点
    private ListNode findMiddle(ListNode head) {
        
        if(head == null) 
            return null;

        ListNode slow = head, fast = head.next;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private ListNode reverse(ListNode head) {
        
        ListNode prev = null;

        while(head != null){
            
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
    
}