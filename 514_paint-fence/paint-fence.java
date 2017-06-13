/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Java
@Datetime: 17-06-12 12:41
*/

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        
        //动态规划问题: 应该表述为:不能有连续三个柱子颜色相同
        /*
          状态转移方程为：
          buff[i] = buff[i-1] * (k-1) + buff[i-2] * (k-1);
                  = (buff[i-1] + buff[i-2]) * (k-1)
          初始条件： 
          buff[1] = k; buff[2] = k*k;
        */
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        if(n == 2)
            return k*k;
            
        int w1 = k;
        int w2 = k*k;
        
        for(int i = 3; i<= n; i++){
            
            int temp = w2;
            w2 = (w2 + w1) * (k-1);
            w1 = temp;
        }
        return w2;
    }
}