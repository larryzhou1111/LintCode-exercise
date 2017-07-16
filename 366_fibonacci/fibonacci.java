/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 17-05-31 08:46
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    
    //方法2中定义：
    //ArrayList<Integer> buffer = new ArrayList<Integer>();
     
    public int fibonacci(int n) {
        // write your code here
        
        /* 斐波纳契数列: 查找斐波纳契数列中第 N 个数

            所谓的斐波纳契数列是指：
            
            前2个数是 0 和 1 
            第 i 个数是第 i-1 个数和第i-2 个数的和
            斐波纳契数列的前10个数字是：
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
            
            样例:
            给定 1，返回 0
            给定 2，返回 1
            给定 10，返回 34
        */
        
        //方法1：递归，主要利用f(n) = f(n-1) + f(n-2).重复运算多，效率低，略
        
        //方法2：优化版的递归，思路：计算结果加入缓存 ，时间复杂度为 o(n) ，空间复杂度为 o(n)
        /*
        if(n == 1)
            return 0;
        
        if(n == 2)
            return 1;
        
        int n1, n2, sn;
        
        if(buffer.size() == 0){
            
            buffer.add(0);
            buffer.add(1);
        }
        
        if(buffer.size() > n - 2){
            
            n1 = buffer.get(n - 2);
        } 
        else{
            
            n1 = fibonacci(n - 1);
        }
        
        if(buffer.size() > n - 3){
            
            n2 = buffer.get(n - 3);
        } 
        else{
            
            n2 = fibonacci(n - 2);
        }
        
        sn = n1 + n2;
        if(buffer.size() < n){
            
            buffer.add(sn);
        }
        
        return sn;
        */
        
        //方法3：非递归 ，时间复杂度为 o(n) ，空间复杂度为 o(1)
        /*
        int stepOne = 0;
        int stepTwo = 1;
        
        if(n == 1)
            return 0;
        
        if(n == 2 || n == 3)
            return 1;
        
        for(int i = 3; i <= n; i++){
            
            int stepThree = stepOne + stepTwo;
            stepOne = stepTwo; 
            stepTwo = stepThree;
        }
        return stepTwo;
        */
        
        //方法4：矩阵快速幂实现，时间复杂度为 o(log 2n) （不太理解）
        //采用矩阵的方式，可以将斐波那契数列化为 a^n 的格式，达到降幂的效果
        //参考：http://www.jianshu.com/p/be66df126569
        
        if(n == 1)
            return 0;
            
        if (n == 2)
            return 1;
        
        int s[][] = new int[2][2];
        rxn(n - 2, s);
        
        return s[0][0];
    }

    public void rxn(int n, int[][] result){
        
        if(n == 0){
            
            result[0][0] = 1;
            result[0][1] = 0;
            result[1][0] = 0;
            result[1][1] = 1;
            
            return;
        }
        
        if(n == 1){
            
            result[0][0] = 1;
            result[0][1] = 1;
            result[1][0] = 1;
            result[1][1] = 0;
            
            return;
        }
        
        if(n > 1){
            
            int s[][] = {{1, 1}, {1, 0}};
            int buffer[][] = new int[2][2];
            
            rxn(n / 2, buffer);
            
            int buffer2[][] = new int[2][2];
            
            mul(buffer, buffer, buffer2);
            
            if(n % 2 == 0){
                
                result[0][0] = buffer2[0][0];
                result[0][1] = buffer2[0][1];
                result[1][0] = buffer2[1][0];
                result[1][1] = buffer2[1][1];
            }
            else{
                
                mul(buffer2, s, result);
            }
        }
    }

    public void mul(int[][] m1, int[][] m2, int[][] result) {
        
        result[0][0] = m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0];
        result[0][1] = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];
        result[1][0] = m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0];
        result[1][1] = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
      
    }
}