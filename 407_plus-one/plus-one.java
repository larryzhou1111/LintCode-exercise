/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/plus-one
@Language: Java
@Datetime: 17-06-13 14:40
*/

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        
        if(digits == null || digits.length == 0)
            return null;
        
        //每次加1
        int carry = 1;
        
        //首先直接在原数组上更改，并更新进位缓存区
        for(int i = digits.length - 1; i >= 0; i--){
            
            int digit = (digits[i] + carry) % 10;
            //设置进位
            carry = (digits[i] + carry) / 10;
            
            digits[i] = digit;
            
        }
        
        //全部更新后，进位缓存区不为零，则需开辟一块新的内存空间来存储新的数组
        if(carry != 0)  
        {  
            int[] temp = new int[digits.length + 1]; 
            
            temp[0] = carry;  
            
            for (int i = 1; i < temp.length; i++)  
            {  
                temp[i] = digits[i - 1];  
            }  
            return temp;  
        }
        //如果进位缓存区为零，则直接返回更新之后的数组就可以了
        else  
        {  
            return digits;  
        } 
    }
}