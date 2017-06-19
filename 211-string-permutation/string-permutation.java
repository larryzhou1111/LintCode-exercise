/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/string-permutation/
@Language: Java
@Datetime: 17-06-19 19:54
*/

public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        
        //置换：两个字符串的长度相同、每个字符的出现次数相同
        if(A == B)
            return true;
            
        if(A == null || B == null || A.length() != B.length())
            return false;
            
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < A.length(); i++){
            
            char a = A.charAt(i);
            
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

            char b = B.charAt(i);
            
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
        //字符串A一直加1，字符串B一直减1。最终为0时，说明A和B中每个字符出现次数相等
        if(map.size() == 0)
            return true;
        else
            return false;
        
    }
}