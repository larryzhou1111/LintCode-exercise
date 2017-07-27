/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/string-to-integer-ii/
@Language: Java
@Datetime: 17-07-27 22:00
*/

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write you ode here
        
        /* 转换字符串到整数（剑指offer题49）
        
            实现atoi这个函数，将一个字符串转换为整数
            如果没有合法的整数，返回0
            如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，
            或者INT_MIN(-2147483648)如果是负整数
        
            样例
                "10" => 10     "-1" => -1
                "123123123123123" => 2147483647    "1.0" => 1
        */
        if(str == null) 
            return 0;
        
        //去掉首尾空格  
        str = str.trim();
        
        //全为空格  
        if(str.length() == 0)
            return 0;
              
        int sign = 1;
        int index = 0;
      
        if(str.charAt(index) == '+'){
            
            index++;
        } 
        else if(str.charAt(index) == '-'){
            
            sign = -1;
            index++;
        }
        
        long num = 0;
        for(; index < str.length(); index++){
            
            if(str.charAt(index) < '0' || str.charAt(index) > '9'){
                    
                break;
            }
                    
            num = num * 10 + (str.charAt(index) - '0');
            
            if(num > Integer.MAX_VALUE ){
                
                break;
            }
        }  
        
        if(num * sign >= Integer.MAX_VALUE){
            
            return Integer.MAX_VALUE;
        }
        
        if(num * sign <= Integer.MIN_VALUE){
            
            return Integer.MIN_VALUE;
        }
        
        return (int)num * sign;
    }
}