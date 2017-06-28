/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/interleaving-string/
@Language: Java
@Datetime: 17-06-28 20:00
*/

public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        //动态规划：用二维数组保存相关信息
        
        /*
          interleaved[i][j] 代表s1中前i个字符，与s2中前j个字母，
          是否可以交叉匹配成为，s3中前i+j个字符
        */
        
        if(s1.length() + s2.length() != s3.length())
            return false;
            
        boolean[][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        
        //初始条件为true. 即s1前0个字符加s2前0个字符，可以拼凑成s3前0个字符
        interleaved[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++){
            
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0]){
               
                interleaved[i][0] = true;
            }
        } 
        
        for(int j = 1; j <= s2.length(); j++){
            
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1]){
                
                interleaved[0][j] = true;
            }    
        }        
        
        for(int i = 1; i <= s1.length(); i++){
            
            for(int j = 1; j <= s2.length(); j++){
                
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1])){
                        
                    interleaved[i][j] = true;
                }
            }
        }
        
        return interleaved[s1.length()][s2.length()];        
        
        
        //此方法只能部分通过，需进一步分析
        /*
        if(s1.length() == 0){
            
            if(s2.equals(s3)) 
                return true;
            else 
                return false;
        }
        
        if(s2.length() == 0){
            
            if(s1.equals(s3)) 
                return true;
            else 
                return false;
        }
        
        int j = 0, k = 0;
        
        for(int i = 0; i < s3.length(); i++){
            
            if(s3.charAt(i) == s1.charAt(j) && s3.charAt(i) == s2.charAt(k)){
                
                j++;
            }
            
            else if(s3.charAt(i) == s1.charAt(j) && s3.charAt(i) != s2.charAt(k)){
                
                j++;
            }
            
            else if(s3.charAt(i) != s1.charAt(j) && s3.charAt(i) == s2.charAt(k)){
                
                k++;
            }            
            
            else 
                return false;
                
        }
        
        if(j == s1.length() - 1 && k == s2.length() - 1)
            return true;
        else
            return false;
            
        */
    }
};