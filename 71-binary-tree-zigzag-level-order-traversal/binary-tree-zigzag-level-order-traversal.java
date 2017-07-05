/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/binary-tree-zigzag-level-order-traversal/
@Language: Java
@Datetime: 17-7-5 22:00
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        
        //二叉树的锯齿形层次遍历
        /*
          给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
          给出一棵二叉树 {3,9,20,#,#,15,7},
                3
               / \
              9  20
                /  \
               15   7
               
          返回其锯齿形的层次遍历为：
          [
              [3],
              [20,9],
              [15,7]
            ]
          
        */
        
        //用两个栈实现
        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)
            return tree;
            
        // rightstack 出栈序列是 左到右该层元素
        Stack<TreeNode> leftstack = new Stack<TreeNode>();
        leftstack.push(root);
        
        // leftstack 出栈序列是 右到左该层元素
        Stack<TreeNode> rightstack = new Stack<TreeNode>();
        
        boolean left = true;
        
        while(!leftstack.empty() || !rightstack.empty()){
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            if(left){
                
                int size = leftstack.size();
                
                for(int i = 0; i < size; i++){
                    
                    TreeNode node = leftstack.pop();
                    list.add(node.val);
                    
                    if(node.left != null)
                        rightstack.push(node.left);
                        
                    if(node.right != null)
                        rightstack.push(node.right);
                    
                }
            }
            
            else{
                
                int size = rightstack.size();
                
                for(int i = 0; i < size; i++){
                    
                    TreeNode node = rightstack.pop();
                    list.add(node.val);
                    
                    if(node.right != null)
                        leftstack.push(node.right);
                        
                    if(node.left != null)
                        leftstack.push(node.left);
                    
                }
            }
            
            left = !left;
            tree.add(list);
        }
        
        return tree;
        
		
        //以下用队列有问题！
        /*
        ArrayList result = new ArrayList();
 
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        boolean flag = true;
 
        while(!queue.isEmpty()){
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                TreeNode head = queue.poll();
                level.add(head.val);                
                
                if(flag == true){

                    if(head.left != null){
                        
                        queue.offer(head.left);     
                    }
                    
                    if(head.right != null){
                        
                        queue.offer(head.right);    
                    }
                    
                    flag = false;
                } 
                
                else{

                    if(head.right != null){
                        
                        queue.offer(head.right);    
                    } 
                    
                    if(head.left != null){
                        
                        queue.offer(head.left);     
                    }

                    flag = true;
                } 
            }

            result.add(level);
        }
 
        return result;
        */
    }
}