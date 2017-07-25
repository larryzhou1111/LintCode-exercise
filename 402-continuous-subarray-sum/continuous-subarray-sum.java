/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/continuous-subarray-sum/
@Language: Java
@Datetime: 17-07-25 12:00
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        
        /* 连续子数组求和
            给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。输出答案时，请分别返回第一个数字和最后一个数字的下标。（如果两个相同的答案，请返回其中任意一个）
            
            样例:给定 [-3, 1, 3, -3, 4], 返回[1,4]
        */

        //方法：动态规划法
        /*
          每个数组的元素都有两种情况，加与不加
          所以从第一个元素开始判断，包括第一个元素时,和不包括第一个元素的情况
          
          只要子串和加上当前元素，仍然小于当前元素，说明子串和为负数，丢掉 
          并且将子串和，更新为当前的数组元素，同时更新起始和终止位置

          如果当前子串和已是最大，则将起始和终止位置添加到结果集中。

          给出数组[-3, 1, 3, -3, 4]，符合要求的子数组为[1, 3, -3, 4]，其最大和为5
          
          A	                -3	 1	 3	-3	 4	  
                               /
          sum           	-3	 1	 4	 1	 5	 
                               /
          max       	    -3	 1	 4	 1	 5	 
        */
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(A == null || A.length == 0)
            return res;
            
        int sum = A[0];
        int max = A[0];
        
        int start = 0;
        int end = 0;
        
        res.add(start);
        res.add(end);
        
        for(int i = 1; i < A.length; i++){
            
            if(sum > max){  
                
                max = sum;  
                //更新索引
                res.set(0, start); 
                res.set(1, i - 1);
            }   
            
            if(A[i] >  sum + A[i]){  
                
                //子串和加上当前元素，仍然小于当前元素，说明子串和为负数，丢掉
                //将子串和，更新为当前的数组元素，同时更新起始和终止位置
                sum = A[i];     
                start = i;
                end = i;
            }
            else{
                sum += A[i];
            }

        } 
        
        //子数组即为原数组
        if(sum > max){
            
            res.set(0, start);
            res.set(1, A.length - 1);
        }
        
        return res; 
    }
}