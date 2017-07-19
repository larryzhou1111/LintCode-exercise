/*
@Author:   larryzhou
@Problem:  栈的压入弹出序列
@Language: Java
@Datetime: 17-07-19 16:00
*/

       
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
		// write your code here
		
		/* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
		
			假设压入栈的所有数字均不相等！
			
			例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
			但4,3,5,1,2就不可能是该压栈序列的弹出序列
        */
        
        /*
			思路：
			建立一个辅助栈，依次把压栈序列的元素压入栈，
			如果当前要弹栈的元素恰好在栈顶，直接弹出即可，
			如果不在栈顶，就把压栈序列中尚未压栈的元素依次压入栈顶，直到把当前需要弹栈的元素压入栈为止，
			如果所有的元素都压栈了，还没有找到下一个数字，则证明这不是当前压栈序列的一个弹出序列
		*/
		
        if(pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
            return false;
		
		//辅助栈
        Stack<Integer> stack = new Stack<>();
	   
        int j = 0;
		
        for(int i = 0; i < pushA.length; i++){
			
            stack.push(pushA[i]);
			
            while(!stack.isEmpty() && stack.peek() == popA[j] && j < popA.length){
				
                stack.pop();
                j++;
            }
       }
	   
	   //如果要满足要求，辅助栈中的元素最后都弹出了
       return stack.empty()==true;
    }
}