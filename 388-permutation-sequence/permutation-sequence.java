/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/permutation-sequence/
@Language: Java
@Datetime: 17-07-21 16:00
*/

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        // write your code here
        
        /* 第k个排列
        
        给定 n 和 k，求123..n组成的排列中的第 k 个排列
        
        注意事项: 1 ≤ n ≤ 9
        
        样例
        对于 n = 3, 所有的排列如下：123 132 213 231 312 321
        如果 k = 4, 第4个排列为，231
        */
        
        /* 思路:
            当前长度是n，每个相同的起始元素对应 (n-1)! 个permutation
            ，也就是 (n-1)! 个permutation后会换一个起始元素
            
            因此，利用 k/(n-1)! 可以取得最高位在数列中的index，
            这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除
            
            然后，新的k就可以有 k%(n-1)! 获得。循环n次即可
            
            实现中要维护一个数组来记录当前的元素，每次得到一个元素加入结果数组
            ，然后从剩余数组中移除，因此空间复杂度是O(n)
            
            时间上总共需要n个回合，而每次删除元素如果是用数组需要O(n),所以总共是O(n^2)
            
            注意：一开始把k--，目的是让下标从0开始，这样下标就是从 0 到 n-1
            ，不用考虑n时去取余，更好地跟数组下标匹配
        */
        
        //写法1：
        if(k <= 0)
            return null;
        
        StringBuilder str = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        int f = 1;
        for(int i = 1; i < n + 1; i++){
            
            str.append(i);
            
            //求 n! ，并保存到 f 中
            f *= i;
        }
        
        //一开始把k--，目的是让下标从0开
        k--;
        
        while(str.length() > 0){
            
            //n的长度在变，所以要更新 n!
            f = f / str.length();
            
            // k/f 可得到第k个排列中元素的索引，将其值添加到结果字符串中
            res.append(str.charAt(k / f));
            
            //在原始字符串中，删除该元素
            str.deleteCharAt(k / f);
            
            //得到新的k，继续循环
            k = k % f;
        }
        
        return res.toString();
        
        
        //写法2：
        /*
        if(k <= 0)
            return null;
        
        StringBuilder sb = new StringBuilder();
        
        boolean[] used = new boolean[n];
        
        //一开始把k--，目的是让下标从0开始
        k--;
        
        int factor = 1;
        
        //求 (n-1)! 的阶层
        for(int i = 1; i < n; i++){
            
            factor *= i;
        }
        
        for(int i = 0; i < n; i++){
            
            // k/(n-1)! 可以取得最高位在数列中的index
            int index = k / factor;
            
            //当前的k进行(n-1)!取余，得到的数字就是当前剩余数组的index，则可以得到对应的元素
            k = k % factor;
            
            for(int j = 0; j < n; j++){
                
                if(used[j] == false){
                    
                    if(index == 0){
                        
                        used[j] = true;
                        
                        //使用'0' 来把 int 类型转换为 char 类型
                        sb.append((char)('0' + j + 1));
                        
                        break;
                    }
                    else{
                        index--;
                    }
                }
            }
            
            if(i < n - 1){
                
                factor = factor / (n - 1 - i);
            }
        }
        
        return sb.toString();
        */
    }
}