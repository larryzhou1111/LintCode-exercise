/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-node
@Language: Java
@Datetime: 17-05-31 15:11
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     * 
     * 解题思路：
     * 首先，要先遍历二叉树，从中找到值最大的节点然后返回，可以使用递归的方法。
     * 其次，怎样比较大小，因为要求返回的是一个节点，而不是最大值。
     * 所以新建了一个maximum函数，用于比较大小。
     * 具体情况为，当其中有一个节点为空的时候，返回另一个节点。
     * 当两个节点都不为空的时候，可以按数值大小，返回值较大的节点
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        
        if(root == null)
            return root;
        
        //递归！！！    
        TreeNode new_left = maxNode(root.left);
        TreeNode new_right = maxNode(root.right);
        return maximum(root, maximum(new_left, new_right));
    }

    TreeNode maximum(TreeNode x, TreeNode y) {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.val > y.val) {
            return x;
        }
        else return y;
    }
        
}