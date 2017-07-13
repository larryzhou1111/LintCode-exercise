/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/ugly-number/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        
        /* 丑数
        
            写一个程序来检测一个整数是不是丑数。
            丑数的定义是，只包含质因子 2, 3, 5 的正整数。
            比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
            
            注意事项:
            可以认为 1 是一个特殊的丑数。
            
            样例:
            给出 num = 8，返回 true。
            给出 num = 14，返回 false。
                    
        */
        
        //用2、3、5不断整除n，当n不能再被2、3、5整除时，判断n是否等于1
        //等于1则指定的数字是丑数
        
        if(num <= 0) 
            return false;  
            
        if(num == 1)
            return true;
            
        while(num % 2 == 0)
            num /= 2;
            
        while(num % 3 == 0) 
            num /= 3;
            
        while(num % 5 == 0) 
            num /= 5;
        
        if(num == 1) 
            return true;
        else 
            return false;

        
        //类似题：返回第k个丑数
        
        /*
        //把第一个丑数返回
		if(k < 0) 
 			return 1;

  		long[] numbers = new long[k + 1]; 	
  		numbers[0] = 1;
  		
  		int next = 1;
  		int ugly3Index = 0;
  		int ugly5Index = 0;
  		int ugly7Index = 0;
  		
  		while(next <= k){
  		    
  			long uglyNum = Math.min(numbers[ugly3Index] * 3,
  					Math.min(numbers[ugly5Index] * 5, numbers[ugly7Index] * 7));
  					
  			numbers[next] = uglyNum;
  			
  			while(numbers[ugly3Index] * 3 <= numbers[next]){
  			    
  				ugly3Index++;
  			}
  			
  			while(numbers[ugly5Index] * 5 <= numbers[next]){
  				ugly5Index++;
  			}
  			while(numbers[ugly7Index] * 7 <= numbers[next]){
  			    
  				ugly7Index++;
  			}
  			
  			next++;
  		}
  		
  		return numbers[k]; 
        */
        
    }
}