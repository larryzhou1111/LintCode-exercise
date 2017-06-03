/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 17-06-03 11:55
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        
        //逐层添加到队列,但是是倒序存放
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        int currLevelNodeNum = 1;
        int nextLevelNodeNum = 0;

        while (currLevelNodeNum != 0) {
            
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;

            while (currLevelNodeNum != 0) {
                
                TreeNode node = queue.poll();

                currLevelNodeNum--;
                
                currLevelResult.add(node.val);

                if (node.left != null) {
                    
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }

                if (node.right != null) {
                    
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }

            result.add(0, currLevelResult); 		
            currLevelNodeNum = nextLevelNodeNum;
        }
        return result;

    }
}