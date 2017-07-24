/*
@Author:   larryzhou
@Problem:  圆圈中最后剩下的数字（剑指offer题45）
@Language: Java
@Datetime: 17-07-24 21:00
*/

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        
        /* 圆圈中最后剩下的数字
        	0,1,2...n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字
            求出这个圆圈里，剩下的最后一个数字
        */
     
        //方法1：f(n, m) = [f(n-1,m) + m] % n (n > 1时); n=1时，f(n, m) = 0
        
        if(n < 1 || m < 1)
            	return -1;
			
        /*
        int last = 0;
        
        for(int i = 2; i <= n; i++){
            
            last = (last + m) % i;
        }
        
        return last;
        */
        
        //方法2：用数组来模拟环，注意下标
        int[] array = new int[n];
        int i = -1;
		int step = 0;
		int count = n;
        
        //跳出循环时，将最后一个元素也设置为-1
        while(count > 0){ 
            
            //指向上一个被删除对象的下一个元素
            i++;   
            
            if(i >= n){
	
				//模拟环
				i=0; 
			}
                             
            if(array[i] == -1){
	
				//跳过被删除的对象
				continue; 
			}    
            
            //记录已走过的
            step++;  
            
            //找到待删除的对象
            if(step == m){    
                
                array[i] = -1;
                step = 0;
                count--;
            }        
        }
        
        //返回跳出循环时的i,即最后一个被设置为-1的元素
        return i;
    }
}