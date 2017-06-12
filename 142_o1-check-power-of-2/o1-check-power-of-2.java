/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 17-06-12 12:24
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        
        //类比题365
        
        //使用位运算符 
        
        // n相当于在n - 1的最低位加上1.
        // 即8（1000）= 7（0111）+ 1（0001）,所以8 & 7 = （1000）&（0111）= 0（0000）

        return n > 0 && ((n & (n-1)) == 0); 
    }
};