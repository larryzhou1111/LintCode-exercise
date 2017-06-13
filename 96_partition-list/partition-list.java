/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 17-06-13 12:36
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        
        //思路：新建两个链表，遍历当前链表，将其元素添加到这两个新链表中
        //分别保存所有小于x的节点，和所有大于等于x的节点，再拼接这两个新链表
        
        if(head == null || head.next == null)
            return head;        
        
        //新建两个长度为0的链表
        ListNode Small = new ListNode(0); 
        ListNode Large = new ListNode(0); 
        
        //分别定义其头结点
        ListNode small = Small;
        ListNode large = Large;
        
        //遍历当前链表
        while(head != null){  
            
            if(head.val < x){ 
                
                //添加到新链表1
                small.next = head;
                small = head;
            }
            
            else{  
                
                //添加到新链表2
                large.next = head;
                large = head;
            }
            head = head.next;
        }
        
        //拼接新链表1 和 新链表2
        large.next = null;
        small.next = Large.next;
        
        return Small.next;
    }
}
