/*
@Author:   larryzhou
@Problem:  机器人的运动范围（剑指offer题67）
@Language: Java
@Datetime: 17-08-6 21:00
*/
        
public class Solution {
 
	public int movingCount(int threshold, int rows, int cols) {
		
		/*  机器人的运动范围
		
			地上有一个m行和n列的方格，一个机器人从坐标0,0的格子开始移动
			每一次只能向左，右，上，下四个方向移动一格
			
			但是不能进入行坐标和列坐标的数位之和大于k的格子 

			例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18
			但是，它不能进入方格（35,38），因为3+5+3+8 = 19

			请问该机器人能够达到多少个格子？
		*/
		/*
			思路：
			   1.从(0,0)开始走，每成功走一步标记当前位置为true,
					然后从当前位置往四个方向探索，返回1 + 4 个方向的探索值之和
			   
			   2.探索时，判断当前节点是否可达的标准为：
				   1）当前节点在矩阵内
				   2）当前节点未被访问过
				   3）当前节点满足threshold限制
		*/
        
        boolean[][] visited = new boolean[rows][cols];
        
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }
    
    public int countingSteps(int threshold, int rows, int cols, int r, int c, boolean[][] visited){
        
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || bitSum(r) + bitSum(c) > threshold)  
            return 0;
        
        visited[r][c] = true;
        
        //向上、左、下、右搜索
        return countingSteps(threshold, rows, cols, r - 1, c, visited)
             + countingSteps(threshold, rows, cols, r, c - 1, visited)
             + countingSteps(threshold, rows, cols, r + 1, c, visited)
             + countingSteps(threshold, rows, cols, r, c + 1, visited)
             + 1;
    }
    
    //获取数字的各个位的数字之和
    public int bitSum(int t){
        
        int count = 0;
        
        while(t != 0){
            
            count += t % 10;
            t /= 10;
        }
        
        return  count;
    }
}