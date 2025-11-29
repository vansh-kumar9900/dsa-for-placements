package graph.o7SurroundedRegions;

class o7SurroundedRegions {
    public void solveDFS(char[][] board,int row,int col){
        int m = board.length;
        int n = board[0].length;
        board[row][col] = 'T';
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(Math.abs(i) + Math.abs(j) != 1){
                    continue;
                }
                int nrow = row + i;
                int ncol = col + j;
                if(nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                board[nrow][ncol] == 'O'){
                    solveDFS(board,nrow,ncol);
                }
            }    
        }
    }
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                solveDFS(board,0,i);
            }
            if(board[row-1][i] == 'O'){
                solveDFS(board,row-1,i);
            }
        }
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                solveDFS(board,i,0);
            }
            if(board[i][col-1] == 'O'){
                solveDFS(board,i,col-1);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}