/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/invert-binary-tree
@Language: Java
@Datetime: 17-06-08 15:27
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
		
		//剑指offer题19
        
        /* 翻转二叉树
        
            样例
              1         1
             / \       / \
            2   3  => 3   2
               /       \
              4         4
        */
        
        //对每一个结点，将它的左右子树进行交换，再对它的左右子结点进行同样的操作
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            return;
            
        invert(root);
    }
    
    public TreeNode invert(TreeNode root){
        
        if(root != null){
            
            //交换左右子节点
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            
            //递归左右子节点
            if(root.left != null){
                
                invertBinaryTree(root.left);
            }
            
            if(root.right != null){
                
                invertBinaryTree(root.right);
            }

        }
        
        return root;
    }
}