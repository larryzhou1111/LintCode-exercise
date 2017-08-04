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
        */
        
        //方法1：时间复杂度O(n),空间复杂度O(1)
        /*
            从头到尾依次扫描数组中的每个数字
            
            当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i
            如果是，接着扫描下一个数字；
            如果不是，再拿它和第m个数字进行比较
            
            如果它和第m个数字相等，就找到了一个重复数字（位置为i和m）
            如果它和第m个数字不等，就把第i和第m个数字交换，把m放到属于它的位置
            
            重复比较、交换，直到找到重复的数字
            
            给出数组[5,5,4,3,2,1] -交换-> [1,5,4,3,2,5] 
                    -交换-> [5,1,4,3,2,5] --> 5==5，找到重复元素
        */
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
            
        int duplicate = Integer.MIN_VALUE;    
        
        for(int i = 0; i < nums.length; i++){
            
            while(nums[i] != i){
                
                if(nums[i] == nums[nums[i]]){
                    
                    duplicate = nums[i];
                    break;
                }
                else{
                    
                    //把第i和第m个数字交换，把m放到属于它的位置
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }
        
        return duplicate;
        
        
        //方法2：将此数组看出一个有环的数组
        /*
            x_0 -> x_1 -> ... x_k -> x_{k+1} ... -> x_{k+j}
                            ^                       |
                            |                       |
                            +-----------------------+
                            
        进行环检测，查找包含重复值的循环，循环的入口即为重复值
        参考：http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
        */
        /*
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
        
        //快慢指针相遇后，调整fast = nums[0]，slow不变
        //同时速度保持一致，继续移动；再次相遇的地方，就是环开始的地方
        
        int result = 0;  
        
        while(true){  
            
            slow = nums[slow];  
            result = nums[result];  
              
            if(slow == result){  
                
                return result;  
            }  
        }        
        */
    }
}