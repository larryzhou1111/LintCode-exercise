/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/convert-binary-search-tree-to-doubly-linked-list/
@Language: Java
@Datetime: 17-07-20 19:00
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        
        /* 将二叉查找树转换成双链表: 
        
            将一个二叉查找树按照中序遍历转换成双向链表
          （排序的双向链表，要求不创建任何新的节点，只能调整树中节点指针的方向）
            
            样例:
            给定一个二叉查找树：
                4
               / \
              2   5
             / \
            1   3
            返回 1 <-> 2 <-> 3 <-> 4 <-> 5
        */
        
        //剑指offer题27
        
        /* 思路：
        
            把左、右子树都转换成排序的双向链表之后，再和根节点链接起来
            则整颗二叉搜索树就全部转换成了排序的双向链表
        
        */
        
        if(root == null)
            return null;
            
        DoublyListNode result = Convert(root);
        
        while(result.prev != null){
            
            result = result.prev;
        }
        
        return result;
    }
    
    public DoublyListNode Convert(TreeNode root){
        
        if(root == null)
            return null;
        
        //保存当前根节点    
        DoublyListNode curRoot = new DoublyListNode(root.val);
        
        //中序遍历，左-根-右
        if(root.left != null){
            
            //递归左子节点，以生成左子树的双向链表
            DoublyListNode left = Convert(root.left);
            
            //遍历左子树生成的双向链表，找到最后一个节点
            while(left.next != null){
                
                left = left.next;
            }
            
            //左子树生成的双向链表的最后一个节点，链接到根节点，注意是双向链接
            curRoot.prev = left;
            left.next = curRoot;
        }
        
        if(root.right != null){
            
            DoublyListNode right = Convert(root.right);
            
            while(right.prev != null){
                
                right = right.prev;
            }
            
            //根节点，链接到右子树生成的双向链表的最后一个节点，注意是双向链接
            curRoot.next = right;
            right.prev = curRoot;
        }
        
        return curRoot;
    }
    
}