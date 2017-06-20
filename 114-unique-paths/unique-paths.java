/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/unique-paths/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        
        //方法1：数学公式法 C（(m+n-2)，(m-1)） = C（(m+n-2)，(n-1)）
        /*
          机器人一共要走m+n-2步, 从这m+n-2步中挑出m-1步向下走，或者挑出n-1步向右走
        */
        /*
        if(m == 1 || n == 1)
            return 1;
        
        //计算式m--; n--; 求C(m+n,n) = (m+n)!/(m!n!)
        m--;
        n--;
        
        long num = 1;
        
        for(int i = 1; i <= n; i++){
            
            num = num * (m + i) / i;
        }
        
        return (int)num;
        */
        
        
        //方法2：动态规划法 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 
        /*
          1	  1	  1	  1	  1	  1	  1
          1	  2	  3	  4   5	  6	  7
          1	  3	  6	  10  15  21  28
        */
        if(m == 0 || n == 0) 
            return 0;  
            
        int[][] dp = new int [m][n];
        
        for(int i = 0; i < m; i++){
            
            dp[i][0] = 1;  
        }
        
        for(int i = 0; i < n; i++){
            
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            
            for(int j = 1; j < n; j++){
                
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
            }  
        }        
        return dp[m - 1][n - 1];
    }
}
