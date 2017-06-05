/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/flatten-list
@Language: Java
@Datetime: 17-06-05 12:42
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        
        //递归实现
        List<Integer> list = new ArrayList<>();
        doflatten(nestedList, list);
        return list;
        
    }
    
    public static void doflatten(List<NestedInteger> nestedList,List<Integer>list){
        
        if(nestedList != null){
            //遍历nestedList中的元素
            for(NestedInteger nList:nestedList){
                //判断元素是否是整型，是则添加到列表中
                if(nList.isInteger()){
                    list.add(nList.getInteger());
                }
                else{
                    //元素不是整型，继续递归判断
                    doflatten(nList.getList(), list);
                }
            }
        }
        
    }
}