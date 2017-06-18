/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/single-number-iii/
@Language: Java
@Datetime: 17-06-18 19:54
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        
        //需回顾！！！
        
        /* 思路：
            将全部的数异或，最后得到一个数，此数为两个出现一次的数的异或
            得到的这个数至少有一位为1，此位可将所有数分为两部分，
            一部分此位为0，另一部分此位为1，所求的两个数一定分别在两部分中，
            并且每一部分的个数都是 2 * m + 1，
            问题就转化为两部分，分别求落单的数I，
            即可两部分分别异或求出两数
        */
        
        if(null == A || A.length ==0) 
            return null;
            
        List<Integer> list = new ArrayList<Integer>();
        
        int x = 0;
        for(int i = 0; i < A.length; i++){
            
            x ^= A[i];
        }
        
        int k = 0;
        while((x % 2) == 0 && k < 32){
            
            k++;
            x >>=1;
        }
        
        int result1 = 0, result2 = 0;
        
        for(int i = 0; i < A.length; i++){
            
            if(((A[i]>>>k) & 1) == 0){
                
                result1 ^= A[i];
            }
            else{
                result2 ^= A[i];
            }
        }
        
        list.add(result1);
        list.add(result2);
        
        return list;
    }
}