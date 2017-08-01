/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii
@Language: Java
@Datetime: 17-06-14 14:54
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
		
        //类似剑指offer题38
		
		/* 
		    删除排序数组中的重复数字II (如果可以允许出现两次重复)
            类比题100，注意区别。本题允许数字两次重复，需回顾 ！
		*/		

        //方法1：
        /*
        if(nums == null || nums.length == 0) 
            return 0;  
            
        int startPosition = 0;  
        boolean isRepeated = false;
        
        for(int i = 1; i < nums.length; i++){  
            
            if(nums[i] != nums[startPosition]){  
                
                isRepeated = false;  
                startPosition++;  
                nums[startPosition] = nums[i];  
            } 
            else{  
                
                if (isRepeated == false){ 
                    
                    startPosition++;  
                    nums[startPosition] = nums[i];  
                    isRepeated = true;  
                }  
            }  
        }  
        
        return startPosition + 1;  
        */
        
        //方法2：
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();   
  
        int n = 0;  
        for(int i = 0; i < nums.length; i++){ 
            
            if(map.get(nums[i]) == null){  
                
                map.put(nums[i], 1);  
                nums[n++]=nums[i];  
            }
            else{  
                
                if(map.get(nums[i]) < 2){ 
                    
                    map.put(nums[i], map.get(nums[i]) + 1);  
                    nums[n++] = nums[i];  
                }  
            }  
        }  
        return n;          
        
    }
}