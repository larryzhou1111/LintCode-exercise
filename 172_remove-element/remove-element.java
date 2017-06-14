/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 17-06-14 15:05
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        
        if(A == null || A.length == 0) 
            return 0; 
        
        int len = 0;
            
        for(int i = 0; i < A.length; i++){
            
            if(A[i] != elem){
                
                //得到新数组
                A[len] = A[i];
                len++;
            }
        }
        return len;    
    }
}
