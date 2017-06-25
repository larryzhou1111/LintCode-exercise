/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/substring-anagrams/
@Language: Java
@Datetime: 17-06-25 20:30
*/

public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
        
        //类比题158：两个字符串是变位词（两个字符串的长度相同、每个字符的出现次数相同）
        
        /*
          给定一个字符串s和一个非空字符串p，找到所有p的起始索引
          字符串仅由小写英文字母组成，字符串s和p的长度不得大于40,000
          输出顺序无关紧要
        */
        
        //方法1：比较两个map是不是相等
        /*
        List<Integer> index = new ArrayList<Integer>(); 
        
        if(s == null || s.length() < p.length())
            return index; 
            
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();  
        HashMap<Character,Integer> map1 = new HashMap<Character,Integer>(); 
        
        for(int i = 0; i < p.length(); i++){  
            
            char tmp = p.charAt(i);  
            char tmp1 = s.charAt(i); 
            
            //map 保存字符串p中出现的字母
            if(!map.containsKey(tmp)){ 
                
                map.put(tmp, 1);  
            }  
            else{ 
                
                map.put(tmp, map.get(tmp) + 1);  
            } 
            
            //map1 保存字符串s中出现的字母
            if(!map1.containsKey(tmp1)){  
                
                map1.put(tmp1, 1);  
            }  
            else{  
                
                map1.put(tmp1, map1.get(tmp1) + 1);  
            }  
        }  

        //判断map (以位置0开头的s的子字符串) 与 map1 (字符串p)是否相等
        if(map.equals(map1)){  
            
            index.add(0);  
        }  
        
        for(int i = 1; i < s.length() - p.length() + 1; i++){ 
            
            //随着位置的递进，更新Map1  
            char tmp = s.charAt(i - 1);  
            char tmp2 = s.charAt(i + p.length() - 1); 
            
            if(map1.get(tmp) == 1){  
                
                map1.remove(tmp);  
            }  
            else{  
                
                map1.put(tmp, map1.get(tmp) - 1);  
            } 
            
            if(!map1.containsKey(tmp2)){ 
                
                map1.put(tmp2, 1);  
            }  
            else{  
                
                map1.put(tmp2, map1.get(tmp2) + 1);  
            }  
            
            //判断map (当前位置的s的子字符串) 与 map1 (字符串p)是否相等
            if(map.equals(map1)){  
  
                index.add(i);  
            }  
        } 
        
        return index;
        */
        
        
        //方法2：
        //参考：http://www.cnblogs.com/lz87/p/6948738.html
        
        List<Integer> index = new ArrayList <Integer>();
        
        if(s == null || s.length() < p.length())
            return index; 
            
        int[] sum = new int[26];

        //存储字符串p中，出现的所有字符的次数（本题字符串都是小写字母）
        for(char c : p.toCharArray()){
            
            sum[c - 'a']++;
        }
        
        int start = 0, end = 0, matched = 0;
        
        while(end < s.length()){
            
            //在字符串s中，找到一个匹配的字符
            if(sum[s.charAt(end) - 'a'] >= 1){
                
                matched++;
            }
            
            sum[s.charAt(end) - 'a']--;
            end++;
            
            //判断是否匹配了所有的字符 
            if(matched == p.length()){
                
                index.add(start);
            }
            
            //窗口继续滑动，即继续遍历比较
            if(end - start == p.length()){
                
                //在索引开始之前，发现匹配，则需要减少匹配
                //s.charAt(start) 将被滑出窗口
                if(sum[s.charAt(start) - 'a'] >= 0){
                    
                    matched--;
                }
                
                //恢复字符s.charAt（start）的频率，供之后检查
                sum[s.charAt(start) - 'a']++;
                start++;
                
            }
        }
        return index;

        
        //方法3：类比题158。不断分割子字符串，继而比较是否是变位词。会超时！！！
        /*
        List<Integer> index = new ArrayList<Integer>();
        
        if(s == null || s.length() < p.length())
            return index;
            
        for(int i = 0; i < s.length() - p.length() + 1; i++){
            
            //子字符串包括起始索引，不包括结束索引
            String subs = s.substring(i, i + p.length());
            
            boolean flag = anagram(subs, p);
            
            if(flag){
               
                index.add(i);
            }
        }
        
        return index;
    }
    
    
    public boolean anagram(String s, String t) {

        //变位词：两个字符串的长度相同、每个字符的出现次数相同
        if(s == t)
            return true;

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
            
        */
    }
    
}