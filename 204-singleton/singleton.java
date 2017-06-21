/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/singleton/
@Language: Java
@Datetime: 17-06-21 14:54
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    
    //写法1：单例模式之恶汉式（类一加载，对象就造好了）
    
    //构造私有方法,也可不构造
    /*
    private Solution(){
        
    }
    */
    
    /*
    //自己造一个对象
    //静态方法只能访问静态成员变量，加静态
    //为了不让外界直接访问修改这个值，加private    
    private static Solution s = new Solution();
    
    // 提供公共的访问方式    
    // 为了保证外界能够直接使用该方法，加静态    
    public static Solution getInstance() {
        // write your code here
        
        return s;
    }
    */
    
    //写法2：单例模式之懒汉式（用的时候，才去创建对象）
    
    private static Solution s = null;
    
    
    public synchronized static Solution getInstance() {
        // write your code here
        
        if(s == null){
            
            s = new Solution();
        }
        return s;
    }
    
};