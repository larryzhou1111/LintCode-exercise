/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 17-05-31 08:46
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int stepOne = 0;
        int stepTwo = 1;
        
        if(n==1){
            return 0;
        }
        
        if(n==2 || n==3){
            return stepTwo;
        }
        
        for(int i=3;i<=n;i++){
            
            int stepThree = stepOne+stepTwo;
            stepOne = stepTwo; 
            stepTwo = stepThree;
        }
        return stepTwo;
    }
}