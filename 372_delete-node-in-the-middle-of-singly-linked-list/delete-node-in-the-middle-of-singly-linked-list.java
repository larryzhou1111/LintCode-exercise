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
        
        if(node.next != null){
            
            //删除节点值，用其后继节点值替代
            node.val = node.next.val;
            //链表依次往左推进一位
            node.next = node.next.next;
            //删除等待被删除的节点(非表头或表尾)
            node = null;
        }
    }
}