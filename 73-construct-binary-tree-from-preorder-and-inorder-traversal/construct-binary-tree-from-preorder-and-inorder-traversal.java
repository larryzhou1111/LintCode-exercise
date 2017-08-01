/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
@Language: Java
@Datetime: 17-7-3 22:00
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        
		//剑指offer题6
		
        /* 前序遍历和中序遍历树构造二叉树
        
           注意事项:你可以假设树中不存在相同数值的节点
           
           给出中序遍历：[1,2,3]和前序遍历：[2,1,3]. 返回如下的树:
           
             2
            / \
           1   3
           
        */
        
        /*
          前序遍历的第一个结点就是二叉树的根结点
          中序遍历，从第一个到根结点之前的结点序列为左子树，记录其长度为offset
          中序遍历中，根结点之后的结点序列，为右子树
		  前序遍历中，根节点之后，长度为offset的一段节点序列，都为左子树
		  再之后的节点序列，都为右子树
          
          然后使用递归来处理根结点的左子树和右子树
        */
        
        if(preorder == null || inorder == null)
            return null;

        return ConstructTree(preorder, inorder, 0, preorder.length - 1
                                              , 0, inorder.length - 1);
                                                
    }

    public TreeNode ConstructTree(int[] preOrder, int[] inOrder, int startPreorder, int endPreorder, int startInorder, int endInorder) {

        if(startPreorder > endPreorder || startInorder > endInorder)
            return null;

        TreeNode root = new TreeNode(preOrder[startPreorder]);

        int divider = 0;
        
        //找到中序遍历中相应的根节点
        while(divider <= endInorder && inOrder[divider] != root.val){
            
            divider++;
        }
        
        int offset = divider - startInorder - 1;
        
        //递归，找到根节点和左右子树
        
        //中序遍历，从第一个到根结点之前的结点序列，都是为左子树
        //前序遍历，从根结点之后，长度为offset的一段结点序列，都是为左子树        
        root.left = ConstructTree(preOrder, inOrder, startPreorder + 1, startPreorder + 1 + offset, startInorder,startInorder + offset);
        
        //右子树与上述同理
        root.right = ConstructTree(preOrder, inOrder, startPreorder + offset + 2, endPreorder, divider + 1, endInorder);

        return root;
        
		/*
		    // 中序遍历二叉树
			public static void inorder(TreeNode root) {
				if (root != null) {
					preorder(root.left);
					System.out.print(root.val + " ");
					preorder(root.right);
				}
			}

			// 先序遍历二叉树
			public static void preorder(TreeNode root) {
				if (root != null) {
					System.out.print(root.val + " ");
					preorder(root.left);
					preorder(root.right);
				}
			}
		*/
    }
}