/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/backpack/
@Language: Java
@Datetime: 17-7-7 22:00
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        /* 背包问题 参考：http://blog.csdn.net/wutingyehe/article/details/46910103
        
          在n个物品中挑选若干物品装入背包，最多能装多满？
          假设背包的大小为m，每个物品的大小为A[i]
          
          样例
            如果有4个物品[2, 3, 5, 7]
            
            如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
            
            如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
            
            函数需要返回最多能装满的空间大小。
        */
        
        /*
          建动态规划数组 dp[A.length][m + 1]，A.length行，m + 1 列
          
        start	        j = 0	        1   2	3	4	5	6	7	8	9	10	11
        i = 0 (A[0]=2)	dp[0][0] = 0	0	2	2	2	2	2	2	2	2	2	2
        i = 1 (A[1]=3)	0	            0	2	3	3	5	5	5	5	5	5	5
        i = 2 (A[2]=5)	0	            0	2	3	3	5	5	7	8	8	10	10
        i = 3 (A[3]=7)	0        	    0	2	3	3	5	5	7	8	10	10	10
        
        dp[i][j]为当背包总重量为j且有前i个物品时，背包最多装满dp[i][j]的空间
        
        状态转移方程为：dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i-1][j])

        dp[i - 1][j - A[i]] + A[i]为加入第i个物品后背包的总装满空间
        
        a.为了把第i个物品放进背包，背包当然要先腾出至少A[i]的空间，腾出后空间的最多装满空间为dp[ i - 1][j - A[i]]，
          再加上第i个物品的空间A[i]，即为当背包总空间为j时，装入第i个物品背包的总装满空间
          
        b.当然第i个物品所占的空间可能比此时背包的总空间j要大(j < A[i])，
          此时装不进第i个物品，因此此时背包的总装满空间为dp[i-1][j]
          
        c.还有一种可能的情形是，虽然第i个物品能够装入包中，但为了把第i个物品装入而拿出了其他物品，使此时的总装入空间dp[i-1][j-A[i]] + A[i] < dp[i-1][j]
        
        其他情形： 
        当j = 0时，dp[i][0] = 0
        
        原题答案即为dp[3][11] = 10，背包的总空间为11时，四个物品能够装入的最大空间为多大

        */
        
        //动态规划矩阵
        int[][] dp = new int[A.length][m + 1];
        
        for(int i = 0; i < A.length; i ++){
            
            //背包空间为0时，不管要放第几个物品，可装满的背包空间为0.
            dp[i][0] = 0;
        }
        
        for(int j = 1; j < m + 1; j++){
            
            //当第0个物品的空间，小于等于当前背包空间j
            if(A[0] <= j){
                
                //背包可装满的最大空间是第0个物品的体积
                dp[0][j] = A[0];
            }
            
            //当第0个物品的空间大于当前背包空间j
            else{
                
                //背包可装满的最大空间是0
                dp[0][j] = 0;
            }
            
            for(int i = 1; i < A.length; i++){
                
                //若该物品所占空间大于背包总空间（无论怎样腾背包空间，该物品无法放入背包
                if(A[i] > j){
                    
                    //背包可装满的最大空间不变
                    dp[i][j] = dp[i - 1][j];
                }
                
                //若该物品所占空间小于等于背包总空间,则需将背包空间腾出至少A[i]后，将该物品放入。
                //放入新物品后背包最大可装满空间可能更大，也可能变小，取大值作为背包空间为j且放第i个物品时可以有的最大可装满空间。
                else {
                    dp[i][j] = Math.max(dp[i-1][j - A[i]] + A[i], dp[i - 1][j]);
                }
            }
        }
        
        return dp[A.length - 1][m];
    }
}