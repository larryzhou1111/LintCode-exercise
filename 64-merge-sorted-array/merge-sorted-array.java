/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/merge-sorted-array/
@Language: Java
@Datetime: 17-06-22 20:54
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        
        /* 合并排序数组II：合并两个排序的整数数组A和B变成一个新的数组。

        注意事项:
        你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
        
        样例:
        给出 A = [1, 2, 3, empty, empty], B = [4, 5]
        合并之后 A 将变成 [1,2,3,4,5]
        */
        
        //思路：类比题6 本题中数组A的长度为 m+n，则B中元素直接添加到A中
        //从后往前遍历A和B，大的元素添加到数组A尾部。A和B长度不重叠部分，直接归并即可
        
        //类比题6，题212（剑指offer题4）
        if(A == null || B == null)
            return;
            
        int i = m - 1;
        int j = n - 1;
        
        //新数组的最后一个元素位置    
        int len = m + n - 1;

        //从后往前数，数组A和B重合的部分
        while(i >= 0 && j >= 0){
            
            if(A[i] > B[j]){
                
                A[len--] = A[i--];
            }
            else{
                
                A[len--] = B[j--];
            }
        }

        //数组A的长度更长时
        while (i >= 0){  
            
            A[len--] = A[i--];
        }  
        
        //数组B的长度更长时
        while (j >= 0){  
            
            A[len--] = B[j--]; 
        }
 
    }
}