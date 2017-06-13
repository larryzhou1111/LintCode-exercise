/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 17-06-13 15:54
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        
        if(nums == null)
            return 0;
            
        int len = nums.length;
        
        for(int i = 0, j = 1; i <= j && j < nums.length;){
            
            if(nums[i] != nums[j]){
                
                //元素不同时，将后指针指向元素,放前指针指向元素的下一位置,两指针顺次后移
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
            
            //元素相同时，前指针不动，后指针顺次后移，总长度减一
            else{
                
                j++;
                len--;
            }
        }
        return len;
    }
}