/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 17-06-03 11:54
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
		
        /* 二叉树的层次遍历
            给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
            
            样例:
            给一棵二叉树 {3,9,20,#,#,15,7} ： 
              3
             / \
            9  20
              /  \
             15   7
 
            返回他的分层遍历结果：
            [
              [3],
              [9,20],
              [15,7]
            ]
        */
        
		/* 队列 queue   参考：http://www.cnblogs.com/end/archive/2012/10/25/2738493.html
		
			add：    添加一个元素，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
			offer：  添加一个元素并返回true，如果队列已满，则返回false
			put：    添加一个元素，如果队列满，则阻塞
					
			remove： 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElement                                                      Exception异常
			poll：   移除并返问队列头部的元素，如果队列为空，则返回null
			take：   移除并返回队列头部的元素，如果队列为空，则阻塞
			
			element：返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementExcept                                                             ion异常
			peek：   返回队列头部的元素，如果队列为空，则返回null
		*/ 
		
        ArrayList result = new ArrayList();
 
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
 
        while(!queue.isEmpty()){
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                TreeNode head = queue.poll();
                
                level.add(head.val);
                
                if(head.left != null){
                    
                    queue.offer(head.left);     
                }
                
                if(head.right != null){
                    
                    queue.offer(head.right);    
                }
            }
            result.add(level);
        }
 
        return result;
    }
}