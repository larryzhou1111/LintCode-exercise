/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/permutations-ii/
@Language: Java
@Datetime: 17-07-21 16:00
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        
        /* 带重复元素的排列:给出一个具有重复数字的列表，找出列表所有不同的排列
           
            样例
            给出列表 [1,2,2]，不同的排列有：
            
            [
              [1,2,2],
              [2,1,2],
              [2,2,1]
            ]
        */
        
        //与题15类似，要注意重复元素
        
        //思路：递归实现，回溯法和深度优先搜索
        /*
            一个一个将数组元素加入到排列中，去除重复元素影响
            然后递归求解，添加时排除掉相同的元素即可
            
            回溯法，通常会设置一个已访问标识数组，来表示数组被访问过

            递归的结束条件，当元素都添加足够就结束了，即元素个数等于数组的长度
        */
        
        ArrayList<List<Integer>> res = new ArrayList<>();

        if(nums == null)
            return null;

        if(nums.length == 0){  
            
            res.add(new ArrayList<Integer>());
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();

        //先将数组排序，这样相同元素将会出现在一起
        Arrays.sort(nums);

        int n = nums.length;
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
        
            // 0标识未访问
            visited[i] = 0;
        }
        
        dfs(res, list, visited, nums);
        return res;
    }

    private void dfs(ArrayList<List<Integer>> res, ArrayList<Integer> list, int[] visited, int[] nums) {

        if(nums.length == list.size()){
            
            res.add( new ArrayList<Integer>(list));
        }

        //回溯法，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除
        for(int i = 0; i < nums.length; i++){
            
            /*去除重复元素影响：
            
                比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二个2，
                如果在结果中互换位置，也认为是同一种方案，
                
                所以强制要求相同的数字，原来排在前面的，在结果当中也应该排在前面，
                这样就保证了唯一性
                
                所以当前面的2还没有使用的时候，就不应该让后面的2使用
            */
            if(visited[i] == 1 || i > 0 && (visited[i - 1] == 0 && nums[i] == nums[i - 1])){
				
				//跳过当前循环，进入下一个循环(i+1)
				continue;
			}
                
            list.add(nums[i]);
            visited[i] = 1;
            
            dfs(res, list, visited, nums);
            
            list.remove(list.size()-1);
            
            visited[i] = 0;

        }
    } 
    
}