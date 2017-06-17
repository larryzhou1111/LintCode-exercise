/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/sqrtx/
@Language: Java
@Datetime: 17-06-17 14:54
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        
        int low = 0, high = x;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            long square = (long)mid * (long)mid;
            long square1 = (long)(mid + 1) * (long)(mid + 1);
            long square2 = (long)(mid - 1) * (long)(mid - 1);

            //逼近法
            if(square == x) 
                return mid;
                
            if(square < x && square1 > x) 
                return mid;
                
            if(square > x && square2 < x) 
                return mid - 1;
                
            if(square < x){ 
                
                low = mid + 1;
            }
            else{
                
                high = mid - 1;
            }
        }
        return -1;        
    }
}