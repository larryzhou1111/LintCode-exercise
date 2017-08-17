/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/maximum-subarray-ii/
@Language: Java
@Datetime: 17-08-17 22:00
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        
        /*  最大子数组 II 
            给定一个整数数组，找出两个不重叠子数组使得它们的和最大
            
            每个子数组的数字在数组中的位置应该是连续的，返回最大的和

            注意事项：子数组最少包含一个数
            
            样例：给出数组 [1, 3, -1, 2, -1, 2]
            
            这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]
            它们的最大和都是 7
        */
        
        /*
            思路：
            因为两个subarray一定不重叠，所以必定存在一条分割线，分开这两个subarrays
            
            枚举这条分割线的位置
            
            然后分别保存某个位置往左的maximum subarray 和往右的 maximum subarray
        */
        if(nums == null || nums.size() == 0)
            return Integer.MIN_VALUE;
            
        int size = nums.size();
        
        int[] left = new int[size];
        int[] right = new int[size];
        
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;

        //从前往后遍历        
        for(int i = 0; i < size; i++){
            
            sum += nums.get(i);
            
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            
            left[i] = max;
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        
        //从后往前遍历
        for(int i = size - 1; i >= 0; i--){
            
            sum += nums.get(i);
            
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            
            right[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        
        for(int i = 0; i < size - 1; i++){
            
            max = Math.max(max, left[i] + right[i + 1]);
        }
        
        return max;
    }
}