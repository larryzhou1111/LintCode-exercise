/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/4sum/
@Language: Java
@Datetime: 17-06-24 19:30
*/

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        
        //类比题57 三数之和
        
        //先对数组排序，然后开始遍历
        //确定4元数中的前2个，另外两个，用两指针往中间夹，直到找出等于target的四数之和
       
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();        
        
        if(numbers == null || numbers.length < 4)
            return result;
        
        int[] tmp = new int[4];
        
        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length - 3; i++){
            
            tmp[0] = numbers[i];
            
            for(int j = i + 1; j < numbers.length - 2; j++){
            
                tmp[1] = numbers[j];
            
                int left = j + 1;
                int right = numbers.length - 1;
                int sum = target - numbers[i] - numbers[j];
            
                while(left < right){
                    
                    ArrayList<Integer> stepResult = new ArrayList<Integer>();
                    
                    int twosum = numbers[left] + numbers[right];
                    
                    if(twosum == sum){
                        
                        tmp[2] = numbers[left];
                        tmp[3] = numbers[right];
                        
                        for(int k = 0; k < 4; k++){
                            
                            stepResult.add(tmp[k]);
                        }
                        
                        //确保结果集的唯一性。无重复时，添加到result
                        if(!result.contains(stepResult)){  
                               
                            result.add(stepResult);  
                        }   
                    }
                    
                    if(twosum < sum){
                        
                        left++;
                    }
                    else{
                        
                       right--; 
                    } 
                }
            }
        }
        
        return result;
    }
}