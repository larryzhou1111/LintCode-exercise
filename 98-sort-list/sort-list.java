/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/sort-list/
@Language: Java
@Datetime: 17-7-9 22:00
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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        
        /* 链表排序
           在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序
           
           给出 1->3->2->null，给它排序变成 1->2->3->null
        */
        
        //快排
        if(head == null || head.next == null) 
            return head;
            
        ListNode pivot = head;
        head = head.next;
        
        pivot.next = null;
        ListNode p = pivot;

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        
        ListNode s = small;
        ListNode l = large;

        while(head != null){
            
            if(head.val > pivot.val){
                
                l.next = head;
                l = l.next;
            }
            
            else if(head.val == pivot.val){
                
                p.next = head;
                p = p.next;
            }
            
            else{
                
                s.next = head;
                s = s.next;
            }
            
            head = head.next;
        }
        
        s.next = null;
        l.next = null;
        
        ListNode ss = sortList(small.next);
        
        if(ss == null){
            
            ss = pivot;
        }
        else{
            
            ListNode tmp = ss;
            
            while(tmp.next != null){
                
                tmp = tmp.next;
            }
            
            tmp.next = pivot;
        }
        
        ListNode tail = sortList(large.next);
        p.next = tail;
        
        return ss;        
        
    }
}
