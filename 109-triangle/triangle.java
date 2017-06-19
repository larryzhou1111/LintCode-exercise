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
        
        //从底往上，把每一行的元素，改为其下一行能与之相加的两个数，得到的和的最小值
        int row = triangle.length;
          
        if(row == 0){
            return 0;
        }
         
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
