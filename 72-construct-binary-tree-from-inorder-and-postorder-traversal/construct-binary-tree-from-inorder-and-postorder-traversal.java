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
		
		//剑指offer题6
        
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
            
        return ConstructTree(inorder, 0, inorder.length - 1, 
                         postorder, 0, postorder.length - 1 );
                         
    }

    
    public TreeNode ConstructTree(int[] inorder, int startInorder, int endInorder,int[] postorder, int startPostorder, int endPostorder){
                                  
        if(startPostorder > endPostorder || startInorder > endInorder)
            return null;
            
        //后序遍历中的根结点            
        TreeNode root = new TreeNode(postorder[endPostorder]);

        int divider = 0;
        
        //找到中序遍历中相应的根节点
        while(divider <= endInorder && inorder[divider] != root.val){
            
            divider++;
        }   
        
        int offset = divider - startInorder - 1;
        
        //递归，找到根节点和左右子树
        
        //中序遍历，从第一个到根结点之前的结点序列，都是为左子树
        //后序遍历，从第一个节点开始，长度为offset的一段结点序列，都是为左子树   
        root.left = ConstructTree(inorder, startInorder, divider - 1, 
                        postorder, startPostorder, startPostorder + offset);
        
        //右子树与上述同理
        root.right = ConstructTree(inorder, divider + 1, endInorder, 
                    postorder, startPostorder + offset + 1, endPostorder - 1);

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

			// 后序遍历二叉树
			public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
				//左-右-根 逐次添加
			
				ArrayList<Integer> result = new ArrayList<Integer>();
				 
				if (root == null) {
					return result;
				}

				//遍历
				ArrayList<Integer> left = postorderTraversal(root.left);
				ArrayList<Integer> right = postorderTraversal(root.right);

				//添加到路径
				result.addAll(left);
				result.addAll(right);
				result.add(root.val);

				return result;
			}
		*/
        
    }
}