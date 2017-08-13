/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 17-08-13 22:00
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
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        
        /*  链表求和 II 
            假定用一个链表表示两个数，其中每个节点仅包含一个数字
            假设这两个数的数字顺序排列，请设计一种方法将两个数相加
            并将其结果表现为链表的形式
            
            样例:
                给出 6->1->7 + 2->9->5。即，617 + 295
                返回 9->1->2。即，912 
        */
        if(l1 == null)
            return l2;  
  
        if(l2 == null) 
            return l1;  
        
        //将两个链表分别转换为字符串，再进行计算 
        String s1 = "";  
        String s2 = "";  
        
        while(l1 != null){  
            
            s1 = s1 + Integer.toString(l1.val);  
            l1 = l1.next;  
        }  
        
        while(l2 != null){  
            
            s2 = s2 + Integer.toString(l2.val);  
            l2 = l2.next;  
        } 
        
        int length1 = s1.length() - 1;  
        int length2 = s2.length() - 1; 
        
        int flag = 0;  
        
        ListNode head = new ListNode(-1);  
        ListNode tmp = head;  
        
        //两个链表长度公共的部分
        while(length1 >= 0 && length2 >= 0){  
            
            int t = s1.charAt(length1)-'0' + s2.charAt(length2) -'0' + flag; 
            
            flag = t / 10;  
            t = t % 10;  
            
            ListNode newNode = new ListNode(t);  
            newNode.next = head.next;  
            head.next = newNode;  
            
            length1 --;  
            length2 --;  
        }  
        
        //链表1更长的部分
        while(length1 >= 0){  
            
            int t = s1.charAt(length1) -'0' + flag;  
            
            flag = t / 10;  
            t = t % 10; 
            
            ListNode newNode = new ListNode(t);  
            newNode.next = head.next;  
            head.next = newNode;  
            
            length1 --;  
        }  
        
        while(length2 >= 0){  
            
            int t = s2.charAt(length2) -'0' + flag;  
            
            flag = t / 10;  
            t = t % 10;
            
            ListNode newNode = new ListNode(t);  
            newNode.next = head.next;  
            head.next = newNode; 
            
            length2 --;  
        }  
        
        //考虑最左边的进位
        if(flag == 1){  
            
            ListNode newNode = new ListNode(1);  
            newNode.next = head.next;  
            head.next = newNode;  
        }  
        
        return head.next;          
    }  
}