package graph.o8NoOfEnclaves;

class o8NoOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < col; i++){
            if(grid[0][i] == 1){
                solveDfsBoundary(grid,0,i);
            }
            if(grid[row-1][i] == 1){
                solveDfsBoundary(grid,row-1,i);
            }
        }
        for(int i = 0; i < row; i++){
            if(grid[i][0] == 1){
                solveDfsBoundary(grid,i,0);
            }
            if(grid[i][col-1] == 1){
                solveDfsBoundary(grid,i,col-1);
            }
        }
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    count++;  
                }
            }
        }
        return count;
    }
    public void solveDfsBoundary(int[][] grid,int row,int col){
        int m = grid.length;
        int n = grid[0].length;
        grid[row][col] = -1;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(Math.abs(i) + Math.abs(j) != 1){
                    continue;
                }
                int nrow = row + i;
                int ncol = col + j;
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                grid[nrow][ncol] == 1){
                    solveDfsBoundary(grid,nrow,ncol);
                }
            }
        }
    }
}