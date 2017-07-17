/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/count-1-in-binary
@Language: Java
@Datetime: 17-06-05 14:13
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here

        /* 二进制中有多少个1
            计算在一个 32 位的整数的二进制表示中有多少个 1
            
            样例:
            给定 32 (100000)，返回 1
            给定 5 (101)，返回 2
            给定 1023 (111111111)，返回 9
        */
        
        //方法1：使用无符号右移运算符>>>，需要循环32次
        /*  
          无符号右移运算符>>>: 
            不管标志位是0还是1，将该数的二进制代码整体右移
            左边部分总是以0填充，右边部分舍弃
        */
        /*
        int count = 0; 
        
        //每次整体右移一位，判断最右边一位是否是1
        for(;num != 0;num >>>= 1){
            
            //看最低位是否是1，是则计数加1
            if((num & 1) == 1)
                count++;
        }
        return count;
        */
        
        
        //方法2：快速法，该数中有多少个1，就执行多少次
        /*
            不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0
            n相当于在n - 1的最低位加上1.
            即8（1000）= 7（0111）+ 1（0001）,所以8 & 7 = （1000）&（0111）= 0（0000）
        */
        /*
           针对负数问题：
           负数的二进制是如何生成的，分两步：
            1. 取反：就是对这个负数的绝对值按位取反，得到的叫做反码
            2. 加1：取反后，对这个二进制数加1，得到的叫做补码
            
            即：负数是a，显然，a - 1的二进制表示就是-a的反码
                而用32减去(-a)中1的个数，就是(a - 1)中1的个数
        */
        /*
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
        
        //方法3：快速法的精简版 (剑指offer题10)
        //不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0，该数中有多少个1，就执行多少次
        
        int count = 0;
         
        while(num != 0){
            
            num = num & (num - 1);
            count++;
        }
        
        return count;
		
		/* 2道类似题目
		（1）用一条语句判断一个整数是不是2的整数次方。
				一个整数如果是2的整数次方，则其二进制表示中有且只有一位是1，其他所有位都是0
				则判断 n&(n-1)是否为0即可
				
		（2）输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
				1、先求这两个数的异或（位异或，相同则为0，不同则为1）
				2、统计异或结果中1的个数
		*/
    }
}