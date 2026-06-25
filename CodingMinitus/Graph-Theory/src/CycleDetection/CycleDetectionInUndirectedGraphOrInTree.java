package CycleDetection;

import java.util.*;

public class CycleDetectionInUndirectedGraphOrInTree {
    boolean isCycle(int V, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < V; i++) adj.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    boolean dfs(int node,int parent,boolean[] visited,Map<Integer, List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            } else if (neighbor != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionInUndirectedGraphOrInTree cycleDetection = new CycleDetectionInUndirectedGraphOrInTree();
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        System.out.println(cycleDetection.isCycle(V, edges));
    }
}
