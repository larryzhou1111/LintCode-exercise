/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/guess-number-game
@Language: Java
@Datetime: 17-06-05 14:35
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        
        //实际即二分查找
        int start = 1;
        int end = n;
        int mid;
        int tmp;
        
        while(start < end){
            
            mid = (end - start) / 2 + start;
            tmp = guess(mid);
            
            if(tmp == 0)
                return mid;
                
            else if(tmp == 1){
                start = mid + 1;
            } 
            
            else{
                end = mid - 1;
            }
        }
        return start;        
    }
}