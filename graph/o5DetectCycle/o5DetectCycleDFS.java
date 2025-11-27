package graph.o5DetectCycle;

import java.util.*;

class o5DetectCycleDFS {

    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int node, int parent, int[] visited, List<Integer>[] adj) {
        visited[node] = 1;

        for (int it : adj[node]) {

            if (visited[it] == 0) {
                if (dfs(it, node, visited, adj)) return true;
            } 
            else if (it != parent) {
                return true;
            }
        }
        return false;
    }
}
