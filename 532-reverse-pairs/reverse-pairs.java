/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/reverse-pairs/
@Language: Java
@Datetime: 17-07-22 16:00
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        
        /* 逆序对 ( 剑指offer题36 )
        在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
        给你一个数组，求出这个数组中逆序对的总数
        
        概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对

        样例: 序列 [2, 4, 1, 3, 5] 中，有 3 个逆序对 (2, 1), (4, 1), (4, 3)，则返回 3
        */
        
        //方法1：暴力破解，会超时
        /*
        if(A == null || A.length <= 1)
            return 0;
            
        long result = 0;
        for(int i = 0; i < A.length-1; i++){
            
            for(int j = i + 1; j < A.length; j++){
                
                if (A[i] > A[j]) {
                    result++;
                }
            }
        }
        return result;
        */
        
        /* 方法2：类似归并排序，类比题464 O(nlogn)
        
           先把数组分割成子数组，先统计子数组内部的逆序对数目，
           然后再统计两个相邻子数组之间的逆序对的数目
           
           统计逆序对的过程中，需要对数组排序
        */
        if(A == null || A.length <= 1)
            return 0;
            
        int low = 0;
        int high = A.length - 1;
        
        return mergeSort(A, low, high);
    }
    
    public int mergeSort(int[] A, int low, int high){
        
        if(low >= high)
            return 0;
            
        int mid = (high - low) / 2 + low;
        int sum = 0;
        
        //递归，对中间值mid左右，分别进行递归排序
        sum += mergeSort(A, low, mid);
        sum += mergeSort(A, mid + 1, high);
        
        //归并，合并两个已排序的部分
        sum += merge(A, low, mid, high);
        
        return sum;
    }
    
    public int merge(int[] A, int low, int mid, int high){
        
        int len = high - low + 1;
        int[] B = new int[len];
        
        int i = low;
        int j = mid + 1;
        int k = 0;
        int sum = 0;
        
        //合并共同长度的部分
        while(i <= mid && j <= high){
            
            if(A[i] > A[j]){
                
                B[k++] = A[j++];

                //统计逆序对的数目（即j - i）
                //A[i] > A[j]，则要归并的后半部分中位置j之前的数，都小于要归并的前半部分中位置i之后的数）
                sum += mid - i + 1;
            }
            else{
                
                B[k++] = A[i++];
            }
        }
        
        //i长度超出的部分
        while(i <= mid){
            
            B[k++] = A[i++];
        }
        
        //j长度超出的部分
        while(j <= high){
            
            B[k++] = A[j++];
        }
        
        for(k = 0; k < len; k++){
            
            A[low + k] = B[k];
        }
        
        return sum;
    }
    
}