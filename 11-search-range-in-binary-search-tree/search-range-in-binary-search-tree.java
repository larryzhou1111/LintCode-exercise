/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-range-in-binary-search-tree/
@Language: Java
@Datetime: 17-07-16 22:00
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
     
    public ArrayList<Integer> searchList = new ArrayList<>();  
     
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        
        /* 二叉查找树中搜索区间
        
           给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点
           找到树中所有值在 k1 到 k2 范围内的节点
           即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值
           返回所有升序的节点值
           
           样例:
           如果有 k1 = 10 和 k2 = 22, 你的程序应该返回 [12, 20, 22]
                20
               /  \
              8   22
             / \
            4   12
        */
        
        /* 思路：
        
           二叉排序树（Binary Sort Tree）= 二叉查找树（Binary Search Tree）= 二叉搜索树
           
           二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
          （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
          （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
          （3）左、右子树也分别为二叉排序树；
        
           用递归实现，root满足条件时，将root加入List中，再递归其左右子树，
           若root < k1，则只有在root的右子树中，才存在满足条件的节点，
           若root > k2，则只有在root的左子树中，才存在满足条件的节点
        */
        
        if(root == null)
            return searchList;  
            
        if(root.val >= k1 && root.val <= k2){ 
            
            //添加到结果集中
            searchList.add(root.val);  
            //递归
            searchRange(root.left, k1, k2);  
            searchRange(root.right, k1, k2);  
        }
        else if(root.val < k1){ 
            
            searchRange(root.right, k1, k2);  
        }
        else if(root.val > k2){ 
            
            searchRange(root.left, k1, k2);  
        }  
        
        Collections.sort(searchList);  
        
        return searchList;
    }
}