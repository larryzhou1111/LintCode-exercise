/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 17-06-14 15:14
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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        
        if(head == null)
            return null;
            
        ListNode pre = head;
        ListNode cur = head.next;
        
        while(cur != null){
            
            if(cur.val == pre.val){
                
                //跳过当前cur ,即删除掉当前cur
                pre.next = cur.next;
            }
            else{
                
                //pre右移一位，循环遍历
                pre = cur;
            }
            //cur右移一位，循环遍历
            cur = cur.next;
        }
        return head;
    }  
}