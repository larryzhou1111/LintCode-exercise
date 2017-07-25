/*
@Author:   larryzhou
@Problem:  求1+2+3+...+n（剑指offer题46）
@Language: Java
@Datetime: 17-07-24 21:00
*/
        
public class Solution {
    public int Sum_Solution(int n) {

		/* 求1+2+3+...+n，
			要求不能使用乘除法、for、while、if、else、switch、case等关键字
			及条件判断语句（A?B:C）
        */
	
        /* 方法1：
			1.需利用逻辑与'&&'的短路特性实现递归终止(单个的'&'不具备短路特性)
            2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
			3.当n>0时，执行sum += Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
		*/

        int sum = n;
        
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        
        return sum;

		//方法2：
		//return (int)(Math.pow(n, 2) + n)>>1;
		
    }
}