/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/strstr/
@Language: Java
@Datetime: 17-06-20 21:54
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        
        //需回顾KMP算法！！！
        
        //方法1：循环遍历比较，效率低
        
        if(source == null || target == null)
            return -1;
            
        if(target.length() == 0)
            return 0;
            
        /*
        int i, j; 
        
        for(i = 0; i < source.length() - target.length() + 1; i++){ 
            
            for(j = 0; j < target.length(); j++){ 
                
                if(source.charAt(i + j) != target.charAt(j)){  
                    break;  
                }  
            }  
            
            if(j == target.length()){  
                return i;  
            }  
        }  
        return -1; 
        */
        
        //方法2：KMP算法 参考http://blog.csdn.net/shinanhualiu/article/details/48599231

        int n = source.length();
        int m = target.length();
        int j = 0;
        int[] next = new int[m];
        
        makeNext(target, next);
        
        for(int i = 0; i < n; i++){
            
            while(j > 0 && target.charAt(j) != source.charAt(i)){
                
                j = next[j - 1];
            }   
            
            if(target.charAt(j) == source.charAt(i)){
                
                j++;
            }
            
            if(j == m){
                
                return i - m + 1;
            }
            
        }
        return -1;
    }
    
    public void makeNext(String target, int next[]){
        
        int m = target.length();
        int k = 0;
        next[0] = 0;
        
        for(int j = 1; j < m; j++){
            
            while(k > 0 && target.charAt(j) != target.charAt(k)){
                
                k = next[k-1];
            } 
            
            if(target.charAt(j) == target.charAt(k)){
                
                k++;
            }
            
            next[j] = k;   

        }
     
        //方法3：Rabin-Karp算法. 有难度！！！
        //参考:http://www.jianshu.com/p/0313be93d052
        //     https://www.bbsmax.com/A/RnJWwwOJqY/  
    }
}
