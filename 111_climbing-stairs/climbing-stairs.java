/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 17-06-04 12:13
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here

        /*
            登上第1级：0+1种 
            登上第2级：1+1种 
            登上第3级：1+2=3种（前一步要么从第1级迈上来,要么从第2级迈上来） 
            登上第4级：2+3=5种（前一步要么从第2级迈上来,要么从第3级迈上来） 
            登上第5级：3+5=8种 
            登上第6级：5+8=13种 
            登上第7级：8+13=21种 
            登上第8级：13+21=34种 
            登上第9级：21+34=55种 
            登上第10级：34+55=89种 
        */
        
        //累加
        int one = 0;
        int two = 1;
        
        while(n>0)  {
            
            two = two + one;
            one = two - one;
            n--;
        }
        return two;

        /* 
        //该递归会超时 
        if(n==1)
            return 1;
        if(n==2)
            return 2;
            
        return climbStairs(n-1)+climbStairs(n-2);
        */
        
        /*
            **进阶** 

        如果某人可以一次性跳1~n阶，那他跳完n阶台阶有多少种跳法？

        **设f(n)为n阶台阶的情况下，所有不同的跳法方法的总和!**
            1.如果起始跳一阶的话，剩余的n-1阶就有 f(n-1) 种跳法；
            2.如果起始跳二阶的话，剩余的n-2阶就有 f(n-2) 种跳法；
            3.如果起始跳三阶的话，剩余的n-2阶就有 f(n-3) 种跳法；
                ...
            n.如果起始跳n阶的话，剩余的n-2阶就有 f(n-n) 种跳法；

            假定f(0) = 1，已知一阶台阶时，跳法只有一种，所以f(1) = 1
            所以f(2) = 1+1 = 2

            得：f(n) = f(n-1)+f(n-2)+f(n-3)...+...+f(n-(n-1))+f(n-n)
              　f(n) = f(n-1)+f(n-2)+f(n-3)+...+f(0)

            又：f(n-1) = f(n-2)+f(n-3)...+...+f(0)
　　　　        f(n-2) = f(n-3)+f(n-4)...+...+f(0)

            则：f(n) = 2 * f(n-1)
                     = 2^2 * f(n-2)
                     = 2^(n-2) * f(2) 

            **最终结果f(n) = 2^(n-1) **
        */
    }
}