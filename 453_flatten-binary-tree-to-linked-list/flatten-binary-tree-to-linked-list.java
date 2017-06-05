/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-06-05 12:30
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
    public void flatten(TreeNode root) {
        // write your code here
    
    //写法1：
        if(root != null)
        {
            TreeNode p = root;
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            if (left != null)
            {   
                //推进遍历
                p = root.left;
                
                while(p.right != null)
                {
                    p = p.right;
                }
                
                root.left = null;
                root.right = left;
                p.right = right;
            }
            //递归
            flatten(root.left);
            flatten(root.right);
        }
    
    //写法2：
    /*    
        if (root == null) {
            return;
        }
        
        preorderTraversal(root);
   } 
   
   
    public TreeNode preorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }

        //递归
        TreeNode left = preorderTraversal(root.left);
        TreeNode right = preorderTraversal(root.right);

        if(left != null){
            
            //前序遍历：根-左-右
            //根节点的右子节点，赋值给根节点的左子节点的右子节点
            left.right = root.right;
            //根节点的左子节点，赋值给根节点的右子节点，相当于遍历往后推进！
            root.right = root.left;
        }
        
        //根节点的左子节点，已赋值给根节点的右子节点，故清除掉
        root.left = null;
        
        if(right != null)
            return right;
            
        else if(left != null)
            return left;
            
        else
            return root;
    */
    }
}