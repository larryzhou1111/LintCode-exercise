/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 17-06-06 07:54
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        
        //二叉查找树，即二叉排序树
        /*
          非空时满足：
            1.左子树上的所有节点值均小于根节点值
            2.右子树上的所有节点值均大于根节点值
            3.左右子树也分别为二叉排序树
        */
        
        /* 二叉查找树的插入过程如下：
           1.若当前的二叉查找树为空，则插入的元素为根节点
           2.若插入的元素值小于根节点值，则将元素插入到左子树中
           3.若插入的元素值不小于根节点值，则将元素插入到右子树中
        */
        if(root == null){
            
            root = node;
            return root;
        }
        
        //先保存根节点
        TreeNode head = root;
        
        while(root != null){
            
            //进入左子树判断
            if(node.val < root.val){
                
                if(root.left == null){
                    //根节点的左子节点非空，即插入当前节点为左子节点
                    root.left = node;
                    return head;
                }
                //继续判断左子树，寻找合适位置
                root = root.left;
            }
            
            //进入右子树判断
            else{
                
                if(root.right == null){
                    //根节点的右子节点非空，即插入当前节点为右子节点
                    root.right = node;
                    return head;
                }
                //继续判断右子树，寻找合适位置
                root = root.right;
            }
        }
        return root;
    }
}