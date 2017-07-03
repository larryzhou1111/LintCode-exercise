/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/n-queens-ii/
@Language: Java
@Datetime: 17-7-3 11:00
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
     
    public static int count; 
        
    public int totalNQueens(int n) {
        //write your code here
        
        /* N皇后问题 II
           根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局
           
           和皇后问题一样，用计数器统计能完整递归的次数：
           每次对子集cur递归到row == n时，只要计数器count++即可
        */
        
        //需回顾！！！
        
        //参考：https://segmentfault.com/a/1190000005146494

        count = 0;
        
        int[] visited = new int[n];
        //i + j
        int[] set1 = new int[2 * n]; 
        //i - j
        int[] set2 = new int[2 * n];   
        
        dfs(n, set1, set2, visited, 0);
        
        return count;
    }
        
        
    public void dfs(int n, int[] set1,int[] set2,int[] visited, int idx){
        
        if(idx == n){
            
            count++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            
            if(visited[j] == 0 && set1[idx + j] == 0 && set2[n + idx - j] == 0){
                
                visited[j] = 1;
                set1[idx + j] = 1;
                set2[n + idx - j] = 1;
                
                dfs(n, set1, set2, visited, idx + 1);
                
                visited[j] = 0;
                set1[idx + j] = 0;
                set2[n + idx - j] = 0;
            }
        }
  
    }
};

