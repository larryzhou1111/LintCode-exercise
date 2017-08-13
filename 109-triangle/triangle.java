/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/triangle/
@Language: Java
@Datetime: 17-06-19 19:54
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        //动态规划问题： 类比题110
        
        /*  数字三角形
        
            给定一个数字三角形，找到从顶部到底部的最小路径和
            每一步可以移动到下面一行的相邻数字上

            注意事项:
                如果你只用额外空间复杂度O(n)的条件下完成,可以获得加分
                其中n是数字三角形的总行数
            
            样例:
                比如，给出下列数字三角形：
                [
                     [2],
                    [3,4],
                   [6,5,7],
                  [4,1,8,3]
                ]
                从顶到底部的最小路径和为11 (2 + 3 + 5 + 1 = 11)
        */
        
        //从底往上，把每一行的元素，改为其下一行能与之相加的两个数，得到的和的最小值
        
        if(triangle == null || triangle.length == 0)
            return 0;
            
        int row = triangle.length; 
        
        if(row == 1){
            
            return triangle[0][0];
        }
          
        for(int i = row - 2; i >= 0; i--){
            
            for(int j = 0; j < triangle[i].length; j++){
                
                int min = Math.min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j];
                
                triangle[i][j] = min;
            }
        }
          
        return triangle[0][0];
    }
}