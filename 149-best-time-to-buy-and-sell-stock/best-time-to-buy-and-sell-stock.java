/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/best-time-to-buy-and-sell-stock/
@Language: Java
@Datetime: 17-08-18 22:00
*/

public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        /*  买卖股票的最佳时机 
            假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格
            如果你最多只允许完成一次交易(例如,一次买卖股票)
            设计一个算法来找出最大利润
            
            样例: 给出一个数组样例 [3,2,3,1,2], 返回 1 （2买入3卖出，或1买入2卖出）
        */
        
        if(prices == null || prices.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;  
        int profit = 0;
        
        for(int i : prices){
            
            //将当前min值，与当前数组元素值i中的较小者，保存为新的min
            min = i < min ? i : min;
            
            //不断比较，并更新收益最大值
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;
    }
};