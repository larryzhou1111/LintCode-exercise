/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/subarray-sum/
@Language: Java
@Datetime: 17-06-24 19:30
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        
        //思路：使用Map来记录index, sum的值
        //当遇到两个index的sum相同时，表示从index1+1到index2是一个解
        //注意：添加一个index = -1作为虚拟节点。这样我们才可以记录index1 = 0的解
       
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0){
            
            return result;
        }
        
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];
            
            if(map.containsKey(sum)){
                
                result.add(map.get(sum) + 1);
                result.add(i);
                
                return result;
            }
            
            map.put(sum, i);
        }
        
        return result;
    }
}