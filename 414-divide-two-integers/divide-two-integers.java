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
           
           任何一个整数可以表示成以2的幂为底的一组基的线性组合，
           即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
           
           基于以上公式，以及左移一位相当于乘以2，
           我们先让除数左移，直到大于被除数之前，得到一个最大的基
           然后接下来我们每次尝试减去这个基，
           如果可以，则结果增加加2^k，然后基继续右移迭代，直到基为0为止
        */
        
        //写法1：
        /*
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
        */
        
        //写法2：
        if(divisor == 0) 
            return Integer.MAX_VALUE;
            
        if(divisor == 1) 
            return dividend;
            
        if(dividend == 0) 
            return 0;          
            
        long a = dividend, b = divisor; 
        long res = divideHelper(Math.abs(a), Math.abs(b));
        
        if((a > 0 && b < 0) || (a < 0 &&  b > 0)){
            
            res = -res; 
        } 
        
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
           
            return Integer.MAX_VALUE;
        }     
        else{
            return (int)res;             
        } 
        
    }
       
    public long divideHelper(long a, long b){
        
        if(a == b) 
            return 1;
            
        if(a < b) 
            return 0;  
            
        long c = b;
        long n = 1;
        
        while(a >= c){  
            
            // 让除数左移，直到大于被除数之前得到一个最大的数，左移一位相当于乘以2
            c = c<<1;          
            n = n<<1;          
        }
        
        // a减去c(b)小于a的最大一个数，然后迭代，要加上（n>>1）表示左移了n次，即乘了2的几次方
        // a= 100, b=3, while循环后c=3*2^6=192, n=2*6=64, return的时候要除以2（右移一位）得到小于a的最大的数32，然后再迭代
        return (n>>1) + divideHelper(a - (c>>1), b);  
   
    }
}