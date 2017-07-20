/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/rotate-list/
@Language: Java
@Datetime: 17-07-20 19:00
*/

/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        
        /*  旋转链表
            给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
            
            样例
            给出链表1->2->3->4->5->null 和 k=2
            返回4->5->1->2->3->null
        */
        
        /* 思路：
           把链表头尾连接起来，构成一个环，然后遍历找到该断的地方，将链表断开
           
           需要注意：旋转的结点数可能超过链表长度，所以要对这个进行取余
           
           定位旋转的尾结点，不超过链表的长度，则时间复杂度是O(n)，空间复杂度是O(1)
           
           上面的实现中采取的方式是直接走到那个结点，如果没超过长度就直接旋转了，
           如果超过了，就进行取余，并且重新跑到结尾点
           
           也可以先直接求长度，然后取余之后再走
        */
        if(head == null || k == 0)
            return head;
            
        ListNode p = head;
        int len = 1;
        
        while(p.next != null){
            
            len++;
            p = p.next;
        }
        
        //将链表首尾相连
        p.next = head;
        
        //旋转的结点数可能超过链表长度，所以要对其进行取余
        k = k % len;
        
        //遍历链表，到要断开的位置
        for(int i = 0; i < len - k; i++){
            
            p = p.next;
        }
        
        //断开
        head = p.next;
        p.next = null;
        
        return head;
    }
}