/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/rotate-string/
@Language: Java
@Datetime: 17-06-17 14:54
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here

		//类似剑指offer题42-2
		        
        /* 旋转字符串 （右旋）(类比剑指offer题42-2,左旋)
        
            给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
            
            样例：对于字符串 "abcdefg".

                offset=0 => "abcdefg"
                offset=1 => "gabcdef"
                offset=2 => "fgabcde"
                offset=3 => "efgabcd"
        */
        
        //方法1：在偏移点处将字符串切割，然后倒序拼接。代码略
        //str.substring(start, end)求子字符串，包括start，不包括end
        
        //方法2：原地旋转三次，可以达到效果 
        if(str == null || str.length == 0 || offset < 0)
            return;

        offset = offset % str.length;

        //偏移点的前半部分，旋转
        reverse(str, 0, str.length - offset - 1);
        
        //偏移点的后半部分，旋转
        reverse(str, str.length - offset, str.length - 1);
        
        //整个字符串旋转
        reverse(str, 0, str.length - 1);
        
    }

    private void reverse(char[] str, int start, int end){
        
        while(start < end){
  
            //交换
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            
            start++;
            end--;
        }
         
        /*
        if(str == null || str.length == 0 || offset < 0) 
            return;
            
        offset = offset % str.length;
        
        for(int i = 0; i < str.length / 2; i++){
            
            //整个字符串翻转
            char c = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = c;
        }
        
        for(int i = 0; i < offset / 2; i++) {
            
            //offset部分翻转
            char c = str[i];
            str[i] = str[offset - 1 - i];
            str[offset - 1 - i] = c;
        }
        
        for(int i = 0; i < (str.length - offset + 1) / 2; i++){
            
            //剩余部分翻转
            char c = str[offset + i];
            str[offset + i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = c;
        }
        */
    }
}