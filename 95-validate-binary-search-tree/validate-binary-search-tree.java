/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/validate-binary-search-tree/
@Language: Java
@Datetime: 17-07-19 16:00
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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        
        /* 验证二叉查找树: 给定一个二叉树，判断它是否是合法的二叉查找树(BST)

        一棵BST定义为：
        
        节点的左子树中的值，要严格小于该节点的值
        节点的右子树中的值，要严格大于该节点的值
        左右子树也必须是二叉查找树
        一个节点的树也是二叉查找树
        
        样例
          2
         / \
        1   4
           / \
          3   5    上述这棵二叉树序列化为 {2,1,4,#,#,3,5}.
          
        */
        
        //方法：分治
        
        return Judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean Judge(TreeNode root, long min, long max){
        
        if(root == null)
            return true;
        
        if(root.val <= min || root.val >= max)
            return false;
        
        //修改最大最小值，为当前根节点的值。递归判断左右子树
        return Judge(root.left, min, Math.min(max, root.val)) && 
               Judge(root.right, Math.max(min, root.val), max);

    }
}