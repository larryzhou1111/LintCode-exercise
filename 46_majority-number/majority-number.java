/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 17-06-11 14:55
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        
		/*
		  给定一个整型数组，找出主元素，
		  它在数组中的出现次数严格大于数组元素个数的二分之一
		*/
		
        //分治法
		
        /*
          保持两个标记变量
		  一个统计值count初始为0，一个当前值cur遍历整个数组，用x表示当前值
		  
          当count == 0时，设cur = x, count++
          当count != 0时，若x == cur,则count++; 若x != cur,则count--
          最后返回cur
        */
        
        if (nums == null || nums.size() == 0) 
            return -1;
        
        int count = 0;
        int cur = nums.get(0);
        
        for(int i = 0; i < nums.size(); i++){
            
            //count减到0时，说明当前保存的元素，出现的次数等于数组元素个数的二分之一
            //则舍弃当前元素cur，寻找下一个元素作为cur
            if(count == 0){
                
                cur = nums.get(i);
                count = 1;
            }
            
            else{
                
                if(cur == nums.get(i)){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        return cur;        
    }
}