package graph.o6Matrix01;
import java.util.*;
class pair{
    int row;
    int col;
    int dis;
    pair(int row,int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
class o6Matrix01problem {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        Queue< pair > q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = 0;
                    q.add(new pair(i,j,0));
                }
                if(mat[i][j] == 1){
                    visited[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int dis = node.dis;
            for(int i = -1;i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(Math.abs(i) + Math.abs(j) != 1){
                        continue;
                    }
                    int neighbourRow = i + row;
                    int neighbourCol = j + col;
                    if(neighbourRow >= 0 && neighbourRow < m &&
                    neighbourCol >= 0 && neighbourCol < n){
                        if(visited[neighbourRow][neighbourCol] == -1){
                            visited[neighbourRow][neighbourCol] = dis+1;
                            q.add(new pair(neighbourRow,neighbourCol,dis+1));
                        }
                    }
                }
            }
        }
        return visited;
    }
}