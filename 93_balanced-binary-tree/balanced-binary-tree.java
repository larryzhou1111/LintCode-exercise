/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 17-06-03 13:57
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    
    //方法2中定义 
    private boolean isBalanced=true;
     
    public boolean isBalanced(TreeNode root) {
        // write your code here
        
        /* 平衡二叉树：给定一个二叉树,确定它是高度平衡的.（剑指offer题39-2）
        
            对于这个问题,一棵高度平衡的二叉树的定义是：
            一棵二叉树中每个节点的两个子树的深度相差不会超过1
        
            样例
            给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
            
            A)  3            B)    3 
               / \                  \
              9  20                 20
                /  \                / \
               15   7              15  7
               
            二叉树A是高度平衡的二叉树，但是B不是
        */

        //方法1：
        /*
        //将返回值进行判断
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        
        if(root == null ) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left-right) > 1 ) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
        */
        
        
        //方法2：
        /*
           后序遍历时，遍历到一个节点，其左右子树已经遍历
           依次自底向上判断，则每个节点只需要遍历一次
        */
        getDepth(root);
        return isBalanced;
    }
    
    public int getDepth(TreeNode root){
        
        if(root == null)
            return 0;
            
        int left = getDepth(root.left);
        int right = getDepth(root.right);
 
        if(Math.abs(left - right) > 1){
            
            isBalanced = false;
        }
        
        return right > left ? right + 1 : left + 1;
    }
}