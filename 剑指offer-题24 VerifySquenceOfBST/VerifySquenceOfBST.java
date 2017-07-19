/*
@Author:   larryzhou
@Problem:  二叉搜索树的后序遍历序列
@Language: Java
@Datetime: 17-07-19 16:00
*/

import java.util.Arrays;
       
public class Solution {
   public static boolean VerifySquenceOfBST(int[] sequence) {
		// write your code here
		
		/* 题目描述
			输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
			假设输入的数组的任意两个数字都互不相同！
        */
        
        /*
			思路：
			二叉搜索树,后序序列最后一个值为root，二叉搜索树左子树值都比root小，右子树值都比root大，

			1、确定root
			2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边应该为右子树
			3、遍历右子树，若发现有小于root的值，则直接返回false
			4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）
		*/

		if(sequence == null|| sequence.length == 0)
            return false;

        int root = sequence[sequence.length - 1];
        
		int i = 0;
        for(;i < sequence.length - 1; i++){
	
            if(sequence[i] > root){
                break;
            }
        }
		
		//i为左右子树的分界点
        int j = i;
        for(;j < sequence.length - 1; j++){
	
            if(sequence[j] < root)
                return false;
        }

        boolean left = true;
        boolean right = true;

        if(i > 0){
	
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        if(i < sequence.length - 1){
	
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
		}
		
        return (left && right);
    }
}