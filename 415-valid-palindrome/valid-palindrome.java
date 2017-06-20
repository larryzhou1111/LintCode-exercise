/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/valid-palindrome/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        
        //类比题491回文数，但注意：本题忽略字母大小写
        
        if(s == null)
            return true;
        
        //将字符串s中字符，全部转换成小写
        s = s.toLowerCase();
            
        int begin = 0;
        int end = s.length()-1; 
        
        while(begin < end){  
            
            while(begin < s.length() && !isCharorNum(s.charAt(begin))){  
                
                begin++;  
            } 
            
            if(begin == s.length())
                return true;
                            
            while(end >= 0 && !isCharorNum(s.charAt(end))){  
               
                end--;  
            }  

            if(Character.toLowerCase(s.charAt(begin)) == Character.toLowerCase(s.charAt(end))){
                
                end--;
                begin++;
            }
            else{
                break;
            }
        }

        if(end <= begin)
            return true;
        else
            return false;
            
    }
    
    //判断字符串中字符是否是字母或者数字
    public boolean isCharorNum(char ch){
        /*
        if((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')||(ch >= '0' && ch <= '9'))  
            return true;  
        else
            return false; 
        */
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}