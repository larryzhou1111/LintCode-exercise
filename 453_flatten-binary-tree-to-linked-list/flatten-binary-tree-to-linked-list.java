/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-06-06 12:18
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
    /*
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
    */    
    
    //写法2：
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
        TreeNode lefts = preorderTraversal(root.left);
        TreeNode rights = preorderTraversal(root.right);

        if(lefts != null){
            
            //前序遍历：根-左-右
            
            //根节点的左子节点，其后继节点为，根节点的右子节点
            lefts.right = root.right;
            //根节点，其后继节点为，根节点的左子节点，相当于遍历往后推进！
            root.right = root.left;
        }
        
        //根节点的左子节点，已赋值给根节点的右子节点，故清除掉
        root.left = null;
        
        if(rights != null)
            return rights;
            
        else if(lefts != null)
            return lefts;
            
        else
            return root;
    
    }
}