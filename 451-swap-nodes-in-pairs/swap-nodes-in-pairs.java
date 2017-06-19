/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/swap-nodes-in-pairs/
@Language: Java
@Datetime: 17-06-19 19:54
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        
        //交换两个节点,而不是改变节点的权值
        if(head == null)
            return null;
            
        ListNode cur = head;
        ListNode prev = cur; 
        
        //连接每对节点
        if(cur.next != null){
            
            head = cur.next;
        }
            
        while(cur != null && cur.next != null){
            
            prev.next = cur.next;
            
            //next用来保存下一对节点的开始节点
            ListNode next = cur.next.next;  
            cur.next.next = cur;
            cur.next = next;  
            
            //prev指向每一对反转之后节点的第二个节点
            prev = cur;  
            //cur指向每一对节点的第一个节点
            cur = next;  
        }
        
        return head;
    }
}