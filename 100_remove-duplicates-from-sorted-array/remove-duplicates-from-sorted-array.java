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
		
        //类似剑指offer题38
		
		/*  删除排序数组中的重复数字
		
		    给定一个排序数组，在原数组中删除重复出现的数字，
		    使得每个元素只出现一次，并且返回新的数组的长度

            不要使用额外的数组空间，必须在原地没有额外空间的条件下完成

            样例: 给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]
		*/       
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