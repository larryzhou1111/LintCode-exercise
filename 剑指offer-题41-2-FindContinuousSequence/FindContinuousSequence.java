/*
@Author:   larryzhou
@Problem:  连续正数序列中，找等于给定值的连续子序列（至少含两个数）（剑指offer题41-2）
@Language: Java
@Datetime: 17-07-23 11:00
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		
		/*  例如：[1,2,3...n] 输入15：
			
			则有三个连续子序列符合要求：1+2+3+4+5 = 4+5+6 = 7+8 = 15
		*/
		
		//双指针法，指针分别从第一位和第二位出发
		/*
			初始化small=1，big=2;
			small到big序列和小于sum，big++;大于sum，small++;
			当small增加到(1+sum)/2时停止
		*/
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        if(sum <= 1)
			return lists;

        int small =1;
        int big = 2;
		
		//当small==(1+sum)/2的时候停止
        while(small != (1 + sum) / 2){  
        
            int curSum = sumOfList(small, big);

            if(curSum == sum){
	
                ArrayList<Integer> list = new ArrayList<Integer>();

                for(int i = small; i <= big; i++){
	
                    list.add(i);
                }

                lists.add(list);
                small++;
				big++;
            }
			else if(curSum < sum){
				
                big++;
            }
			else{
                small++;
            }
        }

        return lists;
    }
     
    public int sumOfList(int head,int leap){        

		//计算当前序列的和
        int sum = head;
        for(int i = head + 1; i <= leap; i++){
	
            sum += i;
        }

        return sum;
    }
}