/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/min-stack/
@Language: Java
@Datetime: 17-7-3 11:00
*/

//剑指offer题2
		
/*  带最小值操作的栈

    实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
    你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
*/

/*
//方法1：用两个栈来实现
public class MinStack {
    
    private Stack<Integer> stack;
    
    //minStack作为辅助，仅存入min的integer
    //min = Integer.parseInt(minStack.peek().toString());
    private Stack<Integer> minstack;    
    
    public MinStack() {
        // do initialize if necessary
        
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        
        stack.push(number);
        
        if(minstack.isEmpty()){
            
            minstack.push(number);
        }
        else{
            
            minstack.push(Math.min(number, minstack.peek()));
        }
        
    }

    public int pop() {
        // write your code here
        
        minstack.pop();
        return stack.pop();

    }

    public int min() {
        // write your code here
        
        return minstack.peek();
    }
}
*/

//方法1的类似版
public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }


    public void push(int number) {
        
        stack.push(number);
        
        if(minStack.isEmpty()){
            
            minStack.push(number);
        }
        
        else{
            
            // 这里考虑的相等的情况也会继续push
            if (minStack.peek() >= number){
            
                minStack.push(number);
            }
        }    
    }


    public int pop() {
        
        if(stack.peek().equals(minStack.peek())){
            
            minStack.pop();
        }  
        
        return stack.pop();
    }


    public int min() {
        
        return minStack.peek();
    }
}

//方法3：
/*
public class MinStack {
    
    Stack<Integer> stack;
    int min;
    
    public MinStack() {
        // do initialize if necessary
        
        stack = new Stack<Integer>();
        min = 0;
        
    }

    public void push(int number) {
        // write your code here
        
        if(stack.size() == 0){
            
            stack.push(number);
            min = number;
        }
        
        else{
            
            if(number >= min){
                
                stack.push(number);
            }
            else{
                
                stack.push(2 * number - min);
                min = number;
            }
        }
        
    }

    public int pop() {
        // write your code here
        
        if(!stack.isEmpty()){
            
            int temp = stack.pop();
            
            if(temp < min){
                
                int num = min;
                min = 2 * min - temp;
                temp = num;
            }
            
            return temp;
        }
        
        else 
            return min;

    }

    public int min() {
        // write your code here
        
        return min;
    }
}
*/