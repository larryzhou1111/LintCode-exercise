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
        
		
        /* 类似题：返回第n个丑数（剑指offer题34）
		
		  方法：分成三组，每次取最小值做丑数，每组使用一个指针。然后被选中的数的指针后移
          (1) 1×2, 2×2, 3×2, 4×2, 5×2, …

          (2) 1×3, 2×3, 3×3, 4×3, 5×3, …

          (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

           符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
        */
        /*
        int[] UglyNum = new int[n];
        
        UglyNum[0] = 1;
        
        int a = 2, b = 3, c = 5;
        int indexA = 1, indexB = 1, indexC = 1;
        
        for(int i = 1; i < n; i++){
            
            int min = Math.min(Math.min(a, b), c);
            UglyNum[i] = min;
            
            if(a == min){
                
                a = UglyNum[indexA] * 2;
                indexA++;
            }
            
            if(b == min){
                
                b = UglyNum[indexB] * 3;
                indexB++;
            }
            
            if(c == min){
                
                c = UglyNum[indexC] * 5;
                indexC++;
            }
        }
        
        return UglyNum[n - 1];
		*/
    }
}