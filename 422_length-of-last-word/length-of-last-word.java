/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/length-of-last-word
@Language: Java
@Datetime: 17-06-10 13:38
*/

public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here

        //方法1：字符串切割函数
        String[] words = s.split(" ");
        //数组的长度不带括号
        int len = words.length;
        
        if(len == 0){
            return 0;
        }
        else{
            String word = words[len - 1];
            //字符串的长度要带括号
            int len1 = word.length();
            return len1;
        }

        /*
        //方法2：从数组末尾开始遍历，遇到第一个空格即返回长度
        int length = 0;
        char[] chars = s.toCharArray();
        
        for(int i = s.length() - 1; i >= 0; i--) {
            
            if(length == 0) {
                
                if(chars[i] == ' ') {
                    continue;
                }
                else{
                    length++;
                }
            } 
            else {
                
                if(chars[i] == ' ') {
                    break;
                } 
                else{
                    length++;
                }
            }
        }
        return length;
        */
    }
}