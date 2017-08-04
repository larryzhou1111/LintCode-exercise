/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-list-ii/
@Language: Java
@Datetime: 17-08-4 21:24
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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        
        //剑指offer题57
        
        /*  删除排序链表中的重复数字 II
            给定一个排序链表，删除所有重复的元素，只留下原链表中没有重复的元素
            
            样例：
                给出 1->2->3->3->4->4->5->null，返回 1->2->5->null
                给出 1->1->1->2->3->null，返回 2->3->null
        */
        
        if(head == null)
            return null;
        
        //临时的头结点
        ListNode root = new ListNode(0);
        
        //root指向head
        root.next = head;
        
        //记录前驱结点
        ListNode pre = root;
        
        //记录当前处理的结点
        ListNode cur = head;
        
        while(cur != null && cur.next != null){
            
            //有重复结点，与cur值相同的结点都要删除
            if(cur.val == cur.next.val){
                
                //找到下一个不同值的节点，注意其有可能也是重复节点
                while(cur.next != null && cur.next.val == cur.val){
                    
                    cur = cur.next;
                }
                
                //指向下一个节点，pre.next也可能是重复结点，所以pre不要移动到下一个结点
                pre.next = cur.next;
            }
            
            //相邻两个值不同，说明cur不可删除，要保留
            else{
                
                //pre指向cur节点
                pre.next = cur;
                
                //pre右移一位，循环遍历
                pre = pre.next;
            }
            
            //cur右移一位，循环遍历
            cur = cur.next;
        }
        
        return root.next;        
    }
}