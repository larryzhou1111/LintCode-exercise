/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays-ii
@Language: Java
@Datetime: 17-06-08 15:15
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        /*
        //方法1：通过HashMap<Integer, Integer>记录数组中每个元素与对应的出现次数
        int[] results;
        
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            
            results = new int[0];
            return results;
        }
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
            
            if(hash.containsKey(nums1[i])) {
                hash.put(nums1[i], hash.get(nums1[i]) + 1);
            } 
            else{
                hash.put(nums1[i], 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums2.length; i++){
            
            if(hash.containsKey(nums2[i]) && hash.get(nums2[i]) > 0){
                
                list.add(nums2[i]);
                hash.put(nums2[i], hash.get(nums2[i]) - 1);
            }
        }
        
        results = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            
            results[i] = list.get(i);
        }
        return results;        
        */
        
        //方法2：排序+二分查找变种+双指针
        /*
            变种二分查找：此二分查找用于找到查找目标第一次出现位置
            双指针解法：经过排序后，假设两数组中拥有某个交集元素cur  ,通过二分查找到cur在第二个数组中的位置index,        
                ,通过双指针cnt1与cnt2统计交集元素cur在两个数组中各自出现的总次数，
                 较小者表示该交集元素在交集中出现的次数
        */
        int[] results;
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            
            results = new int[0];
            return results;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int index2 = 0;
        int i = 0;
        
        while(i < nums1.length){
            // num2是子集
            if(index2 > nums2.length - 1){
                break;
            }
            
            int cnt1 = 1, cnt2 = 1;
            int cur = nums1[i];
            int index = binarySearch(nums2, index2, cur);
            
            if(index != -1){
                // 查找交集元素cur在数组num1中出现总次数
                for(int k = 1; k < nums1.length && i + k < nums1.length; k++){
                    
                    if (nums1[i + k] != cur) {
                        break;
                    }
                    cnt1++;
                }
                // 查找交集元素cur在数组num2中出现总次数
                for(int k = 1; k < nums2.length && index + k < nums2.length; k++){
                    
                    if(nums2[index + k] != cur){
                        break;
                    }
                    cnt2++;
                }
                
                int min = Math.min(cnt1, cnt2);
                for(int k = 0; k < min; k++){
                    list.add(cur);
                }
                // num2指针移动
                index2 += cnt2;
            }
            // num1指针移动
            i += cnt1;
        }
        
        results = new int[list.size()];
        i = 0;
        for (Integer cur : list) {
            results[i++] = cur.intValue();
        }
        return results;
    }
    
    // 返回target第一次出现位置，target不存在返回-1
    private int binarySearch(int[] num, int index2, int target){
        
        int start = index2;
        int end = num.length - 1;
        
        while(start + 1 < end){
            
            int mid = start + (end - start) / 2;
            
            if (num[mid] == target) {
                end = mid;
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
        
    }
}