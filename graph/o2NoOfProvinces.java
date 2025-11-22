package graph;
import java.util.*;

public class o2NoOfProvinces {    // leetcode-547
    public int findCircleNum(int[][] matrix) {
        int N = matrix.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adjLs.add(new ArrayList<>());
        }
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] visited = new int[N];
        Arrays.fill(visited,0);
        int count = 0;
        for(int i = 0;i < N; i++){
            if(visited[i] == 0){
                count++;
                solvedfs(i,adjLs,visited);
            }
        }
        return count;
    }
    public void solvedfs(int node,ArrayList<ArrayList<Integer>> adjLs,int[] visited){
        visited[node] = 1;
        for(Integer it : adjLs.get(node)){
            if(visited[it] == 0){
                solvedfs(it,adjLs,visited);
            }
        }
    }
}


// ⭐⭐ Difference between Number of Provinces and Number of Islands ⭐⭐

// Number of Provinces

// You have:

// matrix = N x N  
// matrix[i][j] = 1 → city i connected to city j


// This is an Adjacency Matrix of a Graph.

// 👉 Here, number of nodes = N
// 👉 So you only need visited[N]

// There are only N cities, numbered 0 to N-1.

// So a 1D visited is enough:

// visited[i] = 1 or 0

// ⭐ Number of Islands

// You have a grid:

// grid = N rows x M columns
// grid[i][j] = 1 → land
// grid[i][j] = 0 → water


// Here, each cell is a node.

// 👉 Total nodes = N × M
// 👉 Every cell can be land or water.

// So you need a 2D visited:

// visited[i][j] = 1 or 0


// Because row 2 column 3 is different from row 2 column 4.

// ⭐ BIGGEST DIFFERENCE (Understand this!)
// In Provinces → #nodes = N (cities)
// In Islands → #nodes = N×M (cells)

// So structure is different → visited structure must also be different.
