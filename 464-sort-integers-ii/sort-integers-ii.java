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
                
                B[k++] = A[j++];
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
        
        */
        
        /*
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
    
    //重新安排数字的位置，使所有比中枢点小的数到左半边，大于中枢点的数到右半边
    //等于中枢点的数可在任意一边，则数组就被分为了两段，注意两段的长度可以不相等
    //下面是优化版的获取中枢点的方法，不交换直接替换
    public int partition(int[] A, int start, int end){
        
        int pivot = A[start];

        while(start < end){
            
            while(start < end && A[end] >= pivot){
                
                end--;
            }
            
            //跳出上述循环时，A[end] < pivot；
            //只是为了得到中枢点，此时可以直接替换，而不用交换
            
            //int tmp = A[start];
            //A[start] = A[end];
            //A[end] = tmp;
            
            A[start] = A[end];

            while(start < end && A[start] <= pivot){
                
                start++;
            }
            
            A[end] = A[start];
        }
        
        A[start] = pivot;
        
        return start;
        */
        
        //方法3：堆排序
        for(int i = A.length / 2 - 1; i >= 0; i--) {
            
            //构建一个大顶堆
            adjustHeap(A, i, A.length - 1);
        }
        
        for(int j = A.length - 1; j > 0; j--){
            
            //将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = A[0];
            A[0] = A[j];
            A[j] = temp;
            
            //将a中前i-1个记录重新调整为大顶堆
            adjustHeap(A, 0, j - 1);
        }
    }
    
    //构建大顶堆
    public void adjustHeap(int[] A, int i, int len) {
        
        int temp = A[i];

        for(int j = 2 * i; j < len; j *= 2) {
            
            //沿关键字较大的孩子结点向下筛选
            if(j < len && A[j] < A[j + 1]){
                
                //j为关键字中较大记录的下标
                ++j;
            }
  
            if(temp >= A[j])
                break;
                
            A[i] = A[j];
            i = j;
        }
        
        A[i] = temp;
    }
}