package graph;
import java.util.*;
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class o3_1NoOfIslandsBFS {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int row, int col, int[][] visited, char[][] grid) {

        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            // visit all 8 neighbors
            for (int nakliRow = -1; nakliRow <= 1; nakliRow++) {
                for (int nakliCol = -1; nakliCol <= 1; nakliCol++) {

                    int nrow = r + nakliRow;
                    int ncol = c + nakliCol;

                    // boundary check + land check + unvisited check
                    if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' &&
                        visited[nrow][ncol] == 0) {

                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
