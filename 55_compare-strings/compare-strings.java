/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 17-06-04 13:16
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        
        //思路1：A和B中的字符都是大写字母，分别统计A和B中各个字母的个数，再比较。

        if(B.length() > A.length())
            return false;
            
        int [] LetterNum_A = new int[26];
        int [] LetterNum_B = new int[26]; 
        
        //遍历A和B，统计其中各个字母出现的次数
        for(int i=0;i<A.length();i++){
            
            LetterNum_A[A.charAt(i) - 'A']++;
        }
        
        for(int i=0;i<B.length();i++){
            
            LetterNum_B[B.charAt(i) - 'A']++;
            
            if(LetterNum_B[B.charAt(i) - 'A'] > LetterNum_A[A.charAt(i) - 'A'])
                return false;
                
        }
        return true;
        
        //思路2：循环遍历
        /* 设置标志位，针对B中每个字母，依次与A中字母进行比较
           若存在，标志位置为true，继续比较下一个字母
           效率低，代码略
        */
    }
}