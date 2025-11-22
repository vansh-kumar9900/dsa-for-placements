package graph;
import java.util.*;
class o3NoOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for(int[] a : visited){
            Arrays.fill(a,0);
        }
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' &&  visited[i][j] == 0){
                    count++;
                    solveDfsGrid(i,j,visited,grid);
                }
            }
        }
        return count;
    }
    public void solveDfsGrid(int row, int col, int[][] visited, char[][] grid){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        for(int nakliRow = -1 ; nakliRow <= 1 ; nakliRow++){
            for(int nakliCol = -1 ; nakliCol <= 1 ; nakliCol++){
                if( Math.abs(nakliRow) + Math.abs(nakliCol) != 1){
                    continue;   // for skipping all the diagnol elements 
                }
                int neighbourRow = row + nakliRow;
                int neighbourCol = col + nakliCol;
                if(neighbourRow >= 0 && neighbourRow < n &&
                neighbourCol >= 0 && neighbourCol < m &&
                visited[neighbourRow][neighbourCol] == 0 &&
                grid[neighbourRow][neighbourCol] == '1'){
                    solveDfsGrid(neighbourRow,neighbourCol,visited,grid);
                }
            }
        }
    }
}

// ⭐ 1. How do we calculate the 8 directions using nested loops?

// In grid problems, each cell has up to 8 neighbors:

// ↖  ↑  ↗
// ←  •  →
// ↙  ↓  ↘


// To generate these 8 directions, we use two nested loops:

// for (int nakliRow = -1; nakliRow <= 1; nakliRow++) {
//     for (int nakliCol = -1; nakliCol <= 1; nakliCol++) {
//         int newRow = row + nakliRow;
//         int newCol = col + nakliCol;
//     }
// }


// This loop generates every combination of:

// (-1,-1)  (-1,0)  (-1,1)
// ( 0,-1)  ( 0,0)  ( 0,1)
// ( 1,-1)  ( 1,0)  ( 1,1)


// Total = 9 pairs
// (8 neighbors + the original cell)

// This gives 8-direction movement (diagonals included).

// ⭐ 2. Why does this generate diagonal movement?

// Because values like:

// (-1,-1), (-1,1), (1,-1), (1,1)


// represent diagonal moves:

// ↖ ↗ ↙ ↘


// In some problems (like flood fill, 8-direction BFS), diagonals are allowed — so this loop works directly.

// But…

// ⭐ 3. Why can’t we use 8 directions for LeetCode “Number of Islands”?

// Because the problem states:

// Two land cells are connected only if they share a side (not a corner).

// Sharing a side = only 4 directions:

// UP    → (-1,0)
// DOWN  → (1,0)
// LEFT  → (0,-1)
// RIGHT → (0,1)


// Diagonal contact is NOT considered connected.

// So we MUST use only the 4 straight directions.

// ⭐ 4. How to extract only the 4 directions from the 8? (The KEY idea)

// From the 9 combinations:

// (-1,-1)  (-1,0)  (-1,1)
// ( 0,-1)  ( 0,0)  ( 0,1)
// ( 1,-1)  ( 1,0)  ( 1,1)


// We want only these:

// (-1,0)
// (1,0)
// (0,-1)
// (0,1)


// These represent movements where:

// 👉 We move 1 step in only ONE axis
// 👉 And 0 steps in the other axis

// This gives us the key mathematical rule:

// ⭐ 5. The MAGIC condition

// Only keep directions where:

// abs(nakliRow) + abs(nakliCol) == 1


// Why this works:

// Direction	nakliRow	nakliCol	Sum	Keep?
// UP	-1	0	1	✔
// DOWN	1	0	1	✔
// LEFT	0	-1	1	✔
// RIGHT	0	1	1	✔
// Diagonals	-1/-1	1	2	❌
// Same cell	0	0	0	❌

// So:

// SUM = 1 → valid straight move

// SUM = 2 → diagonal → reject

// SUM = 0 → same cell → reject

// This single line turns 8-direction loops into 4-direction loops.

// ⭐ 6. Putting it inside the loop

// (your exact style)

// for (int nakliRow = -1; nakliRow <= 1; nakliRow++) {
//     for (int nakliCol = -1; nakliCol <= 1; nakliCol++) {

//         if (Math.abs(nakliRow) + Math.abs(nakliCol) != 1)
//             continue;

//         int neighbourRow = row + nakliRow;
//         int neighbourCol = col + nakliCol;


// This is your working 4-direction DFS logic.

// ⭐ 7. Why this is the best method?

// ✔ You continue using the same nested loop approach you are comfortable with
// ✔ You build logic on top of 8-direction movement
// ✔ You use a single mathematical filter to remove diagonals
// ✔ You never need direction arrays like dx[] or dy[]
// ✔ Your DFS becomes clean and consistent for future problems

// This approach is easy to remember and ideal for revision.

// ⭐ 8. Final takeaway (paste this in your VS Code notes)

// “8 directions come from nested loops of -1 to 1.
// For 4 directions, keep only those with abs(dr) + abs(dc) == 1.”

// This ONE sentence captures the entire concept.