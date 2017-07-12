/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/print-numbers-by-recursion/
@Language: Java
@Datetime: 17-7-12 22:00
*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        
        /* 用递归打印数字
        
            注意事项

            用下面这种方式去递归其实很容易：
            
            recursion(i) {
                if i > largest number:
                    return
                results.add(i)
                recursion(i + 1)
            }
            但是这种方式会耗费很多的递归空间，导致堆栈溢出。
            你能够用其他的方式来递归使得递归的深度最多只有 N 层么？
            
            给出 N = 1, 返回[1,2,3,4,5,6,7,8,9].
            给出 N = 2, 返回[1,2,3,4,5,6,7,8,9,10,11,...,99].
        */
        
        /*
        //方法1：非递归方式：先求出最大的n位数N，然后顺序遍历求解
        
        int N = 1;
        
        for(int i = 1; i <= n; i++){
            
            N = N * 10;
        }
        
        N = N - 1;
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 1; i <= N; i++){
            
            result.add(i);
        }
        
        return result;
        */
        
        //方法2：
        /*  首先计算最高位存入base，
            然后，用1到9倍的base（curbase）和 
            之前res里已经存入的所有的数（res.size()个）循环相加，
            再存入res，更新res.size，
            计算更高位，直到 base 等于 10^n ...
        */
        List<Integer> res = new ArrayList<Integer>();
        
        if(n >= 0){
            
            helper(n, res);
        }
        
        return res;
    }
    
    public int helper(int n, List<Integer> res) {
        
        if(n == 0)
            return 1;
            
        int base = helper(n - 1, res);
        int size = res.size();
        
        for(int i = 1; i <= 9; i++){
            
            int curbase = i * base;
            res.add(curbase);
            
            for(int j = 0; j < size; j++){
                
                res.add(curbase + res.get(j));
            }
        }
        
        return base * 10;
    }
}