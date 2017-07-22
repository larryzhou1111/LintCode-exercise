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
        
        /* 落单的数 II
        
            给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，
            找到这个数字
        
            样例:给出 [1,1,2,3,3,3,2,2,4,1] ，返回 4
        */
        
        /*方法1：思路：按位计算
        
          int型数字占32位，如果这个数字出现3次，
          则与这个数字对应的每一位上的1也出现三次
          
          使用int型数组记录每一位上1出现的次数，能被3整除,则表示出现3次
          最后得到的就是要求的数字
        */
        
        if(A == null || A.length == 0)
            return 0;
            
        int[] bits = new int[32];
        int result = 0;
        
        for(int i = 0; i < 32; i++){
            
            for(int j = 0; j < A.length; j++){
                
                // >>=1 等价于 /2，且位运算效率更高
                
                //此处判断第i位，1出现的次数
                bits[i] += A[j]>>i & 1;
            }
            
            bits[i] = bits[i] % 3;
            /*
                两种逻辑或（||和|）的运算规则基本相同
                
                |运算是把逻辑表达式全部计算完，而||运算具有短路计算功能
                
                对于 || 运算来说，只要运算符左端的值为true，
                则无论运算符右端的值为true或为false，其最终结果都为true
                所以一旦判断出||运算符左端的值为true，则系统将终止其后的计算过程
                
                此处只能用"|"，result 和 bits[i] << i 同为0时，result才为0
            */
            result = result | bits[i] << i;
        }
        
        return result;
        
        
        //方法2：
        /*
          当a出现一次的时候，ones能保存a；当a出现两次的时候，twos能保存a
          当a出现三次的时候，ones和twos都清零 
          所以，如果一个数值中所有的数都通过这个循环的话，出现三次的数都清零了， 
          有一个数如果出现一次，它保存在ones中；如果出现两次的话保存在twos中。
        */
        /*
        if(A == null || A.length == 0)
            return 0;
            
        int ones = 0;  
        int twos = 0;  
        
        for (int i = 0; i < A.length; i++){  
            
            //非运算符"~": 如果位为0，结果是1；如果位为1，结果是0
            ones = (ones ^ A[i]) & (~twos);  
            twos = (twos ^ A[i]) & (~ones);  
        }  
  
        return ones; 
        */
    }
}