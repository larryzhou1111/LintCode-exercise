/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/find-minimum-in-rotated-sorted-array-ii/
@Language: Java
@Datetime: 17-07-17 16:00
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        
        /* 寻找旋转排序数组中的最小值 II 
        
        假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）

        你需要找到其中最小的元素
        数组中可能存在重复的元素!!!
        
        样例
        给出[4,4,5,6,7,0,1,2]  返回 0
        */
        
        //方法1：顺序查找（有重复元素，无法直接利用二分查找）
        /*
        if(num == null || num.length == 0) 
            return Integer.MIN_VALUE;
            
        int min = num[0];
        
        for(int i = 1; i < num.length; i++){
            
            if(num[i] < min){
                
                min = num[i];
            }     
        }
        
        return min;        
        */
        
        
        //方法2：剑指offer题8，考虑重复元素
        
        if(num == null || num.length == 0) 
            return Integer.MIN_VALUE;
            
        int start = 0;
        int end = num.length - 1;
        int mid = 0;
        
        while(num[start] >= num[end]){
            
            //相邻
            if(end - start <= 1){
                
                mid = end;
                break;
            }
            
            mid = start + (end - start) / 2;
            
            //如果有重复元素，则只能顺序查找
            if(num[start] == num[end] && num[start] == num[mid]){
                
                if(num[start + 1] != num[end - 1]){
                    
                    mid = num[start + 1] < num[end - 1] ? (start + 1):(end - 1);
                    break;
                }
                else{
                    
                    start++;
                    end--;
                }
            }
            
            else{
            
                //中间位置的值大于前一个排序数组的起始值，说明最小值在后一个排序数组中
                if(num[mid] >= num[start]){
                    
                    start = mid;
                } 
                else{
                    
                    //中间位置的值小于后一个排序数组的末尾值，说明最小值在前一个排序数组中
                    if(num[mid] <= num[end]){
                        
                        end = mid;
                    }
                }
            }
        }        
        
        return num[mid];
        
    }
}