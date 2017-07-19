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
        
        /* 二叉树的路径和 
        
            给定一个二叉树，找出所有路径中各节点相加总和等于给定目标值的路径
            一个有效的路径，指的是从根节点到叶节点的路径

            样例
            给定一个二叉树，和 目标值 = 5:
                 1
                / \
               2   4
              / \
             2   3
             
            返回：
            [
              [1, 2, 2],
              [1, 4]
            ]
        */
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null)
            return result;
        
        //保存路径
        Stack<Integer> stack = new Stack<Integer>();
        
        PathSum(result, stack, root, 0, target);
        
        return result;
    }

    public void PathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum, int target) {
        
        sum += root.val;
        stack.push(root.val);
        
        //到达叶子节点，且路径和等于给定值
        if(sum == target && root.left == null && root.right == null) {
            
            //将栈stack中元素存入List中
            List<Integer> list = new ArrayList<Integer>();
            
            for(int node : stack){
                
                list.add(node);
            }
            
            //然后将List存入result中
            result.add(list);
            
            //弹出栈顶元素，相当于往回退一步，可继续搜索其他也符合条件的路径
            stack.pop();
			
			//退出方法
			//return;
        }
        else{
            
            //递归左右子树的路径和
            if(root.left != null){
                
                PathSum(result, stack, root.left, sum, target);
            }
                
            if(root.right != null){
                
                PathSum(result, stack, root.right, sum, target);
            }
                
            stack.pop();
        }
    }
    
    /*
        Java中关键字continue、break和return的区别：
        
        continue：跳出本次循环继续下一次循环
        break：   跳出循环体，继续执行循环外的函数体
        return:   跳出整个函数体，函数体后面的部分不再执行
    */
}