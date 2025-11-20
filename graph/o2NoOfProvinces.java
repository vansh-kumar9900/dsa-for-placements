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
