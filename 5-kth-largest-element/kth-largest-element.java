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
 
		//剑指offer题30
		 
        /* 第k大元素: 在数组中找到第k大的元素 (剑指offer题30)
        
           注意事项:你可以交换数组中的元素的位置
           
           样例
            给出数组 [9,3,2,4,8]，第三大的元素是 4
            给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，
                                  第三大的元素是 3，以此类推
        */
        
        //方法1：先排序，再直接查找，复杂度O(nlogn)
        
        //排序，也可采用快排，等其他排序方式 
        /* 
            Arrays.sort()方法底层采用的是：
            取决于不同版本！需要进一步看源码！
            
            Java 6中，Arrays.sort()使用的是MergeSort（归并排序）
            Java 7中，内部实现换成了TimSort（归并排序 + 插入排序）
            
            1、基本类型的排序，采用的是调优的快速排序
            2、对象类型的排序，采用的是改进的归并排序

              1、(1)对于长度小于7的数组，直接使用插入排序. (7表示优化参数) 
                 (2)对于长度大于7的数组，使用快速排序
        */  
        /*
        if(nums == null || k <= 0 || nums.length < k) 
            return Integer.MIN_VALUE;

        Arrays.sort(nums);
        
        //第k大，即排序后的数组中，倒数第k个元素
        return nums[nums.length - k];
        */
        
        
        //方法2：类似快排的思路，时间复杂度O(n)
        
        if(nums == null || k <= 0 || nums.length < k) 
            return Integer.MIN_VALUE;
            
        kthMax(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }
    
    public void kthMax(int[] nums, int left, int right, int k) {
        
        int mid = partition(nums, left, right);
        
        if(mid == k - 1) 
            return;
            
        if(mid > k-1){
            
            kthMax(nums, left, mid - 1, k);
        }
        else{
            
            kthMax(nums, mid + 1, right, k);
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        
        int temp = nums[left];
        
        while(left < right){
            
            while(left < right && nums[right] <= temp){
                
                right--;
            }
                
            nums[left] = nums[right];
            
            while(left < right && nums[left] > temp){
                
                left++;
            }
                
            nums[right] = nums[left];
        }
        
        nums[left] = temp;
        
        return left;       
        
        
        
        //方法3：堆排序
        /*
            红黑树，查找、删除、插入查找都只需O(logk)时间，总时间复杂度O(n*logk)
            小顶堆：时间复杂度为O(NlogK)，额外空间为O(K)
            大顶堆：时间复杂度为O(KlogN)，额外空间为O(N)
            
            思路：大顶堆，并且结合部分排序的思想
                    首先把数组array[0...N-1]构造成大顶堆，
                    然后依次提取当前堆中最大的元素，直到找到第K大元素
        */
        
    }
};