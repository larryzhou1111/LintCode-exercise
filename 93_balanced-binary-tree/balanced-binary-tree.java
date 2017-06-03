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
    public boolean isBalanced(TreeNode root) {
        // write your code here
        
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
        
    }
}