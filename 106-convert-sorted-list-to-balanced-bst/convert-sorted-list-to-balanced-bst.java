/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/convert-sorted-list-to-balanced-bst/
@Language: Java
@Datetime: 17-07-20 19:00
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        
        /* 排序列表转换为二分查找树
        
        给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
        
        样例
                       2
        1->2->3  =>   / \
                     1   3
        */
        
        //类比题177：把排序数组转换为高度最小的二叉搜索树 （递归数组中间位置的左右两段）
        //剑指offer题15后的相关题目：求链表的中间节点（快慢指针法）
        //类比题166：链表倒数第n个节点 （快慢指针法）
        
        //思路1：
        /*
            查找到排序链表的中值，作为根节点
            然后将链表以中间位置分割为左右两段，递归处理，分别生成左右子树
        */
        
        //思路2：把排序链表转为排序list，将本题转化为题177
        if(head == null)
            return null;

	    ArrayList<Integer> list=new ArrayList<Integer>();        
        
        //遍历链表，把排序链表转为排序list
	    while(head!=null){
	        
	    	list.add(head.val);
	    	head = head.next;
	    }
	    
	    TreeNode root = null;
	    TreeNode result = Convert(root, list, 0, list.size()-1);
	    
	    return result;        
    } 
    
    
	private static TreeNode Convert(TreeNode root, ArrayList<Integer> list, int start, int end){
	    
		if(start > end)
			return null;
		    
		int mid = (end - start) / 2 + start;
		root = new TreeNode(list.get(mid));
		
		//递归生成左右子树
		root.left = Convert(root, list, start, mid - 1);
		root.right = Convert(root, list, mid + 1, end);
		
		return root;
	}
    
    
    /* 
        快慢指针法，找链表的中间节点
        快慢指针都从头节点开始走，快指针一次走两步，慢指针一次走一步
        当快指针到达链表末尾时，慢指针刚好到达链表的中间位置
    */
    /*
    public ListNode findMiddle(ListNode head){
        
        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow; 
    }      
    */
}