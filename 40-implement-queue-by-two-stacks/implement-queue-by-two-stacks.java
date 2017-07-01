/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/implement-queue-by-two-stacks/
@Language: Java
@Datetime: 17-7-1 11:00
*/

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /* 用栈实现队列
    
       正如标题所述，你需要使用两个栈来实现队列的一些操作。

        队列应支持push(element)，pop() 和 top()，
        其中pop是弹出队列中的第一个(最前面的)元素。
        pop和top方法都应该返回第一个元素的值。

        比如push(1), pop(), push(2), push(3), top(), pop()，你应该返回1，2和2
    */

    public MyQueue() {
       // do initialization if necessary
       
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        
        if(!stack2.empty()){
            
            return stack2.pop();
        }
        
        else{
            
            while(stack1.size() > 1){
                
                stack2.push(stack1.pop());
            }
            
            return stack1.pop();
        }
    }

    public int top() {
        // write your code here
        
        if(!stack2.empty()){
            
            return stack2.peek();
        }
        
        else{
            
            while(!stack1.empty()){
                
                stack2.push(stack1.pop());
            }
            
            return stack2.peek();
        }
    }
    
}