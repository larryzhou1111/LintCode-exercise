/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/reverse-linked-list-ii/
@Language: Java
@Datetime: 17-06-28 20:00
*/

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        
		//剑指offer题16
		
        //翻转链表中,第m个节点到第n个节点的部分。需回顾！！
        /*
            样例:
            给出链表1->2->3->4->5->null， m = 2和n = 4，返回1->4->3->2->5->null
        */
        
        if(head == null || m >= n)
            return head;
        
        //在头结点之前引入一个结点，因为头结点可能被翻转，可使头结点的翻转和普通结点一样  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        //找到旋转链表的第一个节点
        for(int i = 1; i < m; i++){
            
            if(head == null)
                return null;
                
            //因为已在头结点之前引入了一个结点，所以这里的head指向m的前一个结点
            head = head.next;
            
        }
        
        //第m个节点的前一个节点
        ListNode premNode = head;
        
        //第m个节点
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        
        //第n个节点的后一个节点
        ListNode postnNode = mNode.next;
        
        for(int i = m; i < n; i++){
            
            if(postnNode == null)
                return null;
                
            //旋转
            ListNode tmp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = tmp;
            
        }
        
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
        
    }
}