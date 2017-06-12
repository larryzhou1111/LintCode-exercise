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
        
        //冒泡，交换奇数和偶数，使得奇数在前，偶数在后
        if(nums != null){
            
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
        }
    }
}