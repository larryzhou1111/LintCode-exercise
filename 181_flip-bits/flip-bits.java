/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 17-06-05 14:16
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        
        //方法1：参考题365
        //直接求出两个数的二进制表示，然后比较两个01字符串的不同的位的个数
        //代码略
        
        //方法2：先对两个数异或，求出的二进制数中1的个数，就是两个数的不同位的个数
        //需要考虑负数，依然参考题365
        /*
           针对负数问题：
           负数的二进制是如何生成的，分两步：
            1. 取反：就是对这个负数的绝对值按位取反，得到的叫做反码
            2. 加1：取反后，对这个二进制数加1，得到的叫做补码
        */
        /*
        a = a ^ b;
        return count(a);
    }
    
    public static int count(int num){
        
        int count = 0;
        int temp = num;
        
        if(num < 0){
            temp = Math.abs(num + 1);
        }
        
        while(temp != 0){
            temp = temp & (temp - 1);
            count++;
        }
        
        if(num >= 0)
            return count;
        else
            return(32 - count); 
    */
    
        //方法3：依然参考题365.使用无符号右移运算符>>>.
        /*  
          无符号右移运算符>>>: 
            不管标志位是0还是1，将该数的二进制代码整体右移
            左边部分总是以0填充，右边部分舍弃
        */
        a = a ^ b;
        int count = 0; 
        
        //每次整体右移一位，判断最右边一位是否是1
        for(;a != 0;a >>>= 1){
            
            //看最低位是否是1，是则计数加1
            if((a & 1) == 1)
                count++;
        }
        return count;
    }
};
