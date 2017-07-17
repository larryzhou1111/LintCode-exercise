/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-in-rotated-sorted-array/
@Language: Java
@Datetime: 17-07-17 16:00
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        
        /* 搜索旋转排序数组
        
        假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)
        给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1

        你可以假设数组中不存在重复的元素
        
        样例
        给出[4, 5, 1, 2, 3]和target=1，返回 2
        给出[4, 5, 1, 2, 3]和target=0，返回 -1
        */
        
        //方法1：顺序查找（排序数组已旋转，无法直接利用二分查找）
        /*
        if(A == null || A.length == 0) 
            return -1;
            
        for(int i = 0; i < A.length; i++){
            
            if(A[i] == target){
                
                return i;
            }     
        }
        
        return -1; 
        */
        
        //方法2：改进版的二分查找
        /*
          可把旋转数组划分为前后两个排序数组
          每次都把数组分成两半，判别哪一半是排过序的
          如果待查元素在排过序的那一半，那么用二叉搜索
          如果在另一半，那么在这另一半里，递归继续查找
          
          要注意数组已经从头至尾排好序的情况
        */
        /*
        if(A == null || A.length == 0) 
            return -1;
            
        int start = 0;
        int end = A.length - 1;
        
        // +1 是为了保证相邻
        while(start + 1 < end){
            
            int mid = start + (end - start) / 2;
            
            if(A[mid] == target){
                
                return mid;
            }
            
            if(A[start] < A[mid]){ 
                
                //进入mid的左边寻找 
                if(A[start] <= target && target <= A[mid]) {
                    
                    end = mid;
                } 
                //进入mid的右边寻找
                else{
                    start = mid;
                }
            } 

            else{ 

                if(A[mid] <= target && target <= A[end]){
                    
                    start = mid;
                } 
                else{
                    end = mid;
                }
            }
        }
        
        if(A[start] == target){
             
            return start;
        } 
         
        if(A[end] == target){
             
            return end;
        }
         
        return -1;
        */
        
        //写法3：与方法2思路类似
        /*
          每次都把数组分成两半，判别哪一半是排过序的
          如果待查元素在排过序的那一半，那么用二叉搜索
          如果在另一半，那么在这另一半里，递归继续查找
        */
        int low = 0;
        int high = A.length-1;
        int size = A.length;
        int mid = 0;

        if(size <= 0) 
            return -1;

        while(low <= high){
            
            mid = (high - low) / 2 + low; 
            
            if(A[mid] == target){
                
                return mid;
            }
            
            if(A[mid] >= A[low]){
                
                if(A[low] <= target && target < A[mid]){
                    
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                
                if(A[mid] < target && target <= A[high]){
                    
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        
        return -1;        
        
    }
}