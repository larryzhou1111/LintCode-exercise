/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/add-digits
@Language: Java
@Datetime: 17-06-01 08:59
*/

public class Solution {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        
        /*
        思路一：
        这道题最后的目标，就是不断将各位相加，相加到最后，当结果小于10时返回。
        最后结果在1-9之间，得到9后不再对各位进行相加，因此不会出现结果为0的情况。
        因为 (x + y) % z = (x % z + y % z) % z，又因为 x % z % z = x % z
        因此结果为 (num - 1) % 9 + 1，只模除9一次，并将模除后的结果加一返回
        */
        //return 1 + (num-1) % 9; 
        
        //思路二：
        //有一个非负整数num，重复这样的操作：
        //对该数字的各位数字求和，对这个和的各位数字再求和……
        //直到最后得到一个仅1位的数字（即小于10的数字）
        int sum = 0;  
        int numBit = 0; 
        
        while(true) {
            
            while(num != 0) {  
                numBit = num % 10;  
                sum += numBit;  
                num /= 10;  
            } 
            
            if(sum<10) {  
                break;  
            } 
            
            num = sum;  
            sum = 0;  
        }  
        return sum; 
    }
}