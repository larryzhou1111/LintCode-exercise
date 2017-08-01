/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 17-06-13 15:19
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        
        /*  数组剔除元素后的乘积
        
            给定一个整数数组A
            定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]，
            计算B的时候请不要使用除法

            样例: 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
        */
        
        /*
        //方法1：leftb计算左侧的连乘值，每次增加一个成绩，rightb计算右侧的连乘值
        //每次重新计算，时间复杂度O(N2)
        
        //注意 类型是Long 不是long ,区分大小写！
        ArrayList<Long> B = new ArrayList<Long>();
        
        long leftb = 1;
        long rightb = 1;
        
        for(int i = 0; i < A.size(); i++){
            
            if(i == 0){
                
                leftb = 1;
            }
            else{
                
                leftb = leftb * A.get(i-1);
            }
            
            for(int j = i + 1; j < A.size(); j++){
                
                rightb = rightb * A.get(j);
            }
            
            long bi = leftb * rightb;
            B.add(bi);
            rightb = 1;
        }
        return B;
        */
        
        //方法2：左右分治
        /*
          result[i] = left[i] * right[i] 
          left[i] = A[0] * A[1] * ... * A[i-1]
          right[i] = A[i+1] * A[i+2] * ... * A[len(A)-1]
          
          将最后的乘积分为两部分求解，首先求得左半部分的值，然后求得右半部分的值
          最后将左右两半部分乘起来即为解
        */
        
        ArrayList<Long> B = new ArrayList<Long>();
        
        if(A == null || A.size() == 1){
            
            long bi = 1;
            B.add(bi);
            return B;
        }
        
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        
        left[0] = 1;
        
        for(int i = 1; i < A.size(); i++){
           
            left[i] = left[i - 1] * A.get(i - 1);
        }
        
        right[A.size() - 1] = 1;
        
        //从右边倒数第二位开始遍历,累加
        for(int i = A.size() - 2; i >= 0; i--){
            
            right[i] = right[i + 1] * A.get(i + 1);
        }
        
        for(int i = 0; i < A.size(); i++){
            
            long res = right[i] * left[i];
            B.add(res);
        }
        
        return B;        
    }
}