/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/strings-homomorphism/
@Language: Java
@Datetime: 17-06-24 19:30
*/

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        
        //判断两个字符串是否同构

        if(s == null || t == null || s.length() != t.length())
            return false;
        
        /*
        //方法1：判断对应位置字符是否成唯一映射，同时判断是否出现重复映射
        
        HashMap<Character, Character> record = new HashMap<>();
        HashSet<Character> repeat = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(!record.containsKey(s.charAt(i))){
                
                if(repeat.contains(t.charAt(i))){
                    
                    return false;
                }
                
                record.put(s.charAt(i), t.charAt(i));
                repeat.add(t.charAt(i));
            }
            
            else{
                
                if(record.get(s.charAt(i)) != t.charAt(i)){  
                    
                    return false;  
                } 
            }
            
        }
        return true;
        */
        
        /*
        //方法2：比较两个字符串中，每个字符第一次出现的位置。效率较低
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        int[] index1 = new int[s.length()];
        int[] index2 = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            
            if(!map1.containsKey(s.charAt(i))){
                
                map1.put(s.charAt(i), i);
            }
            
            if(!map2.containsKey(t.charAt(i))){
                
                map2.put(t.charAt(i), i);
            }            
        }
        
        for(int i = 0; i < s.length(); i++){
            
            index1[i] = map1.get(s.charAt(i));
            index2[i] = map2.get(t.charAt(i));
        }
        
        for(int i = 0; i < s.length(); i++){
            
            if(index1[i] != index2[i]){
                
                return false;
            }
        }
        
        return true;
        */
        
        //方法3：
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        
        for(int i = 0; i < 128; i++){
            
            m1[i] = Integer.MAX_VALUE;
            m2[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < s.length(); i++){
            
            int cs = (int) s.charAt(i);
            int ts = (int) t.charAt(i);
             
            if(m1[cs] == Integer.MAX_VALUE){
                 
                //neither s.charAt(i) nor t.charAt(i) has a mapping
                if(m2[ts] == Integer.MAX_VALUE){
                     
                    m1[cs] = ts;
                    m2[ts] = Integer.MIN_VALUE;
                }
                //s.charAt(i) has no mapping but t.charAt(i) already
                //has a mapping to some other character that is not
                //s.charAt(i)
                else{
                    return false;
                }
            }
            //s.charAt(i) already has a mapping, then it must maps to
            //t.charAt(i)
            else if(m1[cs] != ts){
                
                return false;
            }
        }
        
        return true;
    }
}