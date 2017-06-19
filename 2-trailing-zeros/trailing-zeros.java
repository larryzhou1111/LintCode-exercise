/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/trailing-zeros/
@Language: Java
@Datetime: 17-06-19 19:54
*/

class Solution {
    /*
     * param n: An desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        
        /*
           两个数x和y(0<x,y<10)相乘得到的结果含有0，那么x和y必然一个取2，一个取5
           则n可以表示为: 2的p次方 乘以5的q次方 再乘以r的s次方 (0<r<10，且r不等于2和5)
           由于能被2整除的数远大于能被5整除的数，则q即为我们要找的0的个数
        */
        
        long ret = 0; 
       
        while(n != 0){ 
            
            ret += n /5;  
            n /= 5;  
        }  
        return ret;   
    }
};
