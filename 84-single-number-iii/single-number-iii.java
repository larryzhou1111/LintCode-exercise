/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/single-number-iii/
@Language: Java
@Datetime: 17-06-18 19:54
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        
        /* 落单的数 III ( 剑指offer题40 )
        
        给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字
        
        样例：给出 [1,2,2,3,4,4,5,3]，返回 1和5
        */
        
        /* 思路：
            将全部的数异或，最后得到一个数，此数为两个出现一次的数的异或
            
            得到的这个数至少有一位为1，通过为1的此位，可将所有数分为两部分
            一部分此位为0，另一部分此位为1，所求的两个数一定分别在两部分中
            
            问题就转化为两部分，分别求落单的数I，
            即针对两部分，分别异或求出落单的数
        */
        
        if(null == A || A.length ==0) 
            return null;
            
        List<Integer> list = new ArrayList<Integer>();
        
        int x = 0;
        for(int i = 0; i < A.length; i++){
            
            x ^= A[i];
        }
        
        int k = 0;
        
        //(x & 1) 等价于 (x % 2)，且位运算效率更高
        while((x & 1) == 0 && k < 32){
            
            //找到为1的是哪一位，后续分组就是以此位是否为1来划分
            k++;
            
            //( x >>=1 ) 等价于 (x / 2)，且位运算效率更高 
            x >>=1;
        }
        
        int result1 = 0, result2 = 0;
        
        for(int i = 0; i < A.length; i++){
            
            // ((A[i]>>>k) & 1)：无符号右移k位，看第k位是否为1
            
            //分组1
            if(((A[i]>>>k) & 1) == 0){
                
                result1 ^= A[i];
            }
            //分组2
            else{
                result2 ^= A[i];
            }
        }
        
        list.add(result1);
        list.add(result2);
        
        return list;
    }
}