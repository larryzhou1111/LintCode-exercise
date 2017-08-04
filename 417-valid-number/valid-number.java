/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/valid-number/
@Language: Java
@Datetime: 17-08-4 21:00
*/

public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        
        //剑指offer题54
        
        /*  有效数字：给定一个字符串，验证其是否为数字
            
            样例：
                "0"    =>  true
                "0.1"  =>  true
                "abc"  =>  false
                "1 a"  =>  false
                "2e10" =>  true
        */
        
        /*
            表示数值的字符串遵循如下模式：
            [sign]integral-digits[.[fractional-digits]][e|E[sign]exponential-digits]
            ('[' 和 ']'之间的部分，可有可无)
            
            数值字符串开头，可能是一个表示正负的‘+’或者‘-’
            接下来是若干个0到9的数，表示数值的整数部分（小数里可能没有数值的整数部分）
            
            若是小数，则有'.'，小数点后可能有若干个0到9的数，表示数值的小数部分
            小数点前一位不能出现小数点，不能出现指数
            
            若是数值用科学计数法表示，则有'e'或'E'，以及紧跟着的整数（可以有正负）表示指数
            该'e'或'E'的前一位，必须是数字
            
            字符串中间出现的符号位，其前一位必须是指数
        */
        if(s == null || s.length() == 0 || s.trim().length() == 0)
            return false;
        
        s = s.trim();    
        int len = s.length();
        int i = 0;
        
        //跳过起始位置的符号位
        if(s.charAt(i) == '+' || s.charAt(i) == '-') 
            i++;
        
        //是否是数字
        boolean num = false; 
        
        //是否是小数点 '.'
        boolean dot = false; 
        
        //是否是指数 'e' 或 'E'
        boolean exp = false; 
        
        while(i < len){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                num = true;
            }
            
            else if(c == '.'){
                
                //如果当前已判定是指数或者小数，再出现小数点，则为false
                if(exp || dot) 
                    return false;
                
                //设置当前位是小数    
                dot = true;
            }
 
            else if(c == 'e' || c == 'E'){
                
                //如果当前已判定前一位是表示指数，或者前一位不是数字
                if(exp || num == false) 
                    return false;
                
                //设置当前位是指数，不是数字    
                exp = true;
                num = false;
            }
            
            else if(c == '+' || c == '-'){
                
                //字符串中间出现'+'或'-'，则其前一个字符必须是表示指数的'e'或'E'
                if(s.charAt(i - 1) != 'e' & s.charAt(i - 1) != 'E')
                    return false;
                    
            }
            else{
                return false;
            }
            
            i++;
        }
        
        return num;    
    }
}