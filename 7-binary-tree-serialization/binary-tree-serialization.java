/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/binary-tree-serialization/
@Language: Java
@Datetime: 17-06-26 22:30
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    
    //剑指offer题62
     
    public int index = -1; 
     
    public String serialize(TreeNode root) {
        // write your code here

        if(root == null){
            
            return "#,";
        }
        
        //前序遍历，根-左-右 顺序添加
        String data = root.val + ",";
        data += serialize(root.left);
        data += serialize(root.right);
        
        return data;
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        
        //先序列化，再反序列化
        
        index++;
        int len = data.length();
        
        if(index >= len)
            return null;
        
        String[] values = data.split(",");
        TreeNode treeNode = null;
        
        if(!values[index].equals("#")){
            
            treeNode = new TreeNode(Integer.valueOf(values[index]));
            treeNode.left = deserialize(data);
            treeNode.right = deserialize(data);
        }
        
        return treeNode;
    }
}