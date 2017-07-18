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
        
        //方法1：递归法，实际遍历了链表两次，效率低
        /*
        //当递归到链表尾部时返回，每次返回时长度加1，一旦长度为n时记录下该节点
        if(head == null || n <= 0) 
            return null;
        
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
        */
 
        //方法2：
        /*  
            用两个指针，快指针先走n-1步，
            然后快慢指针同时开始走，保持n-1的距离
            这样当快指针到达末尾时，慢指针就是倒数第n个
        */
        if(head == null || n <= 0) 
            return null;
        
        ListNode slow = null;
        ListNode fast = head;
        
        //快指针先走n-1步
        for(int i = 0; i < n - 1; i++){
            
            if(fast.next != null){
                
                fast = fast.next;
            }
            
            //考虑链表实际长度，小于n的情况
            else
                return null;
                
        }  
  
        slow = head;
        
        while(fast.next != null){
            
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}

