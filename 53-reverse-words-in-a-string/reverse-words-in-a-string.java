/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/reverse-words-in-a-string/
@Language: Java
@Datetime: 17-06-17 14:54
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        
        /* 翻转字符串: 给定一个字符串，逐个翻转字符串中的每个单词
        
        样例 ：给出s = “the sky is blue”，返回”blue is sky the”
        
        说明:
            单词的构成：无空格字母构成一个单词
            输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
            如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
        */
        
        //方法1：字符串按空格切割，保存到数组，然后倒序遍历
        
        if(s == null || s.length() == 0 || s.trim().length() == 0)  
            return s;        
        
        //先去掉字符串首尾的空格，再按空格分割
        String[] a = s.trim().split(" ");
        
        String result = "";
        
        for(int i = a.length - 1; i > -1; i--){
            
            if(i == 0){
                
                result = result + a[i];
            }
            else{
                
                result = result + a[i] + " ";
            }
        }
        return result;
        
        
        //方法2：遍历翻转两次
        /*
          1）第一趟遍历 : 将整个字符串完全翻转
          2）第二趟遍历 : 将每个单词翻转，且去掉连续空格中多余的空格（两端空格早已去掉） 
        */
        /*
        if(s == null || s.length() == 0 || s.trim().length() == 0) 
            return s;
        
        //先去掉字符串首尾的空格，再将其转为字符数组
        char[] chars = s.trim().toCharArray();
        
        //将整个字符串完全翻转
        reverse(chars, 0, chars.length - 1);
        
        int blank = -1;
        
        for(int i = 0; i < chars.length; i++){
            
            if(chars[i] == ' '){
                
                int nextBlank = i;
                
                reverse(chars, blank + 1, nextBlank - 1);
                
                blank = nextBlank;
            }
        }
        
        //最后一个单词单独进行反转
        reverse(chars, blank + 1, chars.length - 1);
        
        return new String(chars);
 
    }
    
    public void reverse(char[] chars,int low,int high){
     
        while(low < high){
            
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            
            low++;
            high--;
        }
    */   
    }
}