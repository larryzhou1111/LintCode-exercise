/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/minimum-adjustment-cost/
@Language: Java
@Datetime: 17-7-8 22:00
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        
        /* 最小调整代价
            给一个整数数组，调整每个数的大小，
            使得相邻的两个数的差小于一个给定的整数target，
            调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
        
            注意事项:
            你可以假设数组中每个整数都是正整数，且小于等于100
            
            样例:
            对于数组[1, 4, 2, 3]和 target = 1，
            最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2
        */
        
        /*  本问题与题92背包问题类似，可以用动态规划解决
        
            i表示数组第i个元素，j从0到100进行遍历
            
            dp[i][j]表示第i个元素变成j的最小调整代价

                 	0	1	2	3	4
                1	1	0	1	2	3
                4	4	3	 	 	 
                2	 	 	 	 	 
                3	 
                
            表格如上表所示，且每一行只与其上一行有关。
            返回最后一行的最小值
        */
        
        if(A== null || A.size() < 2) 
            return 0;  

        int m = A.size();  
        long[][] dp = new long[m][101]; 
        
        for(int i = 0; i < 101; i++){  
            
            dp[0][i] = Math.abs(A.get(0) - i);   
        }  
        
        for(int i = 1; i < m; i++){ 
            
            for(int j = 0; j < 101; j++){  
                
                dp[i][j] = Integer.MAX_VALUE; 
                
                int dif = Math.abs(j - A.get(i));  
                int max = Math.min(100, j + target);  
                int min = Math.max(0, j - target); 
                
                for(int k = min; k <= max; k++){  
                    
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + dif);  
                }  
            }  
        } 
        
        long ans = Integer.MAX_VALUE;  
        
        for(int j = 0; j < 101; j++){  
            
            ans = Math.min(ans, dp[m - 1][j]);  
        }  
        
        return(int) ans; 
    }
}