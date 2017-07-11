/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/divide-two-integers/
@Language: Java
@Datetime: 17-7-11 22:00
*/

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        
        /*  两个整数相除
        
            将两个整数相除，要求不使用乘法、除法和 mod 运算符
            如果溢出，返回 2147483647 
            样例:给定被除数 = 100 ，除数 = 9，返回 11
        */
        
        /* 思路：
        
           使用2分法 + 位运算 ，不断对除数*2，直到它比被除数还大为止
           加倍的同时，也记录下cnt，将被除数减掉加倍后的值，并且结果+cnt
           
           需要注意边界条件！
        */
        
        long res = 0;  
        boolean minus = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0); 
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {  
            
            return Integer.MAX_VALUE;  
        } 
        
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor); 
        
        while (a >= b) {  
            
            int shift = 0; 
            
            while (a >= (b << shift)) {  
			
                shift++;  
            } 
            
            a -= (b << (shift - 1));  
            res += (1 << (shift - 1)); 
            
        }  
          
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE || divisor == 0) {  
            
            return Integer.MAX_VALUE;  
        } 
        
        return minus ? -(int)res : (int)res; 
            
    }
}