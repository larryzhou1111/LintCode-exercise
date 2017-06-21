/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/valid-sudoku/
@Language: Java
@Datetime: 17-06-21 14:54
*/

class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        
        //判断9个是否已填数据，保存其结果
        boolean[] visited = new boolean[9];
        
        //检查行
        for(int i = 0; i < 9; i++){
            
            //先默认没填充数据
            Arrays.fill(visited, false);
            
            for(int j = 0; j < 9; j++){
                
                if(!check(visited, board[i][j]))
                    return false;
                    
            }
        }
        
        //检查列
        for(int i = 0; i < 9; i++){
            
            //先默认没填充数据
            Arrays.fill(visited, false);
            
            for(int j = 0; j < 9; j++){
                
                if(!check(visited, board[j][i]))
                    return false;
                    
            }
        }
        
        //检查小九宫格
        for(int i = 0; i < 9; i += 3){
            
            for(int j = 0; j < 9; j += 3){
                
                //先默认没填充数据
                Arrays.fill(visited, false);
                
                for(int k = 0; k < 9; k++){
                    
                    if(!check(visited, board[i + k / 3][j + k % 3]))
                        return false;
                        
                }
            }
        }
        return true;
    }
    
    
    private boolean check(boolean[] visited, char digit){
        
        //是'.'，表示可填充
        if(digit == '.')
            return true;
            
        int num = digit - '0';
        
        //数字必须在0-9范围内
        if ( num < 1 || num > 9 || visited[num-1])
            return false;

        visited[num - 1] = true; 	
        
        return true;    	
    }    
};