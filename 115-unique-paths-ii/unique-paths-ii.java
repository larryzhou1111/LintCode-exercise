/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/unique-paths-ii/
@Language: Java
@Datetime: 17-06-25 22:30
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        
        //类比题114
        
        //方法：动态规划法 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 
        //需要注意的是：如果当前网格的值为1（有障碍），那么到此网格的路径数归0！！！
       
        /*
          1	  1	  1	  1	  1	  1	  1
          1	  2	  3	  4   5	  6	  7
          1	  3	  6	  10  15  21  28
        */
        
        if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) 
            return 0;  
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
            
        int[][] dp = new int [m][n];
        dp[0][0] = 0;
        
        //初始行
        for(int i = 0; i < m; i++){
            
            //判断该行上是否有障碍
            if(obstacleGrid[i][0] == 0){
           
                dp[i][0] = 1;
            }
            else{
                
                dp[i][0] = 0;
                break;
            }
        }
        
        //初始列
        for(int j = 0; j < n; j++){
            
            //判断该列上是否有障碍
            if(obstacleGrid[0][j] == 0){
           
                dp[0][j] = 1;
            }
            else{
                
                dp[0][j] = 0;
                break;
            }
        }
        
        for(int k = 1; k < m; k++){  
            
            for(int z = 1; z < n; z++){  
                
                if(obstacleGrid[k][z] == 0){  
                    
                    dp[k][z] = dp[k - 1][z] + dp[k][z - 1];  
                }
                else{  
                    
                    //如果当前网格的值为1（有障碍），那么到此网格的路径数归0
                    dp[k][z] = 0;  
                }  
            }  
        }     
        
        return dp[m - 1][n - 1];
    }
}