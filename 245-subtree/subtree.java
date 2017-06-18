/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/subtree/
@Language: Java
@Datetime: 17-06-18 19:54
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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        
        /*
          1.在树 A 中找到和 B 的根结点的值一样的结点R
          2.再判断树 A 中,以 R 为根结点的子树,是不是包含和树 B 一样的结构
          3.递归判断
        */
        
        //空树，恒为子树
 		if(T2 == null){ 		
 			return true;
 		}
 		
 		return subTree(T1, T2);
 	}
 
 	public boolean subTree(TreeNode r1, TreeNode r2){
 	    
 		if(r1 == null){
 			return false; 
 		}
 		
 		if(r1.val == r2.val){
 		    
 		    //在树 A 中找到和 B 的根结点的值一样的结点
 			if(matchTree(r1, r2))
 			    return true;
 		}
 		
 		return (subTree(r1.left, r2) || subTree(r1.right, r2));
 	}
 
 	public boolean matchTree(TreeNode r1, TreeNode r2){ 		
 	    
 	    //判断树 A 中,以 r1 为根结点的子树,是不是包含和树 B 一样的结构
 		if(r2 == null && r1 == null){
 			return true;
 		}
 		
 		if(r1 == null || r2 == null){
 			return false;
 		}
 		
 		if(r1.val != r2.val){
 			return false;
 		}
 		
 		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }
}