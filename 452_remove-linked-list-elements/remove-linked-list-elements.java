/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-linked-list-elements
@Language: Java
@Datetime: 17-05-31 14:27
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
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head==null) 
            return head;  
            
        ListNode p=head,q=head.next; 
        
        while(q!=null){  
            
            if(q.val==val){ 
                //跳过该给定值节点，即删除了该节点
                p.next=q.next;  
                q=q.next;  
            }
            //没有遇到给定值节点，p、q同时向后移动一位
            else {  
                p=p.next;  
                q=q.next;  
            }  
        }  
        if(head.val==val)  
            head=head.next;  
        return head;
    }
}