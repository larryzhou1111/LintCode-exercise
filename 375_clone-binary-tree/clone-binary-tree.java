/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/clone-binary-tree
@Language: Java
@Datetime: 17-06-04 13:54
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
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        
        if(root == null)
            return null;
            
        else{  
            
            TreeNode new_root = new TreeNode(root.val);
            
            //递归添加左右节点
            if(root.left != null){
               new_root.left = cloneTree(root.left); 
            }
            
            if(root.right != null){
               new_root.right = cloneTree(root.right); 
            }
            
            return new_root;
        }
    }
}