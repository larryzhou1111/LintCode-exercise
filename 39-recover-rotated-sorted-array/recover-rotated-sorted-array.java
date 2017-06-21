/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/recover-rotated-sorted-array/
@Language: Java
@Datetime: 17-06-21 21:54
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        
        //类比题8，旋转字符串
        
        //方法1：依次比较数组第一个和最后一个元素，如果大于，则移除第一个元素，并追加其到数组末尾
        
        int numslen = nums.size();
        
        for(int i = 0; i < numslen; i++){
            
            if(nums.get(0) >= nums.get(numslen - 1)){
                
                int tmp = nums.get(0);
                nums.remove(nums.get(0));
                nums.add(tmp);
            }

        }
        
        
        //方法2：先找到中间的临界点，前半部分逆序，后半部分逆序，整体再逆序
        /*
        int numslen = nums.size();
        
        for(int i=0; i < numslen - 1; i++){
            
            //找到分界点
            if(nums.get(i) > nums.get(i + 1)){
                
                reverse(nums, 0, i);
                reverse(nums, i + 1, numslen - 1);
                reverse(nums, 0, numslen - 1);
            }
        }
 
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end){
        
        while(start < end){
            
            int tmp = nums.get(start);
            
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            
            start++;
            end--;
        }
        */
    }
}