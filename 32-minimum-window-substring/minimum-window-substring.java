/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/minimum-window-substring/
@Language: Java
@Datetime: 17-7-7 22:00
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        
        /* 最小子串覆盖
           给定一个字符串source和一个目标字符串target，
           在字符串source中找到包括所有目标字符串字母的子串。
           
           如果在source中没有这样的子串，返回""，
           如果有多个这样的子串，返回长度最短的子串
           
           (题目表述有误，不是起始位置最小，是长度最短)
           
           在答案的子串中的字母，在目标字符串中不需要具有相同的顺序
        */
        
        /* 思路：
            双指针，动态维护一个区间
            尾指针不断往后扫，当扫到有一个窗口，包含了所有target的字符后，
            然后再收缩头指针，直到不能再收缩为止
            最后记录所有可能的情况中，最小的窗口
            
            因为可以跳过没在字典里面的字符
          （即不需要包含且仅仅包含字典里面的字符，有一些不在字典的仍然可以满足要求）
          
            所以遇到没在字典里面的字符，可以继续移动窗口右端，
            而移动窗口左端的条件是当找到满足条件的串之后，
            一直移动窗口左端，直到有字典里的字符不再在窗口里
            
            在实际中，就是维护一个HashMap，一开始key包含字典中所有字符，
            value就是该字符的数量，然后遇到字典中字符时，就将对应字符的数量减一
        */
        
        if(source == null || source.length() == 0)
            return source;
            
        if(target == null || target.length() == 0)
            return "";
            
        //对字符串target中出现的字符计数     
        HashMap <Character, Integer> tCounter = new HashMap<Character, Integer>();        
        for(int i = 0; i < target.length(); i++){
            
            Character c = target.charAt(i);
            
            if(tCounter.containsKey(c)){
                
                tCounter.put(c, tCounter.get(c) + 1);
            } 
            else{
                tCounter.put(c, 1);
            }
        }
        
        HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
        
        String minWindow = null;
        
        int tCount = 0, leftBound = 0;
        
        for(int i = 0; i < source.length(); i++){
            
            Character c = source.charAt(i);
            
            if(!tCounter.containsKey(c)){
                continue;
            }
            
            if(minWindowCounter.containsKey(c)){  
                
                minWindowCounter.put(c, minWindowCounter.get(c) + 1);
            } 
            else{
                
                minWindowCounter.put(c, 1);
            }

            if(minWindowCounter.get(c) <= tCounter.get(c)){  
                
                //source和target有一个字符匹配
                tCount++;
            }
            
            if(tCount == target.length()){   
                
                //source中所有的字符都匹配
                while(leftBound < source.length()){
                    
                    Character ch = source.charAt(leftBound);
                    
                    if(!tCounter.containsKey(ch)){
                        
                        leftBound++;
                        continue;
                    }   
                    
                    if(minWindowCounter.get(ch) > tCounter.get(ch)){  
                        
                        //有窗口里的字符，开始不再在窗口里
                        minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
                        leftBound++;
                        continue;
                    }                   
                    break;
                }  
                
                //找到最小子串
                if(minWindow == null || i - leftBound + 1 < minWindow.length()){
                    
                    minWindow = source.substring(leftBound, i + 1);
                }
            }
        }
        
        if(minWindow == null){
            return "";
        }
        
        return minWindow;
    }        
        
}