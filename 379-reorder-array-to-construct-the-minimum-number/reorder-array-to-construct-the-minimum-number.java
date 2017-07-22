/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/reorder-array-to-construct-the-minimum-number/
@Language: Java
@Datetime: 17-07-22 16:00
*/

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        
        /* 将数组重新排序以构造最小值
        
           给定一个整数数组，请将其重新排序，以构造最小值
        
           注意事项: 数可能很大，所以需返回字符串，而不是Integer类型
           
           样例：给定 [3, 32, 321]，通过将数组重新排序，可构造 6 个可能性数字：
            
            3 + 32 + 321 = 332321
            3 + 321 + 32 = 332132
            32 + 3 + 321 = 323321
            32 + 321 + 3 = 323213
            321 + 3 + 32 = 321332
            321 + 32 + 3 = 321323
            
            其中，最小值为 321323，所以将数组重新排序后，该数组变为 [321, 32, 3]
        */
        
        /* 剑指offer题33
        
            思路：
                先把数组中的整数，转换成字符串；然后对字符串数组排序
                得到拼接的最小数字
                
            要注意：[0,1] 应该返回的是"1"，所有开头的"0"都不返回 !
                    [0,0,0] 应该返回的是"0" !
            
            主要利用的性质：
            （1）自反性：如aa = aa，所以a等于a
            （2）对称性：如果a < b，则ab < ba；即ba > ab，则b大于a
            （3）传递性：如果a < b，则ab < ba；如果b < c，则bc < cb；
                            综上，则a < c，则ac < ca
        */
        
        if(nums == null || nums.length == 0)
            return " ";

        int len = nums.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            
            str[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(str,new Comparator<String>(){
            
            @Override
            public int compare(String a, String b) {

                String ab = a + b;
                String ba = b + a;
                return ab.compareTo(ba);
            }
        });
        
        //拼接成字符串形式的最终结果
        for(int i = 0; i < len; i++){
            
        	sb.append(str[i]);
        }
        
        //统计最终结果的开头，有多少个'0'
        int i = 0;
        while(i < len && sb.charAt(i) == '0')
            i++;
		
		//数组为[0,0,0]形式，即字符串为"0000..."，最终应该返回的是"0"
        if(i == len) 
            return "0";
        
        //得到除去所有开头的'0'后的子串，然后输出
        return sb.substring(i).toString();
    }
}