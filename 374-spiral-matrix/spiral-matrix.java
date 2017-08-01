/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/spiral-matrix/
@Language: Java
@Datetime: 17-07-19 16:00
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
		
		//剑指offer题20
        
        /* 螺旋矩阵
        
        给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素
       
            样例:给定如下矩阵：
            [
             [ 1, 2, 3 ],
             [ 4, 5, 6 ],
             [ 7, 8, 9 ]
            ]
            
            应返回 [1,2,3,6,9,8,7,4,5]
        */
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0) 
            return result;
        
        //行数
        int rows = matrix.length;
        //列数
        int cols = matrix[0].length;
        int count = 0;
        
        //循环条件：最后一圈左上角的坐标，乘以2之后，仍然小于行数和列数
        while(count * 2 < rows && count * 2 < cols){
            
            //从左到右，打印一行
            for(int i = count; i < cols - count; i++){
                
                result.add(matrix[count][i]);
            }
            
            //从上到下，打印一列，起始条件：终止行号大于起始行号
            if(count < rows - count - 1){
                
                for(int i = count + 1; i < rows - count; i++){
                    
                    result.add(matrix[i][cols - count - 1]);
                }
            }
            
            //从右到左，打印一行，起始条件：终止行号大于起始行号，且终止列号大于起始列号 
            if(count < rows - count - 1 && count < cols - count - 1){
                
                for(int i = cols - count - 2; i >= count; i--){
                    
                    result.add(matrix[rows - count - 1][i]);
                }
            }
            
            //从下到上，打印一列
            //前提条件：至少有3行2列，终止行号比起始行号至少大2，且终止列号大于起始列号 
            if(count < rows - count - 2 && count < cols - count - 1){
                
                for(int i = rows - count - 2; i >= count + 1; i--){
                    
                     result.add(matrix[i][count]);
                }
            }
            
            count++;
        }
        
        return result;
        
    }
}