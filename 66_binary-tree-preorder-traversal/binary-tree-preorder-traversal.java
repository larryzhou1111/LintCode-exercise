/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 17-06-02 14:44
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
    
    /*方法1：调用记录函数
    
          ArrayList<Integer> result = new ArrayList<Integer>();
          travel(root, result);
          return result;
      }
  
    private void travel(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        travel(root.left, result);
        travel(root.right, result);\
    */
    
    //方法2：根-左-右 逐次添加
    
        ArrayList<Integer> result = new ArrayList<Integer>();
         
        if (root == null) {
            return result;
        }

        //遍历
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        //添加到路径
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
     
    }
}

