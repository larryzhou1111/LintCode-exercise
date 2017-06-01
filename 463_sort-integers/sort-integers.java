/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/sort-integers
@Language: Java
@Datetime: 17-05-31 12:39
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
    /*    
        //冒泡排序
        int i,j;
        for(i=1;i<A.length;i++){
            
           for(j=A.length-1;j>=i;j--){
               
                if(A[j-1] > A[j]){
                    
                    int a;
                    a = A[j-1];
                    A[j-1] = A[j];
                    A[j] = a;
                }
            } 
        }
    } 
    */
    
    /*
        //改进版冒泡排序
        int i,j;
        boolean flag = true;
        
        //若flag为true则退出循环
        for(i=1;i<A.length && flag;i++){
            
            flag = false;
            for(j=A.length-1;j>=i;j--){
                
                if(A[j-1] > A[j]){
                    
                    int a;
                    a = A[j-1];
                    A[j-1] = A[j];
                    A[j] = a;
                    
                    //如果有数据交换，则flag为true
                    flag = true;
                }
            }
        }
    }
    */
    
   /* 
    //选择排序
    int i,j,min;
    for(i=0;i<A.length;i++){
        
        //假设i是最小值，从n-i中选择最小的值与i进行比较
        min = i;
        for(j=i+1;j<A.length;j++){
            
            if(A[min]>A[j]){
                //如果有小于当前最小值的关键字，将其下标复制给min
                min = j;
            }
        }    
        
        if(i!=min){
            //如果下标min与i不一致，说明找到最小值，则交换
            int a;
            a = A[min];
            A[min] = A[i];
            A[i] = a;                
        }
    }
  } 
  */
  
  //插入排序
  /*
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
     * 将新元素插入到该位置中  
     * 重复步骤2 
  */
  int i,j,k;
  for(i=0;i<A.length;i++){
      
      k = A[i];
      //假如k比前面的值小，则将前面的值后移
      for(j=i;j>0 && k<A[j-1];j--){
          A[j] = A[j-1];
      }
      A[j] = k;
    }
  }
}



