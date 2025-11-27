package graph.o5DetectCycle;
import java.util.*;
class pair{
    int child;
    int parent;
    pair(int child,int parent){
        this.child = child;
        this.parent = parent;
    }
}
class o5DetectCycleBFS {
  public boolean isCycle(int V, List<Integer>[] adj) {
    int[] visited = new int[V];
    Arrays.fill(visited,0);
    boolean ans = false;
    for(int i = 0; i < V; i++){
        if(visited[i] == 0){
            ans = checkCycle(i,V,visited,adj);
            if(ans == true) return true;
        }
    }
    return ans;
  }
  public boolean checkCycle(int idx, int V, int[] visited, List<Integer>[] adj){
    visited[idx] = 1;
    Queue< pair > q = new LinkedList<>();
    q.add(new pair(idx,-1));
    while(!q.isEmpty()){
        pair p = q.poll();
        int child = p.child;
        int parent = p.parent;
        for(int it : adj[child]){
            if(visited[it] == 0){
                q.add(new pair(it,child));
                visited[it] = 1;
            }
            else if(visited[it] == 1 && it != parent){
                return true;
            }
        }
    }
    return false;
  }
}