/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix-ii/
@Language: Java
@Datetime: 17-06-21 18:54
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        //类比题28
        
        //思路：从左下角到右上角开始搜索，每次判断大小，向上一行或者右一列移动
        
        if(matrix == null || matrix.length == 0)
            return 0;
            
        int row = matrix.length;
        int col = matrix[0].length;
        
        int count = 0;
        int i = row - 1;
        int j = 0;
        
        while(i >= 0 && j < col){
            
            if(target == matrix[i][j]){
                               
                count++;
                i--; 
                j++;
            }
            
            //小于target则右移
            else if(target > matrix[i][j]){
                
                j++;
            }
            
            //大于target则上移
            else{
                
                i--;
            }
        }
        return count;
        
    }
}
