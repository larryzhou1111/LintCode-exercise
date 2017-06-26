/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/digit-counts/
@Language: Java
@Datetime: 17-06-26 22:30
*/

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        
        //方法1：逐位计算，并计数
        int count = 0;
        
        for(int i = 0; i <= n; i++){
            
            count += singleCount(i, k);
        }
        return count;
    }
    
    public int singleCount(int i, int k){
        
        if(i == 0 && k == 0)
            return 1;
            
        int count = 0;
        
        while(i > 0){
            
            if(i % 10 == k){
                
                count++;
            }
            
            i = i / 10;
        }
        
        return count;
        
        
        //方法2：找规律，不太明白！！！
        //参考：http://blog.csdn.net/cumt_cx/article/details/50607729
        /*
        当某一位的数字小于i时，那么该位出现i的次数为：更高位数字 x 当前位数
        当某一位的数字等于i时，那么该位出现i的次数为：更高位数字 x 当前位数 + 低位数字 + 1
        当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字 + 1) x 当前位数
        */
        /*
        int result = 0;
        int base = 1;
        
        if(n == 0 && k == 0)
            return 1;
            
        while((n / base) > 0){
            
            int curBit = (n / base) % 10;
            int low = n - (n / base) * base;
            int high = n / (base * 10);
            
            if(curBit < k){
                
                result += high * base;
            }
            else if(curBit == k){
                
                result += high * base + low + 1;
            }
            else{
                
                if(k != 0 || high != 0){
               
                    result += (high + 1) * base;
                }
            }
            
            base *= 10;
        }
        
        return result;
        */
    }
};
