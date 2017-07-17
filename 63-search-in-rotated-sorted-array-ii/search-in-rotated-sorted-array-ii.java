/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-in-rotated-sorted-array-ii/
@Language: Java
@Datetime: 17-07-17 16:00
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        
        //方法1：顺序查找（排序数组已旋转，无法直接利用二分查找）
        /*
        if(A == null || A.length == 0) 
            return false;
            
        for(int i = 0; i < A.length; i++){
            
            if(A[i] == target){
                
                return true;
            }     
        }
        
        return false;
        */
        
        
        //方法2：改进版的二分查找
        /*
          每次都把数组分成两半，判别哪一半是排过序的
          如果待查元素在排过序的那一半，那么用二叉搜索
          如果在另一半，那么在这另一半里，递归继续查找
          
          在搜索旋转数组的基础上 判断 left 和 mid 的值相等的情况
        */
        int low = 0;
        int high = A.length - 1;
        int size = A.length;
        int mid = 0;

        if(size <= 0) 
            return false;
       
        while(low <= high){
            
            mid = low + (high - low) / 2; 
            
            if(A[mid] == target) 
                return true;
            
            if(A[mid] > A[low]){
                
                if(A[low] <= target && target < A[mid]){
                    
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            
            else if(A[mid] < A[low]){
                
                if(A[mid] < target && target <= A[high]){
                    
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            
            else{
                low++;
            }
        }
        
        return false;        
    }
}