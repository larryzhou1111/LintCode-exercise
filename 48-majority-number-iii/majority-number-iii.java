/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/majority-number-iii/
@Language: Java
@Datetime: 17-7-1 11:00
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code

        /*
          给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k
          注意事项:数组中只有唯一的主元素
        */
        
        //类比题47
        
        /*思路：
          出现次数数严格大于数组元素个数的1/k，即将数组分成k份
          
          用HashMap保存元素出现的次数
         （1）map中已存在的元素，+1
         （2）map中不存在的元素，分情况:    
            若map.size() >= k，说明元素已超K份，要在map里，删除只出现一次的元素
            若map.size() < k，则可继续添加该元素，map.put(xxx, 1)

          最后在HashMap里，找出所留下的出现次数最大的那个数
        */
               
        if (nums == null || nums.size() == 0) 
            return -1;
            
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(Integer i : nums){
            
            if(!map.containsKey(i)){
                
                map.put(i, 1);
            }
            else{
                
                map.put(i, map.get(i) + 1);
            }
            
            if(map.size() >= k){
                
                //删除只出现一次的元素，保持map的size不能超过k
                removeKey(map);
            }
        }
        
        if(map.size() == 0)
            return Integer.MIN_VALUE;
            
        int max = 0;
        int maxKey = 0;
        
        Set<Integer> keySet = map.keySet();
        
        for(Integer i : keySet){
            
            int count = 0;
            
            for(Integer j : nums){
                
                if(i.equals(j)){
                    
                    count++;
                }
            }
            
            if(count > max){
                
                max = count;
                maxKey = i;
            }
            
        }
        
        return maxKey;
    }
    
    
    private void removeKey(Map<Integer, Integer> map){
        
        Set<Integer> keySet = map.keySet();
        List<Integer> removeList = new ArrayList<>();
        
        for(Integer key : keySet){
            
            if(map.get(key) == 1){
                
                // 删除只出现一次的元素
                removeList.add(key);        
            }
            
            else{
                
                // 位置减一
                map.put(key, map.get(key) - 1);     
            }
        }
        
        for(Integer key : removeList){
            
            map.remove(key);
        }
        
    }    
}
