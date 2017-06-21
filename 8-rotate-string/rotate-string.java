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
        
        /*
        //方法1：在原地旋转，旋转三次可以达到效果，需回顾！
        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;
        
        //注意旋转三次各自的偏移量
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end){
        
        for(int i = start, j = end; i < j; i++, j--){
            //交换
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        */
        
		//方法2：与上述方法类似
        if(str == null || str.length == 0) 
            return;
            
        offset = offset % str.length;
        
        for(int i  = 0; i < str.length / 2; i++){
            
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
    }
}