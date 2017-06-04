/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/big-integer-addition
@Language: Java
@Datetime: 17-06-04 11:30
*/

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here

        //类比题408：二进制求和。此题相当于十进制字符串求和！
        
        //若字符串a的长度小于字符串b的长度，两个字符串交换  
        if(num1.length() < num2.length()){  
            
            String temp = num1;  
            num1 = num2;  
            num2 = temp;  
        }  
        
        int len1 = num1.length() - 1;  
        int len2 = num2.length() - 1;  
        //进位
        int carry = 0;
        //结果值
        String result = "";  
        
        while(len2 >= 0){
            //先依据短字符串的长度依次计算
            
            //num1.charAt(len1)-'0'：将字符转成数字
            int sum = (int)(num1.charAt(len1)-'0') + 
                                       (int)(num2.charAt(len2)-'0') + carry;  
            result = String.valueOf(sum % 10) + result;  
            carry = sum / 10;  
            len1--;  
            len2--;  
        }  
        while(len1 >= 0){
            //再依据长字符串的长度依次计算  
            int sum = (int)(num1.charAt(len1)-'0') + carry;  
            result = String.valueOf(sum % 10) + result;  
            carry = sum / 10;  
            len1--;  
        }  
          
        if (carry == 1){  
            //计算最后的进位 
            result = "1" + result; 
        }  
        return result; 
    }
}