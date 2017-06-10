/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/minimum-depth-of-binary-tree
@Language: Java
@Datetime: 17-06-10 15:16
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
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null) 
            return 1;
        
        //递归左右子树,要考虑所有节点都只有左，或者右子树
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        if(root.left == null)
            return rightDepth + 1;
            
        else if(root.right == null)
            return leftDepth + 1;
            
        else
            return Math.min(leftDepth,rightDepth) + 1;        
    }
}