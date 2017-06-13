/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 17-06-12 12:13
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n){
        // write your code here
        
        //需回顾！
        
        //方法1：递归法
        //当递归到链表尾部时返回，每次返回时长度加1，一旦长度为n时记录下该节点
        if(head == null || n < 0) {
            return null;
        }
        
        int count = 0;
        ListNode node = head;
        
        while(node != null && count < n){
            
            node = node.next;
            count++;
        }
        while (node != null) {
            
            node = node.next;
            head = head.next;
        }
        return head;
    
 
        //方法2：用两个指针，快指针先走N步，然后快慢指针同时开始走，保持N的距离
        //       这样当快指针到达末尾时，慢指针就是倒数第N个
        /*
        ListNode slow = head;
        ListNode fast = head;
        
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        */
    }
}
