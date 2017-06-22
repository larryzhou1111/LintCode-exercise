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
        
        //思路：类比题6 本题中数组A的长度为m+n，则B中元素直接添加到A中
        //从后往前遍历A和B，大的元素添加到数组A尾部。A和B长度不重叠部分，直接归并即可

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