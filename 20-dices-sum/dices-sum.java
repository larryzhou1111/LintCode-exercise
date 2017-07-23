/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/dices-sum/
@Language: Java
@Datetime: 17-07-23 15:00
*/

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        
        /* 骰子求和 （剑指offer题43）
        
            扔 n 个骰子，向上面的数字之和为 S
            给定 n，请列出所有可能的 S 值及其相应的概率
            
            注意事项: 不用关心结果的精确性，我们将帮助您输出结果
             
            样例: 给定 n = 1，
            返回 [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]] 
        */
        
        //规律：f(n) = f(n-1) + f(n-2) + f(n-3) + f(n-4) + f(n-5) + f(n-6)
        
        //循环实现  
        List<Map.Entry<Integer, Double>> results = 
                new ArrayList<Map.Entry<Integer, Double>>();
                
        if(n <= 0)
            return results; 
            
        double[][] f = new double[n + 1][6 * n + 1];
        
        for(int i = 1; i <= 6; i++){
            
            f[1][i] = 1.0 / 6;
        }
            

        for(int i = 2; i <= n; i++){
            
           for(int j = i; j <= 6 * n; j++){
               
                for (int k = 1; k <= 6; k++){
                    
                    if (j > k){
                        
                        f[i][j] += f[i - 1][j - k];
                    }
                }
                    
                f[i][j] /= 6.0;
            } 
        }
            
        for(int i = n; i <= 6 * n; i++){
            
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, f[n][i]));
        } 
            
        return results;
    }
}