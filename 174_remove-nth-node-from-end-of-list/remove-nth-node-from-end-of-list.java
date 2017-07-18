/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 17-06-12 12:12
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        /*  删除链表中倒数第n个节点
            给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
            
            注意事项:链表中的节点个数大于等于n
            
            样例
            给出链表1->2->3->4->5->null和 n = 2.
            删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
        */
        
        //类比题166
		
        /*  
            用两个指针，快指针先走n-1步，
            然后快慢指针同时开始走，保持n-1的距离
            这样当快指针到达末尾时，慢指针就是倒数第n个
            然后删除即可
        */
        
        if(head == null || n <= 0)
            return null;
        
        //新建一个链表
        ListNode dummy = new ListNode(0);
        
        //保存头节点
        dummy.next = head;
        
        //准备删除元素的前驱
        ListNode preDelete = dummy;
        
        //遍历链表，head先走n-1步
        for(int i = 0; i < n - 1; i++) {
            
            //考虑链表长度小于n，题目已说明节点个数大于大于n，因此可省略
            /*
            if(head == null)
                return null;
            */
            head = head.next;
        }
        
        while(head.next != null){
            
            head = head.next;
            preDelete = preDelete.next;
        }
        
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}