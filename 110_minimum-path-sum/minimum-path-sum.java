/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 17-06-11 14:20
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        /*
          动态规划
             达到右下角只有两种可能: 一种是通过向下走到右下角，一种是通过向右走到右下角
             那么到达右下角的最小代价，就是这两种情况下的相对小的那个,加上右下角这一步的代价
           f(i,j) = MIN(f(i-1,j),f(i,j-1)) + grid(i,j)
        */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        
        int[][] sum = new int[M][N];   

        sum[0][0] = grid[0][0];

        for(int i = 1; i < M; i++){   
            // 初始化第一列
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for(int i = 1; i < N; i++){   
            // 初始化第一行
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < M; i++){
           
            for(int j = 1; j < N; j++){
                
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];        
    }
}
