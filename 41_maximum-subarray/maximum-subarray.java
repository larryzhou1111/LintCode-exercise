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
        
        //最大子数组，类比题44, 但本题是整型数组，注意区别！
        
        //方法1：暴力枚举。效率低，略
        
        
        //方法2：贪心法，复杂度O（n）
        //将子串和为负数的子串丢掉，只留和为正的子串
        /*
        int max = Integer.MIN_VALUE;  
        int sum = 0;  
        
        for(int i = 0; i < nums.length; i++){  
            
            sum += nums[i];  
            
            if(sum > max){  
                
                max = sum;  
            } 
            
            if(sum < 0){  
                
                //子串和为负数，丢掉
                sum = 0;     
            }  
        }  
        
        return max;         
        */
        
        
        //方法3：动态规划法
        /*
          每个数组的元素都有两种情况，加与不加
          所以从第一个元素开始判断，包括第一个元素时,和不包括第一个元素的情况
          取最大值，进行判断选择
          
          给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
          
          nums	            -2	 2	-3	 4	-1	 2	 1	-5	 3
          
          max_ending_here	-2	 2	-1	 4	 3	 5	 6	 1	 4
         
          max_so_far	    -2	 2	 2	 4	 4	 5	 6	 6	 6
          
        */
        
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            //判断加上当前和的下一位后，当前和大小的变化
            //若小于，则舍弃当前和，跳到下一位，继续判断
            max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
            
            //比较当前和，和当前最大值。判断是否更新最大值
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        
        return max_so_far; 
        
    }
}