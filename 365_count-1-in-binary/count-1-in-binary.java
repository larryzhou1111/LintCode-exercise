/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/count-1-in-binary
@Language: Java
@Datetime: 17-06-04 15:07
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here

        /*
        //方法1：移位加计数，一个个计算统计1的个数. 暂时有问题！！！
        
        //要注意负数问题
        if(num == 0)  
            return 0;  
        
        int count = 0;
        
        if(num > 0){
            
            while(num != 0){
            
                if(num%2 == 1){
                    count++;
                }
                num = num / 2;
            }
        }
        
        if(num < 0){
            //把负数转换成正数，算出结果后加1  !!!
            //num = num + 2147483648;
            
            while(num != 0){ 
            
                if(num%2 == -1){
                    count++;
                }
                num = num / 2;
            }
            //负数，开头包含一个符号位1
            count += 2;
        }
        return count;
        */
        
        /*        
        //方法2：位操作(负数问题暂时没解决)
        int count = 0;
        
        while(num!=0){
            count += num & 0x01;
            num = num>>1;
        }
        return count;
        */
        
        //方法3：快速法
        //不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0
        // n相当于在n - 1的最低位加上1.
        // 即8（1000）= 7（0111）+ 1（0001）,所以8 & 7 = （1000）&（0111）= 0（0000）
        int count = 0;
        
        while(num!=0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
};