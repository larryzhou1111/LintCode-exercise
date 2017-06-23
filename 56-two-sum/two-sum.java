/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/two-sum/
@Language: Java
@Datetime: 17-06-23 21:30
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        
        //思路：遍历一遍数组，把数据保存在hashmap，同时开始查找，找到则记录其index
        
        if(numbers == null || numbers.length == 0)
            return null;
            
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        
        for(int i = 0; i < numbers.length; i++){
            
            //target = numbers[i] + numbers[j]，检验numbers[j]是否在map中
            if(map.containsKey(target - numbers[i])){
                
                //保证index1 < index2，且index从1开始，不是从0，需要注意！
                if(i < map.get(target - numbers[i])){
                    
                    result[0] = i + 1;
                    result[1] = map.get(target - numbers[i]) + 1;
                    break;
                }
                
                else{
                    
                    result[0] = map.get(target - numbers[i]) + 1;
                    result[1] = i + 1;
                    break;
                }
                
            }
            
            map.put(numbers[i], i);
        }
        
        return result;
    }
}