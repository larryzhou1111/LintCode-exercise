/*
@Author:   larryzhou
@Problem:  数字在排序数组中出现的次数
@Language: Java
@Datetime: 17-07-21 16:00
*/

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        // Write your code here
		
		/* 思路：主要利用二分查找法
			
		找数字k在排序数组中，出现的第一个和最后一个的位置，相减即得k重复次数
		
		二分查找k第一个出现的位置：
			若中间数字比k大，则k只可能出现在前半段，递归继续在前半段查找；
			若中间数字比k小，则k只可能出现在后半段，递归继续在后半段查找；
			若中间数字等于k：
				如果中间数字的前一个数字是k，则第一个k还是只可能出现在前半段，递归继续在前半段查找；
				如果中间数字的前一个数字不是k，则此时的中间位置，正好是第一个k；		
		
		同理可得：二分查找k最后一个出现的位置
		*/
		
        if(array == null || array.length == 0)
            return 0;
        
        int number = 0;
        
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        
        if(first >= 0 && last >= 0){
            
            number = last - first + 1;
        }
        
        return number;
    }
    
    public int getFirstK(int[] array, int k, int start, int end){
        
        if(start > end)
            return -1;
        
        int middle = (end - start) / 2 + start;
        
        if(array[middle] == k){
            
            if((middle > 0 && array[middle - 1] != k) || middle == 0){
                
                return middle;
            }
            else{
                end = middle - 1;
            }
        }   
        else if(array[middle] > k){
                
            end = middle - 1;
        }
        else{
            start = middle + 1;
        }
        
        return getFirstK(array, k, start, end);
    }
    
    public int getLastK(int[] array, int k, int start, int end){
        
        if(start > end)
            return -1;
        
        int middle = (end - start) / 2 + start;
        
        if(array[middle] == k){
            
            if((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1){
                
                return middle;
            }
            else{
                start = middle + 1;
            }
        }   
        else if(array[middle] < k){
                
            start = middle + 1;
        }
        else{
            end = middle - 1;
        }
        
        return getLastK(array, k, start, end);
    }
    
}
