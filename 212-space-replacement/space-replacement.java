/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/space-replacement/
@Language: Java
@Datetime: 17-06-17 14:54
*/

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        
        //遍历
        for(int i = 0; i < length; i++){  
            
            if(string[i] == ' '){  
                
                //往后扩展三位
                for(int j = length + 2; j > i + 2; j--){ 
                    
                    string[j] = string[j-2];  
                }  
                string[i] = '%';  
                string[i + 1] = '2';  
                string[i + 2] = '0'; 
                
                length = length + 2;  
            }  
        }  
        return length; 
    }
}