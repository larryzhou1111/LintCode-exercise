/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/regular-expression-matching/
@Language: Java
@Datetime: 17-08-3 22:00
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        
        //剑指offer题53
        
        /* 正则表达式匹配: 实现支持'.'和'*'的正则表达式匹配

            '.'匹配任意一个字母；'*'匹配零个或者多个前面的元素。
            
            匹配应该覆盖整个输入字符串，而不仅仅是一部分
            需要实现的函数是：bool isMatch(const char *s, const char *p)
            
            样例
                isMatch("aa","a") → false
                isMatch("aa","aa") → true
                isMatch("aaa","aa") → false
                isMatch("aa", "a*") → true
                isMatch("aa", ".*") → true
                isMatch("ab", ".*") → true
                isMatch("aab", "c*a*b") → true
        */
        int i = 0, j = 0;
  
        if(s.length() == 0){
            
            return checkEmpty(p);
        }
  
        if(p.length() == 0)
            return false;
  
        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; 
  
        if(p.length() > 1){
             
            d2 = p.charAt(1);
        }
  
        if(d2 == '*'){
             
            if(compare(c1, d1)){

                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else{
                 
                return isMatch(s, p.substring(2));
            }
        }
        else{
            if(compare(c1, d1)){
                 
                return isMatch(s.substring(1), p.substring(1));
            }
            else
                return false;
        }
    }
     
    public boolean compare(char c1, char d1){
         
        return d1 == '.' || c1 == d1;
    }
  
    public boolean checkEmpty(String p){
        
        if(p.length() % 2 != 0) 
             return false;  
  
        for(int i = 1; i < p.length(); i += 2){
            
            if(p.charAt(i) != '*') 
                return false;
        }
         
        return true;        
    }
}