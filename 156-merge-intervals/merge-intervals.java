/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/merge-intervals/
@Language: Java
@Datetime: 17-06-22 20:54
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        
        /*  合并区间: 给出若干闭合区间，合并所有重叠的部分
        
            样例:
                给出的区间列表 => 合并后的区间列表：
                [                     [
                  [1, 3],               [1, 6],
                  [2, 6],      =>       [8, 10],
                  [8, 10],              [15, 18]
                  [15, 18]            ]
                ]
        */
        
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        
        //思路：先根据集合中区间的起始值,将所有区间按起始值大小,从小到大顺序排序
        
        //排序部分写法1：集合的排序函数,及调用集合比较器函数
        /*
        Collections.sort(intervals, new IntervalComparator());       
        */
        
        //排序部分写法2：直接遍历排序
        
        int pos = 0;  
        Interval temp = new Interval(0,0); 
        
        for(int i = 1; i < intervals.size(); i++){  
            
            //pos保存待插入位置 
            pos = i - 1; 
            
            //temp保存待插入对象  
            temp = intervals.get(i);  
            
            //如pos大于或等于0，且i对象值比pos对象值小，则pos往前挪一位，直到找到合适的位置
            while(pos >= 0 && (intervals.get(i).start < intervals.get(pos).start)){  
               
                pos--;  
            } 
            
            //将集合中原来的i处对象删除，在pos+1处添加上temp对象  
            intervals.remove(i);  
            intervals.add(pos + 1, temp);  
        } 
    
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        Interval cur = intervals.get(0);
        
        //遍历，比较集合下一个区间的起始值，与当前区间的尾部值比较
        for(int i = 1; i < intervals.size(); i++){
            
            Interval next = intervals.get(i);
            
            //若下一个区间的起始值，小于或等于，当前区间的尾部值
            if(next.start <= cur.end){
                
                //当前区间的尾部值，取当前区间和下一区间尾部值的最大值
                cur.end = Math.max(cur.end, next.end);
                
            }
            else{
                
                //把不符合上述条件的区间,添加到结果集中
                result.add(cur);
                //将当前区间拨到下一个区间，继续遍历
                cur = next;
            }
        }
        
        result.add(cur);
        return result;
    }
    
    /*
    //集合比较器，比较集合中各个区间的起始值
    private class IntervalComparator implements Comparator<Interval>{
        
        public int compare(Interval a, Interval b){
            
            return a.start - b.start;
        }
    }
    */
}