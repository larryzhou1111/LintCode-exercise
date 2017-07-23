/*
@Author:   larryzhou
@Problem:  扑克牌的顺子（剑指offer题44）
@Language: Java
@Datetime: 17-07-23 11:00
*/

public class Solution {
    public boolean isContinuous(int [] numbers) {
        
		/*
		  从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌是不是连续的
		  
		  A为1、2-10为数字本身、J为11、Q为12、K为13，大小王可以看成任意数字
		
		  满足条件:
			1) max - min < 5
            2) 除0外没有重复的数字(牌)
            3) 数组长度为 5
			
		  思路：
			1、排序 
			2、计算所有相邻数字间隔总数 
			3、计算0的个数 
			4、如果2、3相等，就是顺子 
			5、如果出现对子，则不是顺子
		*/
        if(length == 0)
           return false;	
	
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = numbers.length;
         
        Arrays.sort(numbers);
        
        for(int i = 0; i < length - 1; i++){
            
            //计算癞子数量
            if(numbers[i] == 0){
	
                numOfZero++;
                continue;
            }
            
            //对子，直接返回
            if(numbers[i] == numbers[i + 1]){
	
                return false;
            }
            
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        
        if(numOfZero >= numOfInterval){
            
            return true;
        }
        
        return false;
    }
}