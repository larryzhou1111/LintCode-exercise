/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/delete-node-in-the-middle-of-singly-linked-list
@Language: Java
@Datetime: 17-06-11 15:41
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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
		
		//剑指offer题13
        
        /* 在O(1)时间复杂度删除链表节点
        
            给定一个单链表中的一个等待被删除的节点(非表头或表尾)
            请在在O(1)时间复杂度删除该链表节点
            
            样例
            Linked list is 1->2->3->4, and given node 3, 
            delete the node in place 1->2->4
        */
        
        //思路：删除节点，不考虑链表的表头或表尾
        /*
            删除节点i，先将i的下一个节点j的内容复制到i
            然后将i的指针指向j的下一个节点
            此时删除节点j，其效果相当于删除了节点i
        */
        if(node == null || node.next == null)
            return;
            
        //删除节点值，用其后继节点值替代
        node.val = node.next.val;
        
        //链表依次往左推进一位
        node.next = node.next.next;
        
        //删除等待被删除的节点(非表头或表尾) (可释放，也可不释放)
        node = null;
        
        
        //补充：考虑表头或表尾
        /*
        
        //删除头节点
        if(node == head){
           
            head = null;
        } 
        //删除尾节点
        else{
            
            if(node.next == null){
                
                ListNode temp = head;
                
                //顺序遍历链表，找到倒数第二个节点
                while(temp.next.next != null){
                    
                    temp = temp.next;
                }
                
                //删除尾节点
                temp.next = null;
            }
        }
        */
    }
}