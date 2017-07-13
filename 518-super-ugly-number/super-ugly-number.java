/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/super-ugly-number/
@Language: Java
@Datetime: 17-07-13 22:02
*/

public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        
        /* 超级丑数
        
            写一个程序来找第 n 个超级丑数
            超级丑数的定义是正整数并且所有的质数因子都在所给定的一个大小为 k 的质数集合内
            
            比如给你 4 个质数的集合 [2, 7, 13, 19], 
            那么 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 是前 12 个超级丑数
            
            注意事项:
            
            1 永远都是超级丑数不管给的质数集合是什么
            给你的质数集合已经按照升序排列。
            0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000
            
            样例:
            给出 n = 6 和质数集合 [2, 7, 13, 19]
            第 6 个超级丑数为 13，所以返回 13 作为结果
        
        */
        int[] superUglyNumbers = new int[n];
        
        superUglyNumbers[0] = 1;
        
        int[] idxPrimes = new int[primes.length];
        
        for(int i = 0; i < idxPrimes.length; i++){
            
            idxPrimes[i] = 0;
        }
        
        int counter = 1;
        
        while(counter < n){
            
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < primes.length; i++){
                
                int temp = superUglyNumbers[idxPrimes[i]] * primes[i];
                min = min < temp ? min : temp;
            }

            for(int i = 0; i < primes.length; i++){
                
                if(min == superUglyNumbers[idxPrimes[i]] * primes[i]){
                    
                    idxPrimes[i]++;
                }
            }
            
            superUglyNumbers[counter] = min;
            counter++;
        }
        
        return superUglyNumbers[n - 1];
		
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