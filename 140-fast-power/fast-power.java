/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/fast-power/
@Language: Java
@Datetime: 17-07-18 12:00
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        
        /* 快速幂
        
            计算a的n次方 % b，其中a，b和n都是32位的整数
            
            样例:
            例如 2的31次方 % 3 = 2
            例如 100的1000次方 % 1000 = 0
        */
        
        //类比题428，思路基本一致
        
        if(n == 0)
            return 1 % b;
        
        if(n == 1)
            return a % b;
            
        if(n < 0)
            return -1;
        
        //递归，每次除以2，减少循环次数
        //位运算，比乘除法、求余效率更高，右移一位相当于除以2    
        long result = fastPower(a, b,  n>>1);
        
        result *= result;
        result %= b;
        
        //与0x01，相当于对2取余，来判断奇偶
        if((n & 0x01) == 1){
            
            result *= a;
            result %= b;
        }

        return (int)result;        
        
    }
};