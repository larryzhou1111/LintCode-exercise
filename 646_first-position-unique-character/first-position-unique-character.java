/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/first-position-unique-character
@Language: Java
@Datetime: 17-06-05 11:32
*/

public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        // Write your code here

        if(s == null)  
            return -1;  
            
        /*
           统计每个字符在该字符串中出现的次数
           需要一个数据容器来存储每个字符在字符串中出现的次数，
           这个数据可以根据字符来查找出现的次数，
           即这个容器的作用是把一个字符映射成一个数字
           在常用的的数据容器中，哈希表正是这个用途
        */
        
        //总共有256个字符
        //扫描两次字符串.第一趟给所有字母计数,第二趟找第一个次数为1的字母
        int[] hash = new int[256];  

        for(int i=0;i<s.length();i++){ 
            
            char temp = s.charAt(i);  
            hash[temp]++;  
        }  
 
        for(int i=0;i<s.length();i++){  
            
            char temp = s.charAt(i); 
            
            if(hash[temp] == 1)  
                return i;  
        }  
        
        return -1;
    }
}