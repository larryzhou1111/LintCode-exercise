/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/two-sum-input-array-is-sorted/
@Language: Java
@Datetime: 17-07-23 11:00
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        
        /* 递增排序数组中，找两数之和等于target
        
            样例:Given nums = [2, 7, 11, 15], target = 9
            return [1, 2]
        */
        
        //剑指offer题41-1，双指针法.区别于lint56（数组未排序）
        
        if(nums == null || nums.length == 0)
            return null;        
        
        int start = 0;
        int end = nums.length - 1;
        
        int[] result = new int[2];
        
        while(start < end){
            
            int curSum = nums[start] + nums[end];
            
            if(curSum == target){
                
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            else if(curSum > target){
                
                end--;
            }
            else{
                
                start++;
            }
        }
        
        return result;
    }
}