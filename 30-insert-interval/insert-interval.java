/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/insert-interval/
@Language: Java
@Datetime: 17-06-21 21:54
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
       
        // write your code here
       
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        //边界情况
        if(intervals.size() == 0){
            
            result.add(newInterval);
            return result;
        }
   
        //循环判断
        for(int i = 0; i < intervals.size(); i++){
            
            //如果新的区间结束值小于开始值，则直接插入前面，后面依次插入即可
            
            if(newInterval.end < intervals.get(i).start){
                
                result.add(newInterval);
                
                for(int j = i; j < intervals.size(); j++){
                    
                    result.add(intervals.get(j));
                }
                break;
            }
            
            //新的区间开始点大于结束点，则当前点直接添加结果集
            else if(newInterval.start > intervals.get(i).end){
                
                result.add(intervals.get(i));
            }
            
            //需要合并的情况
            else{
                
                //合并区间
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
            
            //如果是最后一个数据, 也添加结果集中
            if(i == intervals.size() - 1){
                
                result.add(newInterval);
            }
        }
       
        return result;
    }
}