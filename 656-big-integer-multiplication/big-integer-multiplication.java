/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/big-integer-multiplication/
@Language: Java
@Datetime: 17-08-15 22:00
*/

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // Write your code here
        
        /*  大整数乘法
            给定两个非负整数num1 和 num2表示为字符串，返回num1和num2的乘积
            
            样例：
                num1 和 num2 的长度小于110
                num1 和 num2 都只包含数字0-9
                num1 和 num2 都不包含任何前导零
                您不得使用任何内置的 BigInteger 库或直接将输入转换为整数
        */
        
        //使用数组对每一位的运算结果进行记录
        if(num1.equals("0") || num2.equals("0"))
            return "0";  
          
        int len1 = num1.length();  
        int len2 = num2.length();  
        
        char[] result = new char[len1 + len2];  
        
        for(int i = 0; i < result.length; i++){  
            
            result[i] = '0';  
        }  
          
        for(int i = len1 - 1; i >= 0; i--){  
            
            int p = 0;  
            
            for(int j = len2 - 1; j >= 0; j--){ 
                
                int temp = (result[i + j + 1] - '0') + 
                             (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + p;  
                p = temp / 10;  
                
                result[i + j + 1] = (char)(temp % 10 + '0');  
            } 
            
            result[i] += p;  
        }  
          
        String res = "";  
        int count = 0;  
        
        for(; count < result.length; count++){  
            
            if(result[count] != '0'){  
                break;  
            }  
        }  
        
        for(int i = count; i < result.length; i++){
            
            res += result[i];  
        }  
        
        return res; 
    }
}