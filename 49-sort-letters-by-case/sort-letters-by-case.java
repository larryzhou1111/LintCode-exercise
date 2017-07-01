/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/sort-letters-by-case/
@Language: Java
@Datetime: 17-7-1 11:00
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        
        /* 字符大小写排序:
        
           给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序
           注意事项:小写字母或者大写字母他们之间,不一定要保持在原始字符串中的相对位置
           给出"abAcD"，一个可能的答案为"acbAD"
        */
        
        //类比题31：数组划分
        
        /*  思路：双指针法
        
            规定两根指针start和end分别指向数组的首尾，分别向后，向前遍历
    	    若chars[start] 是大写 且 chars[end] 是小写，则交换这两个字符
    	    
    	    而最终start的值即为i的位置
        */
        if(chars == null || chars.length == 0)
            return;
            
        int start = 0;
	    int end = chars.length - 1;
	    char temp = 0;
	    
	    while(end - start >= 0){
	        
	        if(chars[start] >= 'A' && chars[start] <= 'Z'){
	            
	            if(chars[end] >= 'a' && chars[end] <= 'z'){
	                
	                //交换
	                temp = chars[start];
	                chars[start] = chars[end];
	                chars[end] = temp;
	            }
	            
	            else{
	                end--;
	            }
	        }
	        
	        else{
	            start++;
	        }
	    }
        
    }
}
