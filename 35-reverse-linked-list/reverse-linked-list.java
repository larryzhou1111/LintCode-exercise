/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/reverse-linked-list/
@Language: Java
@Datetime: 17-06-17 14:54
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        
		//类似剑指offer题5、16
		
        /* 翻转链表
        
          样例:
          给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
        */

        //方法1：
        /*
          翻转链表，将链表从最后一个节点指向前面的节点。 
          遍历链表，先完成一个操作 1->2 变成 2->1 
          
          需要注意： 
          如果直接把2->的元素变为1，那原本2->的元素将丢失。 
          故需要先保存2->的节点再进行此操作。 
          另外还需要一个元素记录前一个节点，即是每循环一步生成的新链表的头部
        */  
        
        /*
        if(head == null || head.next == null)
            return head;
            
        ListNode pre = null;            
        ListNode cur = head;
        ListNode next = null;
        
        while(cur != null){
            
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
        */
        
        //方法2：递归实现
        if(head == null || head.next == null)
            return head;        
        
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return node; 
    }
}