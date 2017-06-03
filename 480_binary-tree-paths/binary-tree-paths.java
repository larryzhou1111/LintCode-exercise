/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-06-03 13:20
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
     
    //先定义结果集合
    List<String> result = new ArrayList<String>();
        
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        
        //遍历过程中记录之前的路径，一旦遍历到叶子节点便将该路径加入结果中
        if(root != null) 
            findPaths(root,String.valueOf(root.val));
            
        return result;
    }
    
    private void findPaths(TreeNode n, String path){
        
        if(n.left == null && n.right == null) 
            result.add(path);
            
        if(n.left != null) 
            findPaths(n.left, path + "->" + n.left.val);
        
        if(n.right != null) 
            findPaths(n.right, path + "->" + n.right.val);
            
    }
}