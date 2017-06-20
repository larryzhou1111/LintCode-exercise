/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/longest-palindrome/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        
        /*
          回文串，左右对称，除了中心的那个位置的字符可以出现奇数次以外，都要出现偶数次
          
          1、统计所有字母的出现频率（分大小写） 
          2、统计只出现奇数次数字母的个数 
          3、如果2中结果不为0，字符串的长度减去2中的字母个数+1

          其中3的意思是，保留出现次数最多的那个奇数字母，剩下的需要全部减1变成偶数去构造
        */

        if(s == null)
            return 0;
        
        //字符串转换为字符数组
        char[] chars = s.toCharArray();
        
        int lowerCount[] = new int[26];
        int upperCount[] = new int[26];
        
        int odds = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(chars[i] < 'a'){ 
                
                upperCount[chars[i] - 'A']++;
            }
            
            else{ 
                
                lowerCount[chars[i] - 'a']++;
            }
        }
        
        for(int i = 0; i < 26; i++){
            
            //统计只出现奇数次的字母的个数
            if(lowerCount[i] % 2 == 1){ 
               
                odds++;
            }
            
            //统计只出现奇数次的字母的个数
            if(upperCount[i] % 2 == 1){ 
               
                odds++;
            }
        }
        
        if(odds == 0)
            return s.length();
        else 
            return s.length() - odds + 1;

    }
}