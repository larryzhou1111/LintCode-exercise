/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/linked-list-cycle/
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        
        /*  带环链表: 给定一个链表，判断它是否有环
            样例:给出 -21->10->4->5, tail connects to node index 1，返回 true
        */
        
        //类比题166、372，剑指offer题15，快慢指针法
        
        /*  思路：
            
            定义两个指针，同时从链表的头结点出发，慢指针一次走一步，快指针一次走两步
            如果走得快的指针追上了慢指针，说明链表是环形链表
            如果走得快的指针走到了链表的末尾，还没有追上慢指针，说明链表不是环形链表
        */
        if(head == null || head.next == null) 
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        } 
		
        /* 上述while循环部分可改为：
		
		   跳出while循环的条件有三个：
            (1) fast指针走到尾节点，返回false
            (2) 执行完 fast = fast.next.next;后，fast指针为null，返回false
            (3) slow == fast，快慢指针相遇，返回true
        */
        /*
        while(fast != null){
        
            if(fast.next == null)
                return false;
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        } 
		*/
		
        return false;
		
		
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