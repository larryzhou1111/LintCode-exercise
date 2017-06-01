/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 17-06-01 07:17
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        
        //若字符串a的长度小于字符串b的长度，两个字符串交换  
        if(a.length() < b.length()){  
            String temp = a;  
            a = b;  
            b = temp;  
        }  
        
        int la = a.length() - 1;  
        int lb = b.length() - 1;  
        //进位
        int carry = 0;
        //结果值
        String result = "";  
        
        while(lb >= 0){
            //先依据短字符串的长度依次计算
            
            //a.charAt(la)-'0'：将字符转成数字
            int sum = (int)(a.charAt(la)-'0') + (int)(b.charAt(lb)-'0') + carry;  
            result = String.valueOf(sum%2) + result;  
            carry =sum / 2;  
            la--;  
            lb--;  
        }  
        while(la >= 0){
            //再依据长字符串的长度依次计算  
            int sum = (int)(a.charAt(la)-'0') + carry;  
            result = String.valueOf(sum % 2) + result;  
            carry =sum / 2;  
            la--;  
        }  
          
        if (carry == 1){  
            //计算最后的进位 
            result = "1" + result; 
        }  
        return result; 
    }    
}