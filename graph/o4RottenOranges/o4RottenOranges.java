package graph.o4RottenOranges;
import java.util.*;
class pair{
    int row;
    int col;
    int time;
    pair(int row , int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class o4RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;
        int freshOranges = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;

        while(!q.isEmpty()){
            pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            minutes = Math.max(time,minutes);
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(Math.abs(i) + Math.abs(j) != 1){
                        continue;
                    }
                    int nr = i + row;
                    int nc = j + col;
                    if(nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshOranges--;
                        q.add(new pair(nr,nc,time+1));
                    }
                }
            }
        }
        if(freshOranges > 0){
            return -1;
        }
        return minutes;
    }
}