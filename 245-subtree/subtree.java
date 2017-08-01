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
        
		//剑指offer题18
		
        /* 子树 
            有两个不同大小的二进制树： T1 有上百万的节点； T2 有好几百的节点
            请设计一种算法，判定 T2 是否为 T1的子树。

            注意事项:
            若 T1 中存在从节点 n 开始的子树与 T2 相同，我们称 T2 是 T1 的子树
            也就是说，如果在 T1 节点 n 处将树砍断，砍断的部分将与 T2 完全相同
            
            样例:
            下面的例子中 T2 是 T1 的子树：
            
                   1                3
                  / \              / 
            T1 = 2   3      T2 =  4
                    /
                   4
                   
            下面的例子中 T2 不是 T1 的子树：
            
                   1               3
                  / \               \
            T1 = 2   3       T2 =    4
                    /
                   4
        */
        
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
 		
 		//在树 A 中找到和 B 的根结点的值一样的结点
 		if(r1.val == r2.val){
 		    
 		    //判断是否是子树
 			if(matchTree(r1, r2))
 			    return true;
 		}
 		
 		//当前节点值与 B 的根结点的值不一样，则进入其左右子树，继续搜索比较
 		return (subTree(r1.left, r2) || subTree(r1.right, r2));
 		
 	}
 
 
 	public boolean matchTree(TreeNode r1, TreeNode r2){ 		
 	    
 	    //判断树 A 中,以 r1 为根结点的子树,是不是包含和树 B 一样的结构
 		if(r1 == null && r2 == null){
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