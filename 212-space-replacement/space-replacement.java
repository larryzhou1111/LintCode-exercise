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
        
		//剑指offer题4
		
        /* 空格替换 
        
        设计一种方法，将一个字符串中的所有空格替换成 %20 
        你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度
        你的程序还需要返回被替换后的字符串的长度
        
        注意事项:
        如果使用 Java 或 Python, 程序中请用字符数组表示字符串
        
        样例:
        对于字符串"Mr John Smith", 长度为 13
        替换空格之后，参数中的字符串需要变为"Mr%20John%20Smith"，并且把新长度 17 作为结果返回
        */
        
        //写法1：效率低，重复移动太多
        /*
        if(string == null || length <= 0) 
            return 0;
            
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
        */
        
        //写法2：(剑指offer题4) 时间复杂度O(n)
        /*
         先遍历一遍字符串，统计字符串中空格的个数，从而求出新的字符数组的长度，
         从后开始遍历，遇到空格就将其替换为%20
         从后向前遍历是因为其时间效率比从前往后遍历要高
        （从前往后遍历遇到空格时，需要将空格后面，所有的字符向后移动2个位置，而从后向前则不需要）
        */
        if(string == null || length <= 0) 
            return 0;        
        
        int space = 0;  
        for(int i = 0; i < length; i++){ 
            
            if(string[i] == ' '){
                
                space++;
            } 
        }  
        
        int newLength = length + space * 2;  
        int index = newLength;  
        
        //从后向前遍历
        for(int i = length - 1; i >= 0; i--){  
            
            if(string[i] == ' '){  
                
                string[--index] = '0';  
                string[--index] = '2';  
                string[--index] = '%';  
            }  
            else{
                
                string[--index] = string[i]; 
            }    
        } 
        
        return newLength; 
    }
}