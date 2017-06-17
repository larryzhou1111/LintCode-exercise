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
        
        //思路：字符串按空格切割，保存到数组，然后倒序遍历
        String[] a = s.split(" ");
        
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
    }
}
