/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/valid-parentheses/
@Language: Java
@Datetime: 17-06-20 21:54
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        
        if(s == null || s.length() == 0 || s.length() % 2 != 0)
            return false;
            
        //定义一个装载char类型数据的栈，栈也属于集合，装载对象，而不能直接装载基本数据类型
        Stack<Character> stack = new Stack<Character>();
        
        //定义一个标志，也是最终返回的结果
        boolean flag = true;
        
        //遍历字符串s
        for(int i = 0; i < s.length(); i++){
            
            //如果遇到'(' , '[' , '{' ,则压如栈中
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                
                stack.push(s.charAt(i));
            }
            
            else if(s.charAt(i) == ')'){
                
                //判断stack栈是否为空，且栈顶元素与s的相应字符匹配，  
                //如果匹配，则栈顶元素出栈；否则，整个字符串都字符串不匹配，跳出循环；
                
                // peek()查看栈顶对象而不移除它
                if(!stack.empty() && stack.peek() == '('){
                    
                    // pop()移除栈顶对象，并作为函数的值返回该对象
                    stack.pop();
                }
                else{
                    
                    flag = false;
                    break;
                }
            }
            
            else if(s.charAt(i) == ']'){
                
                //判断stack栈是否为空，且栈顶元素与s的相应字符匹配，  
                //如果匹配，则栈顶元素出栈；否则，整个字符串都字符串不匹配，跳出循环；
                if(!stack.empty() && stack.peek() == '['){
                    
                    stack.pop();
                }
                else{
                    
                    flag = false;
                    break;
                }                
            }
            
            else if(s.charAt(i) == '}'){
                
                //判断stack栈是否为空，且栈顶元素与s的相应字符匹配，  
                //如果匹配，则栈顶元素出栈；否则，整个字符串都字符串不匹配，跳出循环；
                if(!stack.empty() && stack.peek() == '{'){
                    
                    stack.pop();
                }
                else{
                    
                    flag = false;
                    break;
                }                
            }
        }
        
        //遍历一遍字符串后，看栈是否为空，如果不为空，则该字符串不匹配；  
        if(!stack.empty()){ 
            
            flag = false;  
        }  
          
        return flag;
    }
}