/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/single-number/
@Language: Java
@Datetime: 17-06-18 19:54
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        
        //方法1：利用异或^运算,两个相同的数,异或的结果是0
        if(A == null || A.length == 0)
            return 0;
        /*    
        int n = A[0];
        for(int i = 1; i < A.length; i++){
            
            n = n ^ A[i];
        }
        return n;
        */
        
        //方法2： 利用HashMap
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < A.length; i++){
            
            if(map.containsKey(A[i])){
                
                map.remove(A[i]);
            }
            else{
                map.put(A[i],1);
            }
        }
        Object array[] = map.keySet().toArray() ;
        
        return (Integer)array[0];
    }
}