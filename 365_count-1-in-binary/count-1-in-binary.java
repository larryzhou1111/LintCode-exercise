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
            //把负数转换成正数，算出结果后加1,但会显示数太大，报错
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
        
        //方法4：快速法的精简版(不够可靠！)
        //不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0
        /*
        int count = 0;
        
        while(num != 0){
            num = num & (num - 1);
            count++;
        }
        
        return count;
        */
        
        //方法5：使用无符号右移运算符>>>
        /*  
          无符号右移运算符>>>: 
            不管标志位是0还是1，将该数的二进制代码整体右移
            左边部分总是以0填充，右边部分舍弃
        */
        int count = 0; 
        
        //每次整体右移一位，判断最右边一位是否是1
        for(;num != 0;num >>>= 1){
            
            //看最低位是否是1，是则计数加1
            if((num & 1) == 1)
                count++;
        }
        return count;
    }
}
