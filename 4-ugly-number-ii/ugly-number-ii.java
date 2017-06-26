/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/ugly-number-ii/
@Language: Java
@Datetime: 17-06-26 22:30
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        
        /*
        方法：分成三组，每次取最小值做丑数，每组使用一个指针。然后被选中的数的指针后移
        
          (1) 1×2, 2×2, 3×2, 4×2, 5×2, …

          (2) 1×3, 2×3, 3×3, 4×3, 5×3, …

          (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

           符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
        */
        
        int[] UglyNum = new int[n];
        
        UglyNum[0] = 1;
        
        int a = 2, b = 3, c = 5;
        int indexA = 1, indexB = 1, indexC = 1;
        
        for(int i = 1; i < n; i++){
            
            int min = Math.min(Math.min(a, b), c);
            UglyNum[i] = min;
            
            if(a == min){
                
                a = UglyNum[indexA] * 2;
                indexA++;
            }
            
            if(b == min){
                
                b = UglyNum[indexB] * 3;
                indexB++;
            }
            
            if(c == min){
                
                c = UglyNum[indexC] * 5;
                indexC++;
            }
        }
        
        return UglyNum[n - 1];
    }
};
