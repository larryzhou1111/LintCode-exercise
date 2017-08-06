/*
@Author:   larryzhou
@Problem:  矩阵中的路径（剑指offer题66）
@Language: Java
@Datetime: 17-08-6 21:00
*/
        
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        		
		/*  矩阵中的路径
		
			请设计一个函数，用来判断在一个矩阵中，是否存在一条包含某字符串所有字符的路径
			路径可从矩阵中的任意一格开始，每一步可以在矩阵中向左，向右，向上，向下移动一格
			
			如果一条路径经过了矩阵中的某一格，则该路径不能再进入该格子
			
			例如矩阵 a b c e 
					 s f c s 
				     a d e e 		
			矩阵中包含一条"bcced"的路径，但是不包含"abcb"路径
			因为字符串的第一个字符b占据了矩阵中的第一行第二格之后，路径不能再次进入该格子
		*/
		
        /*
		  思路：优化版回溯法

		   1.将matrix字符串模拟映射为一个字符矩阵(但并不实际创建一个矩阵)
		   2.取一个boolean[matrix.length]标记某个字符是否已经被访问过
		   3.如果没找到结果，需要将对应的boolean标记值置回false,返回上一层进行其他分路的查找
        */
        if(matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
		
        boolean[] visited = new boolean[matrix.length];
        
        for(int i = 0; i < rows; i++){
            
            for(int j = 0; j < cols; j++){
                
                if(searchFromHere(matrix, rows, cols, i, j, 0, str,visited)){
	
					return true;
				}
            }
        }

        return false;
    }
    
    public boolean searchFromHere(char[] matrix,int rows,int cols,int r,int c,int index,char[] str,boolean[] visited){
        
        if(r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
            return false;
        
        if(index == str.length - 1)    
            return true;
        
        visited[r * cols + c] = true;
        
		//向上、左、下、右进行搜索
        if(searchFromHere(matrix, rows, cols, r - 1, c, index + 1, str, visited) ||
           searchFromHere(matrix, rows, cols, r, c - 1, index + 1, str, visited) ||
           searchFromHere(matrix, rows, cols, r + 1, c, index + 1, str, visited) ||
           searchFromHere(matrix, rows, cols, r, c + 1, index + 1, str, visited)){
            
            return true;
        }
            
        visited[r * cols + c] = false;
        
        return false;
    }

}