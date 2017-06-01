/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/a-b-problem
@Language: Java
@Datetime: 17-06-01 05:50
*/

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        
        /*思路：
            进行二进制的位运算
              1、(位异或^) ：如果相同位不同则为1，相同位相同则为0
                        目的是将相加后不需要进位的取出
              2、(位与&) ：如果相同位为1，则为1，相同位为0则为零，然后左移1位
                        目的是将相加后需要进位的单独取出
              3、重复以上2步，直到其中一方全为0，输出结果即可。
        */
        
        int sum,plusnum;  
        if(b==0)  
            return a; 
        //相加不进位，如果两个位都是0或1，则相加为0，不相同时则为1   
        sum = a^b;  
        //相加只进位，只有当两个位都是1时才进位，其它情况不进位，然后左移,最后一位进位为0 
        plusnum = (a&b)<<1; 
        //递归直到没有位可进
        return aplusb(sum,plusnum); 
    }
}