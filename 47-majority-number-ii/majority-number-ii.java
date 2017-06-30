/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/majority-number-ii/
@Language: Java
@Datetime: 17-06-30 22:00
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        
        //类比题46
        
        /* 思路：
           如果发现3个不一样的数就进行消掉
           记录两个candidate和每个candidate分别的出现次数
           如果遍历到的数和两个candidate都不等，就将其对应的count都减1
           最后将两个candidate再遍历一次,验证一下谁出现的次数多,谁就是主元素
        */
        
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for(int i = 0; i < nums.size(); i++){
            
            if(candidate1 == nums.get(i) || count1 == 0){
                
                count1++;
                candidate1 = nums.get(i);
            }
            
            else if(candidate2 == nums.get(i) || count2 == 0){
                
                count2++;
                candidate2 = nums.get(i);
            }
            
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int j = 0; j < nums.size(); j++){
            
            count1 += (candidate1 == nums.get(j)) ? 1 : 0;
            count2 += (candidate2 == nums.get(j)) ? 1 : 0;
        }
        
        return count1 > count2 ? candidate1 : candidate2;
        
    }
}
