/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix/
@Language: Java
@Datetime: 17-06-21 14:54
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        //剑指offer题3
        
        /*  搜索二维矩阵: 写出一个高效的算法来搜索 m × n矩阵中的值
            
            这个矩阵具有以下特性：
                每行中的整数从左到右是排序的
                每行的第一个数大于上一行的最后一个整数

            样例: 考虑下列矩阵：
            [
              [1, 3, 5, 7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
            ]
            给出 target = 3，返回 true
        */
        if(matrix == null || matrix.length == 0)
            return false;
        
        //方法1：直接遍历，略
        
        //方法2：从右上角开始判断，小于target下移，大于target左移
      
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean flag = false;
        int i = 0;
        int j = col - 1;
        
        while(i < row && j >= 0){
            
            if(target == matrix[i][j]){
                
                flag = true;
                break;
            }
            
            //小于target则下移
            else if(target > matrix[i][j]){
                
                i++;
            }
            
            //大于target则左移
            else{
                
                j--;
            }
        }
        return flag;
        
        
        //方法3：利用二分查找，先求所在的行，再求所在的列. 边界容易弄错！
        /*
        //行的长度 nrow
        //列的长度 ncol        
        int nrow  = matrix.length;
        int ncol = matrix[0].length;
        
        //保存行的位置 row
        //保存列的位置 col        
        int row = rowbinSearch(matrix, 0, nrow - 1, ncol, target);
        int col = colbinSearch(matrix, 0, ncol - 1, row, target);
        
        if(col != -1)
            return true;
        return false;
    }
    
    //找出所在的行
    private int rowbinSearch(int[][] matrix, int left, int right, int ncol, int target){
        
        //矩阵matrix ，二分的两个界：left、right，矩阵的最后一列ncol,目标值target
        int median = (right - left) / 2 + left;
        int row = median;
        
        if(left == right)
            return left;
            
        if(matrix[left][ncol-1] <= target && matrix[left + 1][ncol - 1] > target)
            return left;
            
        if(matrix[median][ncol - 1] >= target && matrix[median][0] <= target)
            return median;
            
        if(matrix[median][ncol - 1] < target){
            
            row = rowbinSearch(matrix, median + 1, right, ncol, target);
        }
        else{
            
            row = rowbinSearch(matrix, left, median - 1, ncol, target);
        }
        return row;
    }
    
    //找出所在的列
    private int colbinSearch(int[][] matrix, int left, int right, int row, int target){
       
        //矩阵matrix ，二分的两个界：left、right，target所在的行：row,目标值target
        int median = (right - left) / 2 + left;
        int col = median;
        
        if(left > right)
            return -1;
            
        if(left == right && matrix[row][left] != target)
            return -1;
            
        if(matrix[row][median] == target)
            return median;
            
        if(matrix[row][median] < target){
            
            col = colbinSearch(matrix,median+1,right,row,target);
        }
        
        else{
            
            col = colbinSearch(matrix,left,median-1,row,target);
        }
        
        return col;
        */
    }
}