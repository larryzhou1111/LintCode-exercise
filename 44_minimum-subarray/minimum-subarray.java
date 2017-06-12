/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 17-06-12 14:30
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        
        //每个数组的元素都有两种情况，加与不加
        //所以从第一个元素开始判断，包括第一个元素时,和不包括第一个元素的情况
        //取最小值，进行判断选择
        
        int min_ending_here = nums.get(0);
        int min_so_far = nums.get(0);
        
        for(int i=1; i<nums.size(); i++)
        {
            min_ending_here = Math.min(nums.get(i), nums.get(i) + min_ending_here);
            min_so_far = Math.min(min_ending_here, min_so_far);
        }
        
        return min_so_far;        
    }
}
