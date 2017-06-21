/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/count-and-say/
@Language: Java
@Datetime: 17-06-21 14:54
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        
        if(n <= 0)
            return null;
            
        String result = "1";
        
        for(int i = 2; i <= n; i++){
            
            StringBuilder sb = new StringBuilder();
            
            //用来计数
            int count = 1;
            
            //遍历一次
            for(int j = 1; j < result.length(); j++){
                
                if(result.charAt(j) == result.charAt(j - 1)){
                    
                    //数字重复次数
                    count++;
                }
                
                else{
                    
                    //先添加重复次数，再添加该数字
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    
                    //将计数置为1，然后返回遍历中，重新计数
                    count = 1;
                }
            }
            
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            
            result = sb.toString();
        }
        
        return result;
    }
}