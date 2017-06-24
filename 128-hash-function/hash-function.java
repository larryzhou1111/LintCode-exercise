/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/hash-function/
@Language: Java
@Datetime: 17-06-24 19:30
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        
        /*
          hashcode("abcd") = (ascii(a) * 33的三次方 + ascii(b) * 33的2次方 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                           = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                           = 3595978 % HASH_SIZE
        */
        
        //写法1：
        /*
        int len = key.length;
        long hashcode = 0;
        long base = 1;
        
        for(int i = len - 1; i >= 0; i--){
            
            hashcode = hashcode + Integer.valueOf(key[i]) * base % HASH_SIZE;
            hashcode = hashcode % HASH_SIZE;
            base = base * 33 % HASH_SIZE;
        }
        
        return (int)hashcode;
        */
        
        //写法2：
        long sum = (int)key[0];
        
        for(int i = 1; i < key.length; i++){
            
            sum = sum * 33 % HASH_SIZE + (int)key[i];
        }
        
        return (int)(sum % HASH_SIZE);
    }
};