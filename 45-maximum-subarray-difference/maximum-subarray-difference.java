/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/maximum-subarray-difference/
@Language: Java
@Datetime: 17-06-29 22:00
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        
        /*
           给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值
           |SUM(A) - SUM(B)|最大。返回这个最大的差值。
        */
        
        //类比题41、44，求最大和最小子数组 (动态规划法)
        
        //思路：
        /*
            从左至右遍历，数组的最大子数组maxLeft、最小子数组minLeft，其每一位
            对应的最大最小值，均保存到相应的数组中
            
            从右至左遍历，数组的最大子数组 maxRight、最小子数组 minRight，其每一位
            对应的最大最小值，均保存到相应的数组中
            
            然后比较 maxLeft[]与maxRight[]的最大值，即可得出最大子数组差
            
            需要注意子数组不能重叠有交集！！！
        */
        
        if(nums == null || nums.length ==0)
            return 0;
            
        int len = nums.length;
        
        int[] left_max = new int[len];
        int[] left_min = new int[len];        
        
        int[] right_max = new int[len];
        int[] right_min = new int[len];        

        int local_max = 0;
        int local_min = 0;        

        int global_max = Integer.MIN_VALUE;
        int global_min = Integer.MAX_VALUE;        

        for(int i = 0; i < len; i++){
            
            local_max = Math.max(local_max + nums[i], nums[i]);
            global_max = Math.max(local_max, global_max);
            left_max[i] = global_max; 
            
            local_min = Math.min(local_min + nums[i], nums[i]);
            global_min = Math.min(local_min, global_min);
            left_min[i] = global_min;
        }
        
        local_max = 0;        
        local_min = 0;
        
        global_max = Integer.MIN_VALUE;        
        global_min = Integer.MAX_VALUE;
        
        for(int i = len - 1;i >= 0; i--){
            
            local_min = Math.min(local_min + nums[i], nums[i]);
            global_min = Math.min(local_min, global_min);
            right_min[i] = global_min;
            
            local_max = Math.max(local_max + nums[i], nums[i]);
            global_max = Math.max(local_max, global_max);
            right_max[i] = global_max;
        }
        
        int left_MAX = Integer.MIN_VALUE;
        int right_MAX = Integer.MIN_VALUE;
        
        //避免子数组有交叉
        for(int i = 0; i < len - 1; i++){
            
            left_MAX = Math.max(Math.abs(left_max[i] - right_min[i + 1]), left_MAX);
            right_MAX = Math.max(Math.abs(left_min[i] - right_max[i + 1]), right_MAX);
        }
        
        return Math.max(left_MAX, right_MAX);
        
    }
}

