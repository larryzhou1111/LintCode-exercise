/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/powx-n/
@Language: Java
@Datetime: 17-07-17 16:00
*/

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        
        /* x的n次幂: 实现 pow(x,n)

            注意事项:
            不用担心精度，当答案和标准输出差绝对值小于1e-3时都算正确
            
            样例:
            Pow(2.1, 3) = 9.261
            Pow(0, 1) = 0
            Pow(1, 0) = 1
        */
        
        //剑指offer题11
        
        if(n == 0)
            return 1;
        
        if(n == 1)
            return x;
            
        if(n == -1)
            return 1 / x;
        
		//位运算，比乘除法、求余效率更高，右移一位相当于除以2
        double result = myPow(x, n >> 1);
        
        result *= result;
        
		//与0x01，相当于对2取余
        if((n & 0x01) == 1){
            
            result *= x;
        }
        
        return result;
    }
}