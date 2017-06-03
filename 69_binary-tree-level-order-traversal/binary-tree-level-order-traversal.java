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
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        
        ArrayList result = new ArrayList();
 
        if (root == null) {
            return result;
        }
 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
 
        while (!queue.isEmpty()) {
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode head = queue.poll();
                // add value to result level
                level.add(head.val);
                
                if (head.left != null) {
                    // add left to queue
                    queue.offer(head.left);     
                }
                
                if (head.right != null) {
                    // add right to queue
                    queue.offer(head.right);    
                }
            }
            result.add(level);
        }
 
        return result;
    }
}