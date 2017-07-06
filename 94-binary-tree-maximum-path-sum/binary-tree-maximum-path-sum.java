/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/binary-tree-maximum-path-sum/
@Language: Java
@Datetime: 17-7-6 23:00
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
     
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        // write your code here
        
        /* 二叉树中的最大路径和
           给出一棵二叉树，寻找一条路径使其路径和最大，
           路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
           
           给出一棵二叉树：  返回 6
               1
              / \
             2   3
        */
        
        //方法1：
        
        if(root == null)
            return 0;

        subMaxPathSum(root);
        
        return max;
    }
    
    
    public int subMaxPathSum(TreeNode node){
        
        if(node == null)
            return 0;
            
        int leftMax = subMaxPathSum(node.left);
        int rightMax = subMaxPathSum(node.right);
        
        int singlePath = Math.max(leftMax + node.val, rightMax + node.val);
        int subPath = Math.max(singlePath, node.val);
        
        int subMax = Math.max(subPath, leftMax + rightMax + node.val);
                    
        if(max < subMax){
            max = subMax;
        }
        
        return subPath;
    }
        
}