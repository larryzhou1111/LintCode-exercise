/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 17-06-11 15:10
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        
        //从前向后，冒泡移动0
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i + 1; j < nums.length; j++){
                
                if(nums[i] == 0){
                    
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp; 
                }
            }
        }
    }
}