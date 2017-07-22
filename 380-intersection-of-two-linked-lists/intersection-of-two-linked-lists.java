/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/intersection-of-two-linked-lists/
@Language: Java
@Datetime: 17-07-22 16:00
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        
        /* 两个链表的交叉: 请写一个程序，找到两个单链表最开始的交叉节点
            ( 剑指offer题37 )
                    
            注意事项:
            如果两个链表没有交叉，返回null。
            在返回结果后，两个链表仍须保持原有的结构
            可假定整个链表结构中没有循环

            样例:下列两个链表：
            A:          a1 → a2
                               ↘
                                 c1 → c2 → c3
                               ↗            
            B:     b1 → b2 → b3
            在节点 c1 开始交叉
        */
        //方法1：顺序遍历链表1和2的每个节点，并比较。时间复杂度O(mn)，略
        
        //方法2：两个辅助栈，依次把链表1和2所有节点压入辅助栈中，然后比较栈顶元素
        //实际就是从链表末尾开始比较，往前查找。时间复杂度O(m+n)，用空间消耗换取时间效率
        
        
        //方法3：不用辅助栈，时间复杂度O(m+n)
        /* 
          思路：
            先分别遍历两个链表，得到其长度m和n
            长链表先走(m - n)步，然后两个链表同时出发遍历，直到找到相同的节点
        */
        
        //注意头结点就是交叉点
        if(headA == headB)
            return headA;
        
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        
        ListNode longHead = null;
        ListNode shortHead = null;
        
        int offset = 0;
        
        if(lenA > lenB){
            
            longHead = headA;
            shortHead = headB;
            offset = lenA - lenB;
        }
        
        if(lenB > lenA){
            
            longHead = headB;
            shortHead = headA;
            offset = lenB - lenA;
        }
        
        for(int i = 0; i < offset; i++){
            
            longHead = longHead.next;
        }
        
        while(longHead != null && shortHead != null && longHead != shortHead){
            
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        
        return longHead;
        
    }  
    
    public int getListLength(ListNode head){
        
        int len = 0;
        
        if(head == null)
            return len;
            
        ListNode node = head;
        
        while(node != null){
            
            node = node.next;
            len++;
        }
        
        return len;
    }
    
}