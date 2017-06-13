/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Java
@Datetime: 17-06-13 13:22
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        
        /*
          字典排序：[1,2,4]这个数组的排列方式一共有3!=6种。 
                1,2,4   1,4,2   2,1,4   2,4,1   4,1,2   4,2,1 
        */
        
        /* 方法1：
        
            例如[6,8,4,7,5,3,2]这个数组，他的第一排序是[2,3,4,5,6,7,8]
            然后首先拿到待计算排序的第一个元素6
            那么在6之前，比他小的元素有几个呢？有2,3,4,5这4个
            确定了第一个元素后，其他剩下的7-1=6个元素进行全排列，共有6！=720种，
            所以一共有4*（7-1）！种。
            但是计算第二个元素的时候要小心了
            现在第2个元素是8，比8小的元素有几个呢，6个。错！！！，
            因为第一个元素已经确定了，所以应该是还有5个，
            那么此时剩下的元素进行全排列，就有5*（7-2）！种 
            下面是每一位上元素的所有排列情况 
            6 –> 4 * (7-1)!种 
            8 –> 5 * (7-2)!种 
            4 –> 2 * (7-3)!种 
            7 –> 3 * (7-4)!种 
            5 –> 2 * (7-5)!种 
            3 –> 1 * (7-6)!种 
            2 –> 0 * (7-7)!种 
            最后再加上一个第1排序，结果就是答案了 
        */
    /*
        long number = 0;
        if(A == null || A.length == 0)
            return 0;
            
        for(int i = 0; i < A.length - 1; i++){
            
            //计算该元素有几个比它小的
            long temp = 0;
            
            for(int j = i + 1; j < A.length; j++){
               
                //如果后一个比前一个小，则+1
                if(A[j] < A[i]){
                    
                   temp++; 
                }
            }
            number += temp * getFactor(A.length - 1 - i);
        }
        return number + 1;
    }
    
    //递归计算剩余元素的所有排列情况
    public long getFactor(int n){
        
        long result = 1;
        
        while(n >= 1){
            result = result * n;
            n--;
        }
        return result;
    */
    
    //方法2：原理与法1类似，写法较简单
        if(A == null || A.length == 0) 
            return 0;
            
        long index = 1;
        long factor = 1;
        
        for(int i = A.length - 1; i >= 0; i--){
            
            int rank = 0;
            
            for(int j = i + 1; j < A.length; j++){
                
                if (A[i] > A[j]){
                    
                    rank++;
                }
            }
            
            index += rank * factor;
            factor *= (A.length - i);
        }
        return index;    
    }
}