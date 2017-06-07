/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 17-06-06 12:16
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        
        if(head == null || head.next == null)
            return head;
        
        /*
            使用一个指针p指向未排好序的链表的第一个结点
            在排序好的部分中找到找第一个大于等于q的前驱结点
            将p对应的结点插入到正确位置，p重新指向未排好序的链表的第一个结点
            直到链表完成排序好。
        */
		
        //新建一个长度为0的链表,准备对其进行排序
        // 头结点        
        ListNode root = new ListNode(0); 
        
        root.next = head;
        ListNode p = head;
        ListNode q,r;

        while (p != null && p.next != null) {
            
            if (p.val <= p.next.val) {
                
                //若P已是最小，则后继，继续遍历
                p = p.next;
            }
            else {
                
                q = p.next;
                p.next = q.next;

                r = root;
                //找第一个大于等于q.val的前驱结点
                while (r.next.val <= q.val) {
                    r = r.next;
                }
                //交换 r与q
                q.next = r.next;
                r.next = q;
            }
        }

        return root.next; 
    }
}
