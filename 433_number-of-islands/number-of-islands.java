/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-06-12 14:21
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        
        /*
        本质是求矩阵中连续区域的个数，需要用深度优先搜索DFS来解
            对于一个为‘1’且未被访问过的位置，我们递归进入其上下左右位置上为‘1’的数
            将其对应值赋为false，继续进入其所有相连的邻位置
            这样可以将这个连通区域所有的数找出来，并将其对应的值赋false
            找完次区域后，我们将结果num自增1
            然后我们在继续找下一个为‘1’且未被访问过的位置
            以此类推直至遍历完整个原数组即可得到最终结果
        */
        int num = 0; 
        
        if(grid == null)
            return 0;
    
        //双层for循环逐个遍历矩阵的元素
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j < grid[i].length; j++){
                
                if(grid[i][j] == true){
                    
                    change(grid, i, j);
                    num++;
                }
            }
        }
       return num; 
    }
    
    public void change(boolean[][] grid, int i, int j){
        
        //将当前位置置为false，表示已访问过;
        grid[i][j] = false;
        
        //递归当前位置的前后左右，和它相邻的为true的上下左右元素
        //和相邻的相邻的....  这些元素改为false
        
        //上边
        if(i > 0 && grid[i - 1][j] == true){
            
            change(grid, i - 1, j);
        }
        
        //下边
        if(i < grid.length - 1 && grid[i + 1][j] == true){
            
            change(grid, i + 1, j);
        }
        
        //左边
        if(j > 0 && grid[i][j - 1] == true){
            
            change(grid, i, j - 1);
        }
        
        //右边
        if(j < grid[i].length - 1 && grid[i][j + 1] == true){
            
            change(grid, i, j + 1);
        }        
    }
}