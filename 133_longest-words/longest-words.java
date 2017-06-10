/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/longest-words
@Language: Java
@Datetime: 17-06-10 14:53
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        
        ArrayList<String> result = new ArrayList<String>();
        
        for(String str : dictionary){
            
            if(result.isEmpty() || result.get(0).length() < str.length()){
                
                result.clear();  
                result.add(str);
            }
            else if(result.get(0).length() == str.length()){
                
                result.add(str);
            }
        }
        return result;        
    }
};