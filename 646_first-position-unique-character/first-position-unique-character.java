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

        //类似剑指offer题55（找出字符流中第一个只出现一次的字符）
        
        //方法1：    
        /*
           统计每个字符在该字符串中出现的次数
           用HashMap来存储每个字符在字符串中出现的次数，最后再查找次数为1的字符
        */
        if(s == null || s.length() == 0)
             return -1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(map.containsKey(s.charAt(i))){
                
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
         
        for(int i = 0; i < s.length(); i++){
             
            if(map.get(s.charAt(i)) == 1){
                
                return i;
            }
        }
        
        return -1;        
        
        //方法2：
        //总共有256个字符
        //扫描两次字符串.第一趟给所有字母计数,第二趟找第一个次数为1的字母
        /*
        if(s == null || s.length() == 0)  
            return -1;  
            
        int[] hash = new int[256];  

        for(int i = 0; i < s.length(); i++){ 
            
            char temp = s.charAt(i);  
            hash[temp]++;  
        }  
 
        for(int i = 0; i < s.length(); i++){  
            
            char temp = s.charAt(i); 
            
            if(hash[temp] == 1){
                
                return i;
            }  
        }  
        
        return -1;
        */
    }
}