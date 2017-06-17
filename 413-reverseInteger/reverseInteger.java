/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:http://www.lintcode.com/zh-cn/problem/reverse-integer/
@Language: Java
@Datetime: 17-06-17 14:54
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        
        //解题思路：有个技巧，在反转每一位的时候判断一下有没有越界。
        /*
          整数反转可以不判断是否为正负，因为每次都模拟翻转的过程，
          即取余加到上次结果左移一位，同时纪录左移一位之前的结果
          判断是否移动一位之后，就越界溢出了
        */
        
        int result = 0;
        
        while(n != 0){
            
            //取余
            int val = n % 10;
            int temp = result;
            result = temp * 10 + val;
            //取第二位
            n = n / 10;
            
            //与上一次结果对比，看是否溢出
            if(result / 10 != temp)
                return 0;
        }
        return result;
    }
}