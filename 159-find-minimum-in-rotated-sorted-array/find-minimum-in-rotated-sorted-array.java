/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/find-minimum-in-rotated-sorted-array/
@Language: Java
@Datetime: 17-07-17 16:00
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        
        /* 寻找旋转排序数组中的最小值
        
            假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）
            你需要找到其中最小的元素
            
            你可以假设数组中不存在重复的元素
            
            样例
            给出[4,5,6,7,0,1,2]  返回 0
        */
        
        //方法1：二分查找，但没用利用旋转数组的特点
        /*
        if(nums == null || nums.length == 0) 
            return -1;
            
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            
            int mid = start + (end - start) / 2;
            
            if(nums[mid] < nums[end]){
                
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        return nums[start];
        */
        
        //方法2：改进版的二分查找
        /*
          可把旋转数组划分为前后两个排序数组
          若前一个排序数组的第一个元素，大于后一个排序数组的最后一个元素
          说明数组中的最小元素，在后一个排序数组中
          此时，移动中间位置，进入后一个排序数组中进行查找
          
          要注意数组已经从头至尾排好序的情况，此时最小值为第一个或最后一个元素
        */
        /*
        if(nums == null || nums.length == 0) 
            return -1;
            
        int start = 0;
        int end = nums.length - 1;
        
        // +1 是为了保证相邻
        while(start + 1 < end){
            
            int mid = start + (end - start) / 2;
            
            //中间位置的值大于末尾值，说明最小值在后一个排序数组中
            if(nums[mid] >= nums[end]){
                
                start = mid;
            } 
            
            //中间位置的值小于末尾值，说明最小值在前一个排序数组中
            else{
                end = mid;
            }
        }
        
        //已经是按递增排序，实际只能划分为一个排序数组 
        if(nums[start] < nums[end]){
             
            return nums[start];
        }
        
        //已经是按递减排序，实际只能划分为一个排序数组
        else{
            return nums[end];
        }
        */
        
        
        //方法3：剑指offer写法，不考虑重复元素，与方法2类似
        
        if(nums == null || nums.length == 0) 
            return Integer.MIN_VALUE;
            
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(nums[start] >= nums[end]){
            
            //相邻
            if(end - start <= 1){
                
                mid = end;
                break;
            }
            
            mid = start + (end - start) / 2;

            //中间位置的值大于前一个排序数组的起始值，说明最小值在后一个排序数组中
            if(nums[mid] >= nums[start]){
                
                start = mid;
            } 
            else{
                
                //中间位置的值小于后一个排序数组的末尾值，说明最小值在前一个排序数组中
                if(nums[mid] <= nums[end]){
                    
                    end = mid;
                }
            }
            
        }        
        
        return nums[mid];
        
        
        //方法4：剑指offer写法，考虑重复元素
        /*
        if(nums == null || nums.length == 0) 
            return Integer.MIN_VALUE;
            
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(nums[start] >= nums[end]){
            
            //相邻
            if(end - start <= 1){
                
                mid = end;
                break;
            }
            
            mid = start + (end - start) / 2;
            
            //如果有重复元素，则只能顺序查找
            if(nums[start] == nums[end] && nums[start] == nums[mid]){
                
                if(nums[start + 1] != nums[end - 1]){
                    
                    mid = nums[start + 1] < nums[end - 1] ? (start + 1):(end - 1);
                    break;
                }
                else{
                    
                    start++;
                    end--;
                }
            }
            
            else{
            
                //中间位置的值大于前一个排序数组的起始值，说明最小值在后一个排序数组中
                if(nums[mid] >= nums[start]){
                    
                    start = mid;
                } 
                else{
                    
                    //中间位置的值小于后一个排序数组的末尾值，说明最小值在前一个排序数组中
                    if(nums[mid] <= nums[end]){
                        
                        end = mid;
                    }
                }
            }
        }        
        
        return nums[mid];
        */
    }
}