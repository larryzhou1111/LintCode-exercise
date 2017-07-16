/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/merge-two-sorted-arrays/
@Language: Java
@Datetime: 17-06-22 20:54
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        
        /* 合并排序数组:合并两个排序的整数数组A和B变成一个新的数组
            样例:
            给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
        */
        
        //类比题64，题212（剑指offer题4）
        
        //思路：新建数组C，长度为A和B长度之和
        //从后往前遍历A和B，大的元素添加到数组C尾部。A和B长度不重叠部分，直接归并即可
        
        if(A == null)
            return B;
        
        if(B == null)
            return A; 
            
        int i = A.length - 1;
        int j = B.length - 1;
        
        //新数组的最后一个元素位置    
        int len = A.length + B.length - 1;
        int[] C = new int[A.length + B.length];
        
        //从后往前数，数组A和B重合的部分
        while(i >= 0 && j >= 0){
            
            if(A[i] > B[j]){
                
                C[len--] = A[i--];
            }
            else{
                
                C[len--] = B[j--];
            }
        }

        //数组A的长度更长时
        while(i >= 0){  
            
            C[len--] = A[i--];
        }  
        
        //数组B的长度更长时
        while(j >= 0){  
            
            C[len--] = B[j--]; 
        }
        
        return C;
    }
}