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

	//剑指offer题7
	
    /* 用栈实现队列
    
       正如标题所述，你需要使用两个栈来实现队列的一些操作。

        队列应支持push(element)，pop() 和 top()，
        其中pop是弹出队列中的第一个(最前面的)元素。
        pop和top方法都应该返回第一个元素的值。

        比如push(1), pop(), push(2), push(3), top(), pop()，你应该返回1，2和2
    */
    
    /* 思路：
    
       入队：将元素放入stack1顶部
       出队：取stack2顶元素
       
                |  |
        stack1  |  |    |
                |__|    |
                 __     | 队列方向
                |  |    |
        stack2  |  |   \ /
                |  |     
       
       因此，当stack2空时，将stack1内元素倒入stack2即可
       当出队倒入时，可少倒最后一个元素，直接从stack1出队
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
            
            //pop 返回栈顶的值，会把栈顶的值删除            
            return stack2.pop();
        }
        
        else{
            
            //当stack2空时，将stack1内元素倒入stack2
            //倒入时，可少倒最后一个元素，直接从stack1出队
            while(stack1.size() > 1){
                
                stack2.push(stack1.pop());
            }
            
            return stack1.pop();
        }
    }

    public int top() {
        // write your code here
        
        if(!stack2.empty()){
            
            //peek 返回栈顶的值，但不改变栈的值(不删除栈顶的值)
            return stack2.peek();
        }
        
        else{
            
            while(!stack1.empty()){
                
                stack2.push(stack1.pop());
            }
            
            return stack2.peek();
        }
    }
	
	/* 队列 queue   参考：http://www.cnblogs.com/end/archive/2012/10/25/2738493.html
	
	    add：    添加一个元素，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
		offer：  添加一个元素并返回true，如果队列已满，则返回false
		put：    添加一个元素，如果队列满，则阻塞
				
		remove： 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
		poll：   移除并返问队列头部的元素，如果队列为空，则返回null
		take：   移除并返回队列头部的元素，如果队列为空，则阻塞
		
		element：返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
		peek：   返回队列头部的元素，如果队列为空，则返回null

	*/
	
	//类比：用两个队列实现一个栈
	/*思路：
		对于push: 如果两个队列都为空，就插入到第一个队列中；否则就插入到非空的那个队列中；
        对于pop: 把非空的那个队列的每个元素移除出来，然后插入到另一个队列中，
				 直到剩下最后一个元素，然后将其弹出
	*/
	/*
	    Queue<integer> queue1 = new ArrayDeque<>();
		Queue<integer> queue2 = new ArrayDeque<>();
	 
		public void push(int node) {
			
			//两个栈都为空时，优先考虑queue1
			if (queue1.isEmpty()&&queue2.isEmpty()) {
				queue1.add(node);
				return;
			}
	 
			//如果queue1为空，queue2有元素，直接放入queue2
			if (queue1.isEmpty()) {
				queue2.add(node);
				return;
			}
	 
			if (queue2.isEmpty()) {
				queue1.add(node);
				return;
			}
	 
		}
	 
		public int pop() {
			
			//两个栈都为空时，没有元素可以弹出
			if(queue1.isEmpty()&&queue2.isEmpty()){
				
				try {
					throw new Exception(stack is empty);
				} catch (Exception e) {
				}
			}
			
			//如果queue1为空，queue2有元素，将queue2的元素依次放入queue1中
			//queue2中留下最后一个元素，弹出
			if(queue1.isEmpty()){
				
				while(queue2.size()>1){
					
					queue1.add(queue2.poll());
				}
				
				return queue2.poll();
			}
	 
			if(queue2.isEmpty()){
				
				while(queue1.size()>1){
					
					queue2.add(queue1.poll());
				}
				
				return queue1.poll();
			}
	 
			return (Integer) null;
		}
	*/
    
}