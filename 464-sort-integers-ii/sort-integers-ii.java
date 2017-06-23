/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/sort-integers-ii/
@Language: Java
@Datetime: 17-06-23 21:30
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        
        //类比题463
        
        /*
        //方法1：归并排序，递归实现归并
        if(A == null || A.length <= 1)
            return;
            
        int low = 0;
        int high = A.length - 1;
        
        mergeSort(A, low, high);
        
    }
    
    public void mergeSort(int[] A, int low, int high){
        
        if(low >= high)
            return;
            
        int mid = (high - low) / 2 + low;
        
        //递归，对中间值mid左右，分别进行递归排序
        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        
        //归并，合并两个已排序的部分
        merge(A, low, mid, high);
        
    }
    
    //此部分可类比题6，合并两个已排序的数组
    public void merge(int[] A, int low, int mid, int high){
        
        int len = high - low + 1;
        int[] B = new int[len];
        
        int i = low;
        int j = mid + 1;
        int k = 0;
        
        //合并共同长度的部分
        while(i <= mid && j <= high){
            
            if(A[i] > A[j]){
                
                B[k++] = A[j];
                j++;
            }
            else{
                
                B[k++] = A[i];
                i++;
            }
        }
        
        //i长度超出的部分
        while(i <= mid){
            
            B[k++] = A[i];
            i++;
        }
        
        //j长度超出的部分
        while(j <= high){
            
            B[k++] = A[j];
            j++;
        }
        
        for(k = 0; k < len; k++){
            
            A[low + k] = B[k];
        }
    */  
    
        //方法2：快排
        if(A == null || A.length <= 1)
            return;
    
        quickSort(A, 0, A.length - 1);
    
    }
    
    public void quickSort(int[] A, int start, int end){
        
        if(start >= end)
            return;
        
        //得到中枢点    
        int pivot = partition(A, start, end);
        
        //针对中枢点左右，分别进行递归，快速排序
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
        
    }
    
    //重新安排数字的位置，使所有比中枢点小的数到左半边，所有大于中枢点的数到右半边
    //等于中枢点的数可在任意一边，则数组就被分为了两段，注意两段的长度可以不相等
    public int partition(int[] A, int start, int end){
        
        int pivot = A[start];
        int i = start;
        int j = end;
        
        while(i < j){
            
            while(i < j && A[j] >= pivot){
                
                j--;
            }
            
            if(i < j){
                
                A[i] = A[j];
            }
            
            while(i < j && A[i] <= pivot){
                
                i++;
            }
            
            if(i < j){
                
                A[j] = A[i];
            }            
            
        }
        
        A[i] = pivot;
        return i;
        
    }
}