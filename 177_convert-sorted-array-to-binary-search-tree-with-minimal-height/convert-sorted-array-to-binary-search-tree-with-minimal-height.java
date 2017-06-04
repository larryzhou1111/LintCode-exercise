/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height
@Language: Java
@Datetime: 17-06-04 14:15
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
     * @param A: an integer array
     * @return: a tree node
     */

    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
    
        if(A == null)
            return null;
            
        return buildTree(A, 0, A.length - 1);
    } 
    
    
    public TreeNode buildTree(int[] A, int start, int end){
        
        if(start > end)
            return null;
        
        //根节点在有序数组的中间位置    
        TreeNode node = new TreeNode(A[(start + end) / 2]);
        
        //递归，建立左右子节点
        //左子节点在左半段的中间位置，右子节点在右半段中间位置
        node.left = buildTree(A, start, (start + end) / 2 - 1);
        node.right = buildTree(A, (start + end) / 2 + 1, end);
        
        return node; 
    }
}
