package DirectAcyclicGraph;

import java.util.*;

public class TopologicalSortUsingDFS {
    static class Graph {
        int V;
        List<Integer> adj[];
        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }

        void addEdge(int v, int u) {
            adj[v].add(u);
        }

        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int nbr : adj[i]) System.out.print(nbr + " ");
                System.out.println();
            }
        }
    }

    static void topologicalSort(Graph graph){
        boolean[] visited = new boolean[graph.V];
        Stack<Integer> ordering = new Stack<>();

        for(int i = 0; i < graph.V; i++){
            if(!visited[i]) dfs(graph,i,visited,ordering);
        }
        while (!ordering.isEmpty()) {
            System.out.print(ordering.pop() + " ");
        }
    }

    static void dfs(Graph graph,int node,boolean[] visited,Stack<Integer> ordering){
        visited[node] = true;
        for(int nbr : graph.adj[node]){
            if(!visited[nbr]){
                dfs(graph,nbr,visited,ordering);
            }
        }
        ordering.add(node);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.printGraph();
        topologicalSort(graph);
    }
}