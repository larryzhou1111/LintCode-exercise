/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-06-03 12:38
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null)
            return result;

        Stack<Integer> stack = new Stack<Integer>();
        
        PathSum(result, stack, root, 0, target);
        
        return result;
    }

    public void PathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum, int target) {
        
        sum += root.val;
        stack.push(root.val);
        
        if(sum == target && root.left == null && root.right == null) {
            
            List<Integer> list = new ArrayList<Integer>(stack);
            result.add(list);
            stack.pop();
            return;
            
        }else {
            
            if(root.left != null)
                PathSum(result, stack, root.left, sum, target);
                
            if(root.right != null)
                PathSum(result, stack, root.right, sum, target);
                
            stack.pop();
        }
    }
}