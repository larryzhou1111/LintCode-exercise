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
        
        /*
          翻转链表，将链表从最后一个节点指向前面的节点。 
          遍历链表，先完成一个操作 1->2 变成 2->1 
          
          需要注意： 
          如果直接把2->的元素变为1，那原本2->的元素将丢失。 
          故需要先保存2->的节点再进行此操作。 
          另外还需要一个元素记录前一个节点，即是每循环一步生成的新链表的头部
        */
        if(head == null)
            return null;
            
        ListNode p = head;
        ListNode next = null;
        ListNode pre = null;
        
        while(p != null){
            
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}