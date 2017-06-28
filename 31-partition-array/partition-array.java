/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/partition-array/
@Language: Java
@Datetime: 17-06-27 22:00
*/

/*
    给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），
	使得：

	所有小于k的元素移到左边
	所有大于等于k的元素移到右边
	返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。

	注意事项

	你应该真正的划分数组 nums，而不仅仅只是计算比 k 小的整数数，
	如果数组 nums 中的所有元素都比 k 小，则返回 nums.length。 
*/
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    
	    //方法1：先排序，再遍历找到k附近的元素。复杂度略高！
	    /*
	    if(nums == null || nums.length == 0)
	        return 0;
	        
	    Arrays.sort(nums);
	    int index = 0;
	    
	    if(nums[nums.length - 1] < k)
	        return nums.length;
	    
	    for(int i = 0; i < nums.length; i++){
	        
	        if(nums[i] < k && nums[i + 1] >= k){
	          
	            index = i + 1;
	            break;
	        }
	    }
	    
	    return index;
	    */
	    
	    //方法2：规定两根指针start和end分别指向数组的首尾，分别向后，向前遍历
	    //若nums[start] > k 且 nums[end] < k，则交换这两个数
	    //而最终start的值，即为i的位置
	    
	    int start = 0;
	    int end = nums.length - 1;
	    int temp = 0;
	    
	    while(end - start >= 0){
	        
	        if(nums[start] >= k){
	            
	            if(nums[end] < k){
	                
	                //交换
	                temp = nums[start];
	                nums[start] = nums[end];
	                nums[end] = temp;
	            }
	            
	            else{
	                end--;
	            }
	        }
	        
	        else{
	            start++;
	        }
	    }
	    
	    return start;
    }
}