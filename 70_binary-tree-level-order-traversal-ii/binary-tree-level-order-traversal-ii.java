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
		
        /* 二叉树的层次遍历 II
        
            给出一棵二叉树，返回其节点值从底向上的层次序遍历
            （按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
            
            样例
            给出一棵二叉树 {3,9,20,#,#,15,7},
                3
               / \
              9  20
                /  \
               15   7
               
            按照从下往上的层次遍历为：
            [
              [15,7],
              [9,20],
              [3]
            ]
        */
        
		/* 队列 queue   参考：http://www.cnblogs.com/end/archive/2012/10/25/2738493.html
		
			add：    添加一个元素，如果队列已满，则抛出一个IIIegaISlabEepeplian                                                         异常
			offer：  添加一个元素并返回true，如果队列已满，则返回false
			put：    添加一个元素，如果队列满，则阻塞
					
			remove： 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchEle                                              mentException异常
			poll：   移除并返问队列头部的元素，如果队列为空，则返回null
			take：   移除并返回队列头部的元素，如果队列为空，则阻塞
			
			element：返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementEx                                                     ception异常
			peek：   返回队列头部的元素，如果队列为空，则返回null
		*/ 		
        
        //逐层添加到队列,但是是倒序存放
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(root == null){
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