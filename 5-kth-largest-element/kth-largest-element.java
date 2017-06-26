/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/kth-largest-element/
@Language: Java
@Datetime: 17-06-26 22:30
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        
        if(nums == null || nums.length < k)
            return -1;
        
        //排序，也可采用快排，等其他排序方式 
        
        /* Arrays.sort()方法底层采用的是：
        
            取决于不同版本！需要进一步看源码！
            
            Java 6中，Arrays.sort()使用的是MergeSort（归并排序）
            Java 7中，内部实现换成了TimSort（归并排序 + 插入排序）
            
            1、基本类型的排序，采用的是调优的快速排序
            2、对象类型的排序，采用的是改进的归并排序

              1、(1)对于长度小于7的数组，直接使用插入排序. (7表示优化参数) 
                 (2)对于长度大于7的数组，使用快速排序

        */
        
        Arrays.sort(nums);
        
        //第k大，即排序后的数组中，倒数第k个元素
        return nums[nums.length - k];
        
    }
};