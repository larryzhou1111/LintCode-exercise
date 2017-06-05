/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 17-06-05 14:50
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        
        //递归实现
        
        boolean flag = false;
        //平方和
        long count = n;
        //循环次数
        int limit = 0;
        
        while(count != 1 && limit < 1000)
        {
            count = this.calculate(count);
            //若数的平方和仍然等于该数，死循环，则排除
            if(count == n)
                break;
            limit++;
        }
        
        if(count == 1) 
            flag=true;
            
        return flag;
    }

    public long calculate(long count) {
        
        long total = 0;
        long a = 0;
        
        //递归求个位数，累加个位数的平方
        while (count != 0) {
            
            a = count % 10;
            count = count / 10;
            total = total + a * a;
        }
        return total;
    }
}