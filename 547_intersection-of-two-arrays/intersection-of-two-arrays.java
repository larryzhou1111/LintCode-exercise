/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 17-06-10 08:21
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        
        //方法1：循环遍历（不推荐）

        /*
        //方法2：分别排序+二分查找进行预处理，交集用HashSet保存实现去重
        int[] results;
        
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            
            results = new int[0];
            return results;
        }
        
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index2 = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            // num2是子集
            if (index2 > nums2.length - 1) {
                break;
            }
            
            int index = binarySearch(nums2, index2, nums1[i]);
            
            if (index != -1) {
                // set去重
                set.add(nums1[i]);
                // num2指针移动
                index2 = index;
            }
        }
        
        results = new int[set.size()];
        int i = 0;
        
        for (Integer cur : set) {
            results[i++] = cur.intValue();
        }
        return results;
    }
    
    //经典二分查找
    private int binarySearch(int[] num, int index2, int target) {
        
        int start = index2;
        int end = num.length - 1;
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            if (num[mid] == target) {
                return mid;
            }
            else if (num[mid] < target) {
                start = mid;
            } 
            else {
                end = mid;
            }
        }
        
        if (num[start] == target) {
            return start;
        }
        
        if (num[end] == target) {
            return end;
        }
        
        return -1;
        */
        
        
        //方法3：使用HashSet，HashSet内部不允许有重复元素
        
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        
        for(int i = 0; i<nums1.length; i++){
            
            hashSet1.add(nums1[i]);
        }

        for(int i = 0; i<nums2.length; i++){
            
            if(hashSet1.contains(nums2[i]) && !hashSet2.contains(nums2[i])){
                
                hashSet2.add(nums2[i]);
            }
        }
        
        int index = 0;
        int[] result = new int[hashSet2.size()];
        
        for (int i : hashSet2) {
            
            result[index] = i;
            index ++ ;
        }
        return result;

        
        /*
        //方法4：分别排序进行预处理，再定义两个指针循环比较
        int[] results;
        
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            
            results = new int[0];
            return results;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int index = 0;
        
        int[] temp = new int[nums1.length];
        
        while (i < nums1.length && j < nums2.length) {
            
            if (nums1[i] == nums2[j]) {
                
                // temp[index - 1] != num1[i]去重
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } 
            else if (nums1[i] < nums2[j]) {
                i++;
            } 
            else {
                j++;
            }
        }
        
        i = 0;
        results = new int[index];
        
        for (i = 0; i < index; i++) {
            results[i] = temp[i];
        }
        return results;
        */
    }
}