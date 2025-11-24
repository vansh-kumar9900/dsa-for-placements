package graph.o1traversals;

import java.util.*;
public class o1traversals {
    public ArrayList<Integer> bsfGraph(int N, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bsf = new ArrayList<>();
        int visited[] = new int[N];
        Arrays.fill(visited,0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int node = q.poll(); 
            bsf.add(node);
            for(Integer i : adj.get(node)){
                if(visited[i] == 0){
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
        return bsf;      
    }


    public ArrayList<Integer> dfsGraph(int N,ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[N];
        Arrays.fill(visited,0);
        ArrayList<Integer> dfs = new ArrayList<>();
        solvedfs(0,adj,visited,dfs);
        return dfs;
    }
    public void solvedfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,ArrayList<Integer> dfs){
        visited[node] = 1;
        dfs.add(node);
        for(Integer i : adj.get(node)){
            if(visited[i] == 0){
                solvedfs(i,adj,visited,dfs);
            }
        }
    }
}