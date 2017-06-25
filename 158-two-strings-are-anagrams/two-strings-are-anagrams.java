/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/two-strings-are-anagrams/
@Language: Java
@Datetime: 17-06-19 19:54
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        
        //类比题211
        
        //变位词：两个字符串的长度相同、每个字符的出现次数相同
        if(s == t)
            return true;
            
        if(s == null || t == null || s.length() != t.length())
            return false;
            
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++){
            
            char a = s.charAt(i);
            
            if(map.containsKey(a)){
                
                if(map.get(a) == -1){
                    
                    map.remove(a);
                }
                else{
                    
                    map.put(a, map.get(a) + 1);
                } 
            }
            
            else{
                
                map.put(a, 1);
            }

            char b = t.charAt(i);
            
            if(map.containsKey(b)){
                
                if(map.get(b) == 1){
                    
                    map.remove(b);
                }
                else{
                    
                    map.put(b, map.get(b) - 1);
                }
            }
            else{
                map.put(b, -1);
            }
        }
        //字符串s一直加1，字符串t一直减1。最终为0时，说明s和t中每个字符出现次数相等
        if(map.size() == 0)
            return true;
        else
            return false;
    }
};