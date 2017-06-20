/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/unique-characters/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        
        if(str == null)
            return false;
            
        if(str.length() == 1)
            return true;
            
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        map.put(str.charAt(0), 1);
        
        for(int i = 1; i < str.length(); i++){
            
            char a = str.charAt(i);
            
            if(map.containsKey(a)){
                
                map.put(a,map.get(a) + 1);
            }
            
            else{
                
                map.put(a, 1);
            }
        } 
        
        if(map.size() == str.length())
            return true;
        else
            return false;
    }
}