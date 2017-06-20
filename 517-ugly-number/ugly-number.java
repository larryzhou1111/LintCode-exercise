/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/ugly-number/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        
        //用2、3、5不断整除n，当n不能再被2、3、5整除时，判断n是否等于1
        //等于1则指定的数字是丑数
        
        if(num <= 0) 
            return false;  
            
        if(num == 1)
            return true;
            
        while(num % 2 == 0)
            num /= 2;
            
        while(num % 3 == 0) 
            num /= 3;
            
        while(num % 5 == 0) 
            num /= 5;
        
        if(num == 1) 
            return true;
        else 
            return false;

    }
}