/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/spiral-matrix-ii/
@Language: Java
@Datetime: 17-07-19 16:00
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here

        /* 螺旋矩阵II :给你一个数n生成一个包含1-n^2的螺旋形矩阵
            
            样例 n = 3，矩阵为
            [
              [ 1, 2, 3 ],
              [ 8, 9, 4 ],
              [ 7, 6, 5 ]
            ]
        */
        
        //类比题374，思路基本一样
        
        if(n < 0)
            return null;
        
        int[][] matrix = new int[n][n];
        
        if(n == 0)
            return matrix;
        
        int count = 0;
        int num = 1;
        
        //循环条件：最后一圈左上角的坐标，乘以2之后，仍然小于行数和列数
        while(count * 2 < n){
            
            //从左到右，赋值一行
            for(int i = count; i < n - count; i++){
                
                matrix[count][i] = num++;
            }
            
            //从上到下，赋值一列，起始条件：终止行号大于起始行号
            if(count < n - count - 1){
                
                for(int i = count + 1; i < n - count; i++){
                    
                    matrix[i][n - count - 1] = num++;
                }
            }
            
            //从右到左，赋值一行，起始条件：终止行号大于起始行号，且终止列号大于起始列号 
            if(count < n - count - 1){
                
                for(int i = n - count - 2; i >= count; i--){
                    
                    matrix[n - count - 1][i] = num++;
                }
            }
            
            //从下到上，赋值一列
            //前提条件：至少有3行2列，终止行号比起始行号至少大2，且终止列号大于起始列号 
            if(count < n - count - 2){
                
                for(int i = n - count - 2; i >= count + 1; i--){
                    
                     matrix[i][count] = num++;
                }
            }
            
            count++;
        }
        
        return matrix;        
        
    }
}