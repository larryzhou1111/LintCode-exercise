/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/permutation-index-ii
@Language: Java
@Datetime: 17-06-13 13:57
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        
        //类比题197，区别在于本题含有重复数字，需要排除重复排列
        //如果A[i]在[0,i]区间中有重复元素
        //则用A[i]的 count * fact 的结果,除以重复次数dup的阶乘
        
        if(A == null || A.length == 0) 
            return 0;
            
        long index = 1;
        long factor = 1;
        //设置重复次数
        int dup = 1;
        
        //用HashMap，保证key的唯一性
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = A.length - 1; i >= 0; i--){
            
            if(!map.containsKey(A[i])){
                
                map.put(A[i], 1);
            }
            else{
                //把A[i]对应的value值，替换为重复次数
                map.put(A[i], map.get(A[i]) + 1);
                dup *= map.get(A[i]);
            }            
            
            int rank = 0;
            
            for(int j = i + 1; j < A.length; j++){
                
                if(A[i] > A[j]){
                    
                    rank++;
                }   
                /*
                下述循环写法是有问题的！
                for(int k = j + 1; k < A.length; k++){  
                
                    if(A[j] == A[k] && A[i] > A[k]){
                        
                        dup++;
                    }
                }
                */
            }
            
            index += rank * factor / dup;
            factor *= (A.length - i);
        }
        return index;        
        
    }
}