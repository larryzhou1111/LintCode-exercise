/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/merge-two-sorted-lists/
@Language: Java
@Datetime: 17-06-22 20:54
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        
        //类比题6、64 合并数组系列
        
        //方法1：
        /*
        //用两个头结点l1和l2遍历两个链表，比较结点值的大小，小的那个进入新的链表
        //新链表定义一个头结点，指向的结点放入值以后，挪动到下一个结点
        //要额外考虑刚开始链表就为空，和遍历中有一个链表提前到达空的情况
        if(l1 == null)
            return l2;
            
        if(l2 == null)
            return l1;
        
        //新建一个空链表
        ListNode head = new ListNode(0);
        ListNode firstNode = head;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                
                firstNode.next = l1;
                l1 = l1.next;
            }
            else{
                
                firstNode.next = l2;
                l2 = l2.next;
            }
            
            //节点往后顺移
            firstNode = firstNode.next;
        }
        
        //两个链表长度不一致时，超出的部分，直接归并，拼接在最后即可
        if(l1 != null){
            
            firstNode.next = l1;
        }
        else{
            
            firstNode.next = l2;
        }
        
        return head.next;
        */
        
        //方法2：递归实现
        if(l1 == null)
            return l2;
            
        if(l2 == null)
            return l1;
        
        if(l1.val < l2.val){
            
            //确定了新链表的第一个元素是l1,然后递归合并 l1 之后的元素
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            
            //同理
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
        
    }
}