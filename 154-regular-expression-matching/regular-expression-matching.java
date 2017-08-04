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
        if(s.length() == 0){
            
            return checkEmpty(p);
        }
  
        if(p.length() == 0)
            return false;
  
        char c1 = s.charAt(0);
        char d1 = p.charAt(0);
        char d2 = '0'; 
        
        if(p.length() > 1){
             
            d2 = p.charAt(1);
        }
        
        //从当前字符串的第0位开始匹配，若第1位是'*'
        if(d2 == '*'){
             
            if(compare(c1, d1)){
                
                //'*'可匹配0或者多个字符，因此匹配第1个字符时，有两种选择
                //字符串s向后移动一位，正则表达式字符串不变（'*'起了作用）
                //正则表达式字符串p向后移动2位（匹配0个字符，'*'被忽略，移动'*'及其前面的那个元素）
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else{
                
                //正则表达式字符串p向后移动2位（匹配0个字符，'*'被忽略）
                return isMatch(s, p.substring(2));
            }
        }
        
        else{
            if(compare(c1, d1)){
                
                //匹配则同时向后移动1位 
                return isMatch(s.substring(1), p.substring(1));
            }
            else
                return false;
        }
    }
     
    public boolean compare(char c1, char d1){
         
        return d1 == '.' || c1 == d1;
    }
  
    //字符串s为空时
    public boolean checkEmpty(String p){
        
        //正则表达式字符串p的长度必须是偶数
        if(p.length() % 2 != 0) 
             return false;  
        
        //奇数位置必须是'*'，即偶数位置先出现一个任意字符，奇数位置的'*'可将其抵消掉
        for(int i = 1; i < p.length(); i += 2){
            
            if(p.charAt(i) != '*') 
                return false;
        }
         
        return true;        
    }
}