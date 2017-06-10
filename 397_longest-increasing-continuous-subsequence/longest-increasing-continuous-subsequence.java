/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 17-06-10 15:19
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        
        if(A.length == 0)
            return 0;
            
        else if(A.length == 1)
            return 1;
            
        else if(A.length == 2){
            
            if(A[0] != A[1])
                return 2;
            else
                return 1;
        }
        
        else{
            
            //设置循环标志位
            boolean flag = true;
            //定义起始位
            int start = 0;
            int result = 1;
            
            for(int i = 1; i < A.length; i++){
                
                if (A[i] > A[i-1]) {
                    
                    if (flag == true) {
                        result = Math.max(result, i + 1 - start);
                    } 
                    else{
                        start = i - 1;
                        flag = true;
                    }
                }
                
                else if(A[i] < A[i-1]) {
                    
                    if (flag == false) {
                       result = Math.max(result, i + 1 - start);
                    }
                    else{
                        start = i - 1;
                        flag = false;
                    }
                }
            }
            return result;
        }
    }
}