/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-06-12 14:35
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        
        //类比题44,但本题是整型数组，注意区别！
        
        //每个数组的元素都有两种情况，加与不加
        //所以从第一个元素开始判断，包括第一个元素时,和不包括第一个元素的情况
        //取最大值，进行判断选择
        
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        
        for(int i=1; i<nums.length; i++)
        {
            max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        
        return max_so_far;        
    }
}