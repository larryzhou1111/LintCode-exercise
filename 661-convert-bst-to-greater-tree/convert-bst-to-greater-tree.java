/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/convert-bst-to-greater-tree/
@Language: Java
@Datetime: 17-06-25 11:30
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
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        
        /*
           给定二叉搜索树（BST），将其转换为较大的树
           使原始BST的每个键都更改为，原始键，加上BST中所有大于原始键的键的总和
           
           样例:
                Given a binary search Tree {5,2,3}:
                              5
                            /   \
                           2     13
                           
                Return the root of new tree
                             18
                            /   \
                          20     13
        */
        
        /*
        //方法1：采用类似中序遍历：右根左，即按节点值从大到小的顺序
        //类比题67：二叉树的中序遍历
                
        if(root == null)
            return null;
    
        inorderTraversal(root);
        return root;
    }    
    
    public int sum = 0; 
    
    public void inorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        //右-根-左 即按节点值从大到小的顺序,逐次递归遍历
        inorderTraversal(root.right);
        
        root.val = root.val + sum;
        sum = root.val;
        
        inorderTraversal(root.left);
        */
        
        //方法2：按照规律递归
        //根节点的值,等于右节点的值+自身的值，左节点的值,等于右节点+根节点+自身的值
        
        if(root == null)
            return null;
            
        int result = search(root, 0);
        return root;
        
    }
    
    public int search(TreeNode root, int count){
        
        if(root == null)
            return 0;
            
        int right = search(root.right, count);
        int left = search(root.left, count + root.val + right);
        
        int result = right + left + root.val;
        root.val += right + count;
        
        return result;
        
    }
}