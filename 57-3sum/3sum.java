/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/3sum/
@Language: Java
@Datetime: 17-06-23 21:30
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        
        //类比题56. 需回顾！
        
        //先对数组排序，然后开始遍历
        //对数组中的每一个元素，用两指针往中间夹，直到找出所有的解。时间复杂度 O(n^2).
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length; i++){
            
            int left = i + 1;
            int right = numbers.length - 1;
            
            while(left < right){
                
                ArrayList<Integer> stepResult = new ArrayList<Integer>();
                
                int sum = numbers[i] + numbers[left] + numbers[right];
                
                if(sum == 0){
                    
                    stepResult.add(numbers[i]);
                    stepResult.add(numbers[left]);
                    stepResult.add(numbers[right]);
                    
                    //将当前list添加到result中
                    if(!result.contains(stepResult)){ 
                        
                        result.add(stepResult);
                    }    
                }
                
                if(sum < 0){
                    
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