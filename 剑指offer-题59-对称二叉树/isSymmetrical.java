/*
@Author:   larryzhou
@Problem:  对称的二叉树（剑指offer题59）
@Language: Java
@Datetime: 17-08-4 21:00
*/
        
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot){
        
		/*
			请实现一个函数，用来判断一颗二叉树是不是对称的
			注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
		*/
		
        return isSymmetricalTree(pRoot, pRoot);
    }
    
    public boolean isSymmetricalTree(TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 == null || root2 == null)
            return false;
        
        if(root1.val != root2.val)
            return false;
        
		//递归进行判断，树的左子节点，对应镜像树的右子节点
        return isSymmetricalTree(root1.left, root2.right) 
				&& isSymmetricalTree(root1.right, root2.left);        
    }
}