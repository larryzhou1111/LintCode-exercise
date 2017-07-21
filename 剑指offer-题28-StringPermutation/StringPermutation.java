/*
@Author:   larryzhou
@Problem:  字符串的排列
@Language: Java
@Datetime: 17-07-21 16:00
@Reference:https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
*/

//方法1：迭代算法：字典生成算法 
/*      
import java.util.*;

public class Solution {

	public ArrayList<String> Permutation(String str) {
		
        ArrayList<String> res = new ArrayList<>();
 
        if(str != null && str.length() > 0){
	
            char[] seq = str.toCharArray();
            Arrays.sort(seq); //排列
            res.add(String.valueOf(seq)); //先输出一个解
 
            int len = seq.length;
            while(true){
	
                int p = len - 1, q;
                //从后向前找一个seq[p - 1] < seq[p]

                while (p >= 1 && seq[p - 1] >= seq[p]) 
					--p;
				
                if (p == 0) 
					break; //已经是“最小”的排列，退出
				
                //从p向后找最后一个比seq[p]大的数
                q = p; 
				--p;
				
                while(q < len && seq[q] > seq[p]) 
					q++;
				
                --q;

                //交换这两个位置上的值
                swap(seq, q, p);

                //将p之后的序列倒序排列
                reverse(seq, p + 1);

                res.add(String.valueOf(seq));
            }
        }
 
        return res;
    }
     
    public static void reverse(char[] seq, int start) {
	
        int len;
        if(seq == null || (len = seq.length) <= start)
            return;

        for(int i = 0; i < ((len - start) >> 1); i++){
	
            int p = start + i, q = len - 1 - i;

            if(p != q)
                swap(seq, p, q);
        }
    }
     
    public static void swap(char[] cs, int i, int j) {
	
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
*/

//方法2：递归法（不考虑重复元素）
import java.util.*;

public class Solution {
	public ArrayList<String> Permutation(String str){
 
        ArrayList<String> list = new ArrayList<String>();
        
        if(str != null && str.length() > 0){
            
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        
        return list;
    }
    
    private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        
        if(i == chars.length-1){
            
            list.add(String.valueOf(chars));
        }
        else{
            Set<Character> charSet = new HashSet<Character>();
            
            for(int j = i; j < chars.length; ++j){
                
                if(j == i || !charSet.contains(chars[j])){
                    
                    charSet.add(chars[j]);
                    
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }
 
    private void swap(char[] cs,int i,int j){
        
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}