/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 17-06-12 12:12
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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        //需回顾！
        //类比题166
        
        if(n <= 0) {
            return null;
        }
        
        //新建一个链表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //准备删除元素的前驱
        ListNode preDelete = dummy;
        
        //遍历链表
        for(int i = 0; i < n; i++) {
            
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        while(head != null){
            
            head = head.next;
            preDelete = preDelete.next;
        }
        
        preDelete.next = preDelete.next.next;
        return dummy.next;

    }
}
