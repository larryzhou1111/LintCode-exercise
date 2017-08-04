/*
@Author:   larryzhou
@Problem:  二叉树的下一个结点（剑指offer题58）
@Language: Java
@Datetime: 17-08-4 21:00
*/
        
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        
		/*
			给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
			注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
		*/
		/*
			如果一个节点有右子树，则它的下一个节点就是它的右子树中的最左子节点
			如果一个节点没有右子树：
				如果节点是它父节点的左子节点，则它的下一个节点就是它的父节点
				如果节点是它父节点的右子节点，可以沿着指向父节点的指针一直向上遍历，
				  直到找到一个是它父节点的左子节点的节点
					如果这样的节点存在，则这个节点的父节点就是要找的下一个节点
		*/
        TreeLinkNode node = pNode;

        if(node == null) 
            return null;
        
        if(node.right != null){    
            
            //如果有右子树，则找右子树的最左子节点
            node = node.right;
            
            while(node.left != null){
                
                node = node.left;
            } 
                            
            return node;
        }
        
        while(node.next != null){ 
            
            //没右子树，则找第一个当前节点是父节点的左子节点
            if(node.next.left == node){
                
                return node.next;
            } 
                            
            node = node.next;
        }
        
        //退到了根节点仍没找到，则返回null
        return null;   
    }
}