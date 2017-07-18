/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 17-06-12 15:40
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        
        /* 奇偶分割数组 分割一个整数数组，使得奇数在前偶数在后
        
            样例
            给定 [1, 2, 3, 4]，返回 [1, 3, 2, 4]
        */
        
        //类比题31，剑指offer题14
        
        //方法1：冒泡，交换奇数和偶数，使得奇数在前，偶数在后
        /*
        if(nums == null)
            return;
            
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i + 1; j < nums.length; j++){
                
                if(nums[i] % 2 == 0 && nums[j] % 2 != 0){
                    
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } 
            }
        }
        */
        
	    //方法2：
	    /*
	      规定两根指针start和end，分别指向数组的首尾，分别向后、向前遍历
	      若nums[start] 为偶数 且 nums[end] 为奇数，则交换这两个数
	    */
	    /*
	    int start = 0;
	    int end = nums.length - 1;
	    int temp = 0;
	    
	    while(end - start >= 0){
	        
	        //位运算，比乘除法、求余效率更高，与0x01，相当于对2取余
	        if((nums[start] & 0x01) == 0){
	            
	            if((nums[end] & 0x01) != 0){
	                
	                //交换
	                temp = nums[start];
	                nums[start] = nums[end];
	                nums[end] = temp;
	            }
	            
	            else{
	                end--;
	            }
	        }
	        
	        else{
	            start++;
	        }
	    }
        */
        
        //方法3：将方法2中判断奇偶部分抽取出来，作为判断函数，目的是解耦和功能扩展
	    int start = 0;
	    int end = nums.length - 1;
	    int temp = 0;
	    
	    while(end - start >= 0){
	        
	        //位运算，比乘除法、求余效率更高，与0x01，相当于对2取余
	        if(JudgeOddEven(nums[start])){
	            
	            if(!JudgeOddEven(nums[end])){
	                
	                //交换
	                temp = nums[start];
	                nums[start] = nums[end];
	                nums[end] = temp;
	            }
	            
	            else{
	                end--;
	            }
	        }
	        
	        else{
	            start++;
	        }
	    }        
    }
    
    //解耦和功能扩展，以后分割条件改变，只需修改此判断函数即可
    public boolean JudgeOddEven(int num){
        
        if((num & 0x01) == 0)
            return true;
        else
            return false;
            
    }
    
}