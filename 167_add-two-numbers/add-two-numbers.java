/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 17-06-01 11:06
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        
        /*  链表求和
            你有两个用链表代表的整数，其中每个节点包含一个数字
            数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头
            写出一个函数将两个整数相加，用链表形式返回和
            
            样例
                给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
        */
        if(l1 == null)  
            return l2; 
            
        if(l2 == null)  
            return l1;  
        
        //定义进位和临时变量    
        int c = 0;  
        int temp = 0; 
        
        ListNode head = new ListNode(0);  
        ListNode p = head;
        
        while(l1 != null && l2 != null){  
            
            temp = l1.val + l2.val + c;  
            
            c = temp / 10;  
            temp = temp % 10;  
            
            p.next = new ListNode(temp);  
            p = p.next;  
			
            l1 = l1.next;  
            l2 = l2.next;  
        }  
        
        while(l1 != null){  
            
            temp = l1.val + c;  
            
            c = temp / 10;  
            temp = temp % 10;  
            
            p.next = new ListNode(temp); 			
            p = p.next;  
			
            l1 = l1.next;  
        }  
        
        while(l2 != null){  
            
            temp = l2.val + c; 
            
            c = temp / 10;  
            temp = temp % 10;  
            
            p.next = new ListNode(temp);  			
            p = p.next; 
			
            l2 = l2.next;  
        }  
        
        if(c != 0){  
            
            p.next = new ListNode(c);  
        }  
        
        return head.next;  
    }
}