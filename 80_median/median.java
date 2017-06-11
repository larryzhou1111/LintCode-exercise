/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 17-06-11 13:41
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        
        
        //方法1：数组排序函数
        Arrays.sort(nums);
        
        int len = nums.length;
        
        if(len % 2 == 0){
            
            return nums[len/2 - 1];
        }
        
        else{
            
            return nums[len/2];
        } 
        
        
        /*
        //方法2：快排排序
        int len = nums.length;
        
        return QuickSort(nums, 0, len-1, (len + 1)/2);             

    }
    
    public int QuickSort(int[] nums, int start, int end, int size){
        
        int mid = (end - start) / 2 + start;
        //设置快排的枢轴值为，原始数组的中间位置的值
        int pivot = nums[mid];
        
        //设置低位和高位
        int i = start - 1;
        int j = end + 1;
        
        for(int k = start; k < j; k++){
            
            if(nums[k] < pivot){
                
                i++;
                //交换nums[i] 和 nums[k]，把小的值，交换到当前枢轴值左边
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;                
            }
            
            else if(nums[k] > pivot){
                
                j--;
                //交换nums[j] 和 nums[k]，把大的值，交换到当前枢轴值右边
                int tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp; 
                
                k--;
            }
        }    
        
        if(i - start + 1 >= size){
            //递归低位数组
            return QuickSort(nums, start, i, size);
        } 
        
        else if(j - start < size){
            //递归高位数组
            return QuickSort(nums, j, end, size - (j - start));            
        } 
        
        else{
            return nums[j-1];
        }
    */  
    
        //方法3：使用堆 heap (待补充！)
        /*
          1.使用大顶堆+小顶堆的容器. 
          2.两个堆中的数据数目差不能超过1，则使中位数只会出现在两个堆的交接处
          3.其中最大堆来保存数组中较小的一半的数，最小堆保存较大的另一半数。当元素为数组的奇数个时，插入到最大堆中，元素为数组的偶数个时，插入到最小堆中，这样，最大堆的堆顶即为中位数。
        */
    }    
}
