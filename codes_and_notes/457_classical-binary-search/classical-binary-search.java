/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 17-06-01 01:19
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        
        //二分查找
        int low = 0;
        int high = nums.length - 1;
        int mid;
        
        while(low <= high){
            
            mid = (low + high) / 2;
            if(target < nums[mid]){
                high = mid - 1;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else 
                return mid;
        }
        
        return -1;
    }
}