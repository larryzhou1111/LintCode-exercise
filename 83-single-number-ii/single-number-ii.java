/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/single-number-ii/
@Language: Java
@Datetime: 17-06-18 19:54
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        
        //需要回顾！！！
        
        /*方法1：
              思路：按位计算
              int型数字占32位，如果这个数字出现3次
              则与这个数字对应的每一位上的1也出现三次
              使用int型数组记录每一位上1出现的次数，能被3整除,则表示出现3次
              最后得到的就是要求的数字
        */
        /*
        if(A == null || A.length == 0)
            return 0;
            
        int[] bits = new int[32];
        int result = 0;
        
        for(int i = 0; i < 32; i++){
            
            for(int j = 0; j < A.length; j++){
                
                bits[i] += A[j]>>i & 1;
            }
            
            bits[i] = bits[i] % 3;
            result = result | bits[i] << i;
        }
        return result;
        */
        
        //方法2：
        /*
          当a出现一次的时候，ones能保存a；当a出现两次的时候，twos能保存a
          当a出现三次的时候，ones和twos都清零 
          所以，如果一个数值中所有的数都通过这个循环的话，出现三次的数都清零了， 
          有一个数如果出现一次，它保存在ones中；如果出现两次的话保存在twos中。
          */
        if(A == null || A.length == 0)
            return 0;
            
        int ones = 0;  
        int twos = 0;  
        
        for (int i = 0; i < A.length; i++){  
            
            ones = (ones ^ A[i]) & (~twos);  
            twos = (twos ^ A[i]) & (~ones);  
        }  
  
        return ones; 
    }
}