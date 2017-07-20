/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/copy-list-with-random-pointer/
@Language: Java
@Datetime: 17-07-20 19:00
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        /* 复制带随机指针的链表（剑指offer题26）
        
        给出一个链表，每个节点包含一个额外增加的随机指针，
        该随机指针可以指向链表中的任何节点或空的节点
        
        返回一个深拷贝的链表
        */
        if(head == null)
            return null;
            
        //第一步：根据原始链表的每个节点N，创建对应的N'，把N'链接在N的后面
        CloneNodes(head);
        
        //第二步：设置复制出来的节点的随机指针，N -> S ，N'-> S'
        ConnectSiblingNodes(head);
        
        //第三步：把上述长链表按奇偶拆分成两个链表，偶数位置的链表即为复制出来的链表
        return DivideLists(head);
        
    }
    
    private void CloneNodes(RandomListNode head) {
        
         while(head != null){
            
            //根据原始链表的每个节点N，创建对应的N'
            RandomListNode newNode = new RandomListNode(head.label);
            
            //把N'链接在N的后面
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            
            //往右遍历head，重复以上操作
            head = head.next.next;
        }
    }  
    
    private void ConnectSiblingNodes(RandomListNode head) {
        
        while(head != null){
            
            if(head.next.random != null){
                 
                //设置复制出来的节点的随机指针
                head.next.random = head.random.next;
            }
            
            head = head.next.next;
        }
    }  
    
    private RandomListNode DivideLists(RandomListNode head) {
        
        //偶数位置链表的头结点
        RandomListNode newHead = head.next;
        
        //把上述长链表按奇偶拆分成两个链表
        while(head != null){
            
            //遍历，得到奇数位置的链表
            RandomListNode temp = head.next;
            head.next = temp.next;
            
            //此处相当于在原始链表中移动了2步
            head = head.next;
            
            //偶数位置的链表即为复制出来的链表
            if(temp.next != null){
                
                 temp.next = temp.next.next;
            }
        }
        
        return newHead;
    }    
    
}