/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/find-peak-element/
@Language: Java
@Datetime: 17-7-7 22:00
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        
        /* 寻找峰值
           假定P是峰值的位置,则满足A[P] > A[P-1] 且 A[P] > A[P+1]，
           返回数组中任意一个峰值的位置
        */
        
        /*
        //方法1：直接查找
        if(A == null || A.length < 3)
            return -1;
        
        int pos = -1;
            
        for(int i = 1; i < A.length - 1; i++){
            
            if(A[i] > A[i - 1] && A[i] > A[i + 1]){
                
                return i;
            }
        }
        
        return pos;
        */
        
        //方法2：二分查找
        int begin = 0;  
        int end = A.length - 1;  
        
        while(begin < end){  
            
            int mid = begin + (end - begin) / 2;  
            
            if(mid == 0){  
                
                return 1;  
            }    
            
            if(mid == A.length - 1){  
                
                return mid - 1;  
            }   
            
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){  
                
                return mid;  
            } 
            
            else if(A[mid] < A[mid - 1]){ 
                
                end = mid - 1; 
            }  
            
            else{
                
                begin = mid + 1;
            }  
                  
        }  
        return begin;
        
    }
}
