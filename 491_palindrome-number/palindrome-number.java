/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/palindrome-number
@Language: Java
@Datetime: 17-06-12 15:32
*/

public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        // Write your code here
   
        //方法1：转换成字符串
        if(num <= 0)  
            return false;
        
        //整数 int 转换成字符串 String，以下三种方法：
        //String str = Integer.toString(num); 
        //String str = String.valueOf(num);
        String str = "" + num; 
        return palindromeNumber(str);
    }        
        
    public boolean palindromeNumber(String str) {
        
        int begin = 0;
        int end = str.length()-1; 
        
        while(begin < end && begin >= 0 && end >= 0){  
            
            if(str.charAt(begin) == str.charAt(end)){
                
                begin++;  
                end--;  
            }
            else 
                return false;  
        }  
        return true;         
    }    
   
        //方法2：整数翻转，再与原数进行比较
        /*
        if(num < 0)  
            return false;  
          
        int tmp = num, res = 0;  
        
        while(tmp != 0)  
        {  
            res = res * 10 + tmp % 10;  
            tmp = tmp / 10;  
        }  
        return num == res;        
        */
    
    /*    
        //方法3：逐位判断，每次取位上的单个数字进行比较
        //首先确定数值的位数n，然后依次比较（n,1）,（n-1,2）
        //负数  
        if(num < 0)  
            return false;  
          
        int len = 1;  
        
        while(num / len >= 10){  
            
            //获取位数
            len *= 10;    
        }  
          
        while(num > 0){  
            
            //获取首尾值大小  
            //第一个除位数
            int left = num / len;
            //最后一个 
            int right = num % 10;    
               
            if(left != right)  
                return false;  
            else      
            {  
                //相等删除首尾  
                num = (num % len) / 10;  
                len /= 100;  
            }  
        }  
        return true;         
    } 
    */
}