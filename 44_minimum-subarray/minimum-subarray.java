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
        
        /* 最小子数组，类比题41
             给定一个整数数组，找到一个具有最小和的子数组。返回其最小和
             
             注意事项:子数组最少包含一个数字
             
             样例: 给出数组[1, -1, -2, 1]，返回 -3
        */

        //方法1：暴力枚举。效率低，略
        
        //方法2：贪心法，复杂度O（n）
        //将子串和为正数的子串丢掉，更新为当前的数组元素；若子串和为负，继续累加
        /*
        if(nums == null || nums.size() == 0)
            return Integer.MAX_VALUE;
        
        int min = Integer.MAX_VALUE;  
        int sum = 0;  
        
        for(int i = 0; i < nums.size(); i++){  
            
            if(sum > 0){  
                
                //子串和为正数，丢掉，更新为当前的数组元素
                sum = nums.get(i);     
            }
            else{
                sum += nums.get(i);
            }
            
            if(sum < min){  
                
                min = sum;  
            }  
        }  
        
        return min; 
        */
        
        
        //方法3：动态规划法：
        /*
          每个数组的元素都有两种情况，加与不加
          所以从第一个元素开始判断，包括第一个元素时,和不包括第一个元素的情况
          取最小值，进行判断选择
          
          给出数组[1, -1, -2, 1]，返回 -3
          
          nums	            1	-1	 -2	   1	 
          
          min_ending_here	1	-1	 -3	  -2	  
         
          min_so_far	    1	-1	 -3	  -3	 
          
        */
        
        if(nums == null || nums.size() == 0)
            return Integer.MAX_VALUE;
            
        int min_ending_here = nums.get(0);
        int min_so_far = nums.get(0);
        
        for(int i = 1; i < nums.size(); i++){
            
            min_ending_here = Math.min(nums.get(i), nums.get(i) + min_ending_here);
            
            //比较当前和，和当前最小值。判断是否更新最小值
            min_so_far = Math.min(min_ending_here, min_so_far);
            
        }
        
        return min_so_far;  
        
    }
}