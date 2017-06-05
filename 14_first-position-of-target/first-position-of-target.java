/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-06-05 11:13
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        
        //二分查找,第一个下标。区别于题457 ！
        int low = 0;
        int high = nums.length - 1;
        int mid;
        
        while(low < high){
            
            //防止low + high 溢出
            mid = (high - low) / 2 + low;
            
            if(target < nums[mid]){
                high = mid - 1;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            //当查找到target时，继续往左推进，查找第一次出现的下标
            else
                high = mid;
        }
        
        if(target == nums[high])
            return high;
            
        return -1;
    }
}