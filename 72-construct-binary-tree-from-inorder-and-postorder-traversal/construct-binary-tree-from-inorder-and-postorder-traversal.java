/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/construct-binary-tree-from-inorder-and-postorder-traversal/
@Language: Java
@Datetime: 17-7-4 22:00
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        
        /* 中序遍历和后序遍历树构造二叉树
        
           注意事项:你可以假设树中不存在相同数值的节点
           
           给出树的中序遍历：[1,2,3] 和后序遍历：[1,3,2]. 返回如下的树:
           
             2
            / \
           1   3
           
        */
        
        /*
          后序遍历，最后一个结点就是二叉树的根结点
          中序遍历，从第一个到根结点之前的结点序列为左子树
          中序遍历中，根结点之后的结点序列，为右子树
          
          然后使用递归来处理根结点的左子树和右子树
        */
        
        if(inorder.length != postorder.length)
            return null;
            
        return buildTree(inorder, 0, inorder.length - 1, 
                         postorder, 0, postorder.length - 1);
                         
    }
    
    public int findroot(int[] inorder, int r){
        
        for(int i = 0; i < inorder.length; i++){
           
            if(inorder[i] == r)
                return i;
        }
        return - 1;
    }
    
    public TreeNode buildTree(int[] inorder, int istart, int iend, 
                              int[] postorder, int pstart, int pend){
                                  
        if(istart > iend)
            return null;
            
        // 根结点            
        int r = postorder[pend];
        TreeNode root = new TreeNode(r);
        
        // 找到根节点
        int l = findroot(inorder, r);
        
        //左子树 中序遍历 起始结束位置以此是：istart l - 1 
        
        //后序遍历 起始位置是：pstart 结束位置:
        //pstart(已经占据了一个位置所以要 - 1) + (左子树的长度) - 1
        root.left = buildTree(inorder, istart, l - 1, postorder,
                                    pstart, pstart + (l - 1 - istart + 1) - 1);
                                    
        //右子树 中序遍历 起始结束位置：l + 1 iend
        
        //后序遍历 起始位置：pstart + (左子树的长度) ,结束位置 pend -1
        root.right = buildTree(inorder, l + 1, iend, postorder,
                                     pstart + (l - 1 - istart + 1), pend -1);
        
        return root;
        
    }
}