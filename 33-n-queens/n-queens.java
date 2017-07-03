/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/n-queens/
@Language: Java
@Datetime: 17-7-3 11:00
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
     
    //写法2：private ArrayList<ArrayList<String>> res = new ArrayList<>();
     
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        
        //需回顾！！！
        
        /* N皇后问题
           n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。

          给定一个整数n，返回所有不同的n皇后问题的解决方案。
          每个解决方案包含一个明确的n皇后放置布局，
          其中“Q”和“.”分别表示一个女王和一个空位置。
          
        */
        
        //写法1：
        /*
            首先判断怎样的位置是可行的，也就是不在同一行，不在同一列，且不在对角线上
            自然每个都在不同行上，所以可以把问题简化，在每一行找可以放进皇后的列

            一行一行的找，遇到可以的列就加进去
            当list的大小等于n的时候，就说明加满了，可以把结果存进去
        */
        
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        
        if (n <= 0)
            return results;

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private void search(ArrayList<ArrayList<String>> results,
                        ArrayList<Integer> cols,
                        int n) {
                            
        if(cols.size() == n){
            
            results.add(drawChessboard(cols));
            return;
        }

        for(int colIndex = 0; colIndex < n; colIndex++){
            
            if(!isValid(cols, colIndex)){
                
                continue;
            }
            
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }


    private ArrayList<String> drawChessboard(ArrayList<Integer> cols) {
        
        ArrayList<String> chessboard = new ArrayList<>();
        
        for (int i = 0; i < cols.size(); i++) {
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < cols.size(); j++){
                
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            
            chessboard.add(sb.toString());
        }
        
        return chessboard;
    }


    private boolean isValid(ArrayList<Integer> cols, int column) {
        
        //cols存储了每一行Q所在的列
        int row = cols.size();

        //不能在同一列，且不能为对象线上的元素
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            
            if(cols.get(rowIndex) == column){
                return false;
            }
            
            if(Math.abs(rowIndex - row) == Math.abs(column - cols.get(rowIndex))){
                return false;
            }

        }
        
        return true;
        
        
        //写法2：参考https://segmentfault.com/a/1190000005146494
        /*
          放皇后的流程有一个概念：

            结果数组res的形式：包含所有满足条件的，长度为n(row行)的字符串数组cur；
            每个字符串代表一行的皇后摆法；
            
            首先，在主函数中向结果数组res的一个子集cur，
            并初始化这个cur中所有元素为长度n,且所有字符都是'.'的字符串
            然后调用helper函数
            
            在helper函数中，结果数组res，目标行数n，和基本子集cur都是确定的，
            唯一的变量是会被递归的当前行数row
            
            从基本子集cur中取出这一行进行修改：遍历这一行的每个元素，即遍历列数j，
            然后在第row行第j列的这个元素为'Q'时,
            满足N皇后条件isValid(n, cur, row, j)的情况下，将这个元素设为'Q'
            
            isValid(n, cur, row, col)的意思：
            
            isValid()就是当我们想在第i行j列放上Queen的时候，先遍历上面的i-1行，
            判断有没有能攻击到当前皇后的皇后
            
            所以在helper函数中，若之前的行中没有威胁到当前遍历到的第row行第j列,
            这个皇后的其它皇后的话，就更新这一行并存入子集cur，然后递归下一行。
            
            递归之后，再将这个皇后换成字符'.'，以便在下一个循环中将第j+1个字符设为皇后并递归。
            
            当helper函数第n-1次递归的时候，row == n，
            此时将已经完成皇后排列的当前子集cur放入res
            
        */
        /*
        StringBuilder[] board = new StringBuilder[n];
        
        //initialize
        for(int i = 0; i < n; i++){   
            
            board[i] = new StringBuilder();
            
            for(int j = 0; j < n; j++){
                
                board[i].append('.');                
            }    
        }
        
        int[] visited = new int[n];
        // i+j
        int[] set1 = new int[2 * n];  
        // i-j
        int[] set2 = new int[2 * n];   
        
        dfs(board, set1, set2, visited, 0);
        
        return res;
    }
    
    //深度遍历+回溯
    public void dfs(StringBuilder[] board, int[] set1, int[] set2
                                         , int[] visited, int idx){
                                             
        int n = board.length;
        
        if(idx == n){
            
            ArrayList<String> a = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                
                a.add(board[i].toString());
            }
            
            res.add(a);
            return;
        }
        
        for(int j = 0; j < n; j++){
            
            if(visited[j] == 0 && set1[idx + j] == 0 && set2[n + idx - j] == 0){
                
                visited[j] = 1;
                set1[idx + j] = 1;
                set2[n + idx - j] = 1;
                
                board[idx].setCharAt(j, 'Q');
                
                dfs(board, set1, set2, visited, idx + 1);
                
                visited[j] = 0;
                set1[idx + j] = 0;
                set2[n + idx - j] = 0;
                
                board[idx].setCharAt(j, '.');
                
            }
        }  
        */
    }
};