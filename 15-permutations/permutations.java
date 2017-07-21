/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/permutations/
@Language: Java
@Datetime: 17-07-21 16:00
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        
        /* 全排列: 给定一个数字列表，返回其所有可能的排列。

            注意事项:
            你可以假设没有重复数字
            
            样例:
            
            给出一个列表[1,2,3]，其全排列为：
            [
              [1,2,3],
              [1,3,2],
              [2,1,3],
              [2,3,1],
              [3,1,2],
              [3,2,1]
            ]
        */
        
        //方法1：非递归
        /*
            插入法，假设有i个元素的排列组合，
            那么对于第i+1个元素，可以将第 i+1 个元素插入到上述的排列的每一个位置
        */
        /*
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null)
            return null;
            
        if(nums.length == 0){    
            
            //返回[[]]
            res.add(new ArrayList<Integer>());
            return res;
        }        
        
        List<Integer> list = new ArrayList<>();
        
        list.add(nums[0]);
        
        res.add(new ArrayList<Integer>(list));
        
        for(int i = 1; i < nums.length; i++){
            
            int size1 = res.size();
            
            for(int j = 0; j < size1; j++){
                
                int size2 = res.get(0).size();
                
                for(int k = 0; k <= size2; k++){
                    
                    ArrayList<Integer> temp = new ArrayList<>(res.get(0));
                    temp.add(k, nums[i]);
                    res.add(temp);
                }
                
                res.remove(0);
            }
        }
        
        return res;
        */
        
        //方法2：递归实现，回溯法和深度优先搜索
        /*
            一个一个将数组元素加入到排列中，递归求解，添加时排除掉相同的元素即可
            
            回溯法，通常会设置一个已访问标识数组，来表示数组被访问过
            此处不用，因为如果list里面已经包含，就说明已经访问过了
            所以只要判断，跳过已有的元素即可
            
            递归的结束条件，当元素都添加足够就结束了，即元素个数等于数组的长度

        */
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null)
            return res;
            
        if(nums.length == 0){    
            
            res.add(new ArrayList<Integer>());
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        
        dfs(res, list, nums);
        
        return res;
   }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {

        int n = nums.length;
        
        //保证长度一致
        if(list.size() == n){ 
            
            res.add(new ArrayList<Integer>(list));
            
            //跳过当前循环，进入下一个循环(i+1)
            return;
        }

        //回溯法，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除
        for(int i = 0; i < n; i++){
            
            if(list.contains(nums[i]))
                continue;
                
            list.add(nums[i]);
            
            dfs(res, list, nums);
            
            list.remove(list.size() - 1);
        }
    }
    
}