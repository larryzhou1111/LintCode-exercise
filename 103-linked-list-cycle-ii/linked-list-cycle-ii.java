/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/linked-list-cycle-ii/
@Language: Java
@Datetime: 17-07-18 20:00
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        
        /*  带环链表II: 
            给定一个链表，如果链表中存在环，则返回到链表中环的起始节点的值
            ，如果没有环，返回null
            
            样例:
            给出 -21->10->4->5, tail connects to node index 1，返回10
        */
        
        //类比题102、166、372，剑指offer题15，快慢指针法
        
        /*  思路：
            
            定义两个指针，同时从链表的头结点出发，慢指针一次走一步，快指针一次走两步
            如果走得快的指针追上了慢指针，说明链表是环形链表
            如果走得快的指针走到了链表的末尾，还没有追上慢指针，说明链表不是环形链表
            
            快慢指针相遇后，调整fast=head，slow不变
            同时速度保持一致，继续移动；再次相遇的地方，就是环开始的地方
        */
        if(head == null || head.next == null) 
            return null;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
        
            if(fast.next == null)
                return null;
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;
        } 
        
        /* 跳出while循环的条件有三个：
            (1) fast指针走到尾节点
            (2) 执行完 fast = fast.next.next;后，fast指针为null
            (3) slow == fast，快慢指针相遇
        */
        
        //上述条件2
        if(fast == null)
            return null;
        
        fast = head;
        
        while(fast != slow){
            
            slow = slow.next;
            fast = fast.next;
        }  
        
        return fast;
		
		
		/*类似题：求链表的中间节点。（题99中有涉及）
				  如果链表节点总数为奇数，返回中间节点；为偶数，返回两个中间节点的任意一个
			
			思路：快慢指针法
			定义两个指针，同时从链表的头结点出发，慢指针一次走一步，快指针一次走两步
            如果快指针走到了链表的末尾，此时慢指针正好在链表的中间
		*/
		/*
		public ListNode findMiddle(ListNode head) {
        
			ListNode slow = head, fast = head.next;
			
			while(fast != null && fast.next != null){
				
				fast = fast.next.next;
				slow = slow.next;
			}
			
			return slow;
		}
		*/		
    }
}