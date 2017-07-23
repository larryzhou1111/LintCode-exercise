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
        
        /* 两数之和: （区别于剑指offer题41-1，该题中数组是排序数组）
        
            给一个整数数组，找到两个数使得他们的和等于一个给定的数 target

            函数twoSum需要返回这两个数的下标,并且第一个下标小于第二个下标
            注意这里下标的范围是 1 到 n，不是以 0 开头
            
            注意事项:你可以假设只有一组答案
            
            样例: 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2]
        */
        
        //遍历一遍数组，把数据保存在hashmap，同时开始查找，找到则记录其index
        
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
        
        
        //类比剑指offer题41-1，排序数组中，找两数之和
        //双指针法，此解法不适用本题：如[1,0,-1], -1。输出的是[0,0]，会报错！
        /*
        if(numbers == null || numbers.length == 0)
            return null;        
        
        int start = 0;
        int end = numbers.length - 1;
        
        int[] result = new int[2];
        
        while(start < end){
            
            int curSum = numbers[start] + numbers[end];
            if(curSum == target){
                
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            else if(curSum > target){
                
                end--;
            }
            else{
                
                start++;
            }
        }
        
        return result;
        */        
    }
}