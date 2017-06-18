/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-insert-position/
@Language: Java
@Datetime: 17-06-18 19:54
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        
        if(A == null)
            return -1;
            
        if(A.length == 0)
            return 0;            
        
        int len1 = 0;
        int len = A.length - 1;
        
        while(len1 <= len) {
            
            //二分查找
            int m = len1 + (len - len1)/2;
            
            if(A[m] == target){
                
                return m;
            }
            //在右边
            else if(A[m] < target){
                
                len1 = m + 1;
            }
            //在左边
            else{
                len = m - 1;
            }
        }
        return len1;    
    }
}
