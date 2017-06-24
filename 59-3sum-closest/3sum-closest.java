/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/3sum-closest/
@Language: Java
@Datetime: 17-06-24 19:30
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        
        //类比题57 三数之和
        
        //先对数组排序，然后开始遍历
        //对数组中的每一个元素，用两指针往中间夹，直到找出三数之和最接近的解
        
        if(numbers == null || numbers.length < 3)
            return -1;
        
        //避免溢出
        int result = Integer.MAX_VALUE / 2;
        
        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length; i++){
            
            int left = i + 1;
            int right = numbers.length - 1;
            
            while(left < right){
                
                int sum = numbers[i] + numbers[left] + numbers[right];
                
                //判断当前sum值，还是result中的值，谁与target更接近
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    
                    result = sum;
                }   
                
                if(sum < target){
                    
                    left++;
                }
                else{
                    
                   right--; 
                } 
            }
        }
        
        return result;
    }
}
