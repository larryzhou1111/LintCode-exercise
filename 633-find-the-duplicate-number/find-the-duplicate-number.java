/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/find-the-duplicate-number/
@Language: Java
@Datetime: 17-08-3 22:00
*/

public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        
        //类似剑指offer题51
        
        /*  找到数组中重复的数字
        
            给定包含n + 1个整数的数组num，其中每个整数在1和n（含）之间，
            证明至少有一个重复的数字必须存在
            
            假设只有一个重复的数字，找到重复的一个（区别于剑51，可以有多个重复元素）
         
            注意事项
                不能修改数组（假定数组是只读的）
                只能使用常数O（1）额外的空间
                运行时复杂度应小于O（n ^ 2）
                数组中只有一个重复的数字，但可以重复多次

            样例
                Given nums = [5,5,4,3,2,1] return 5
                Given nums = [5,4,4,3,2,1] return 4
        */
        
        /*  解析：
                不能修改数组，则不能排序
                空间复杂度要求常数O（1），则不能利用Map等数据结构
            
            参考：http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
        */
        
        //方法1：时间复杂度O(n * log n)
        /*
            二分枚举答案范围，使用鸽笼原理进行检验
            
            根据鸽笼原理，给定n + 1个范围[1, n]的整数，其中一定存在数字出现至少两次
            
            假设枚举的数字为 n/2：
            遍历数组，若数组中不大于 n/2 的数字个数超过 n/2，
            则可以确定[1, n/2]范围内一定有解，否则可以确定解落在[n/2, n]范围内
        */

        //方法2：将此数组看出一个有环的数组
        /*
            x_0 -> x_1 -> ... x_k -> x_{k+1} ... -> x_{k+j}
                            ^                       |
                            |                       |
                            +-----------------------+
                            
        进行环检测，查找包含重复值的循环，循环的入口即为重复值
        */
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        //快慢指针法，可类比题102、103，找链表中环的入口
        int slow = 0;  
        int fast = 0;  
        
        while(true){  
            
            slow = nums[slow];  
            fast = nums[nums[fast]];  
              
            if(slow == fast){  
                
                break;  
            }  
        }  
        
        /*
            快慢指针相遇后，调整fast = nums[0]，slow不变
            同时速度保持一致，继续移动；再次相遇的地方，就是环开始的地方
        */  
        int result = 0;  
        
        while(true){  
            
            slow = nums[slow];  
            result = nums[result];  
              
            if(slow == result){  
                
                return result;  
            }  
        }        
        
    }
}