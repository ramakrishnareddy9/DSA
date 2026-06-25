package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class DFS_AdjacencyList {

    static class Graph {
        private int V;
        private List<List<Integer>> adjacencyList;

        public Graph(int V) {
            this.V = V;
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u); // Remove for directed graph
        }

        public void displayGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");

                for (int vertex : adjacencyList.get(i)) {
                    System.out.print(vertex + " ");
                }
                System.out.println();
            }
        }
    }

    void dfs(Graph graph, int source) {
        boolean[] visited = new boolean[graph.V];
        helper(graph, source, visited);
    }

    void helper(Graph graph, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int vertex : graph.adjacencyList.get(source)) {
            if (!visited[vertex]) {
                helper(graph, vertex, visited);
            }
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.displayGraph();
        System.out.print("DFS Traversal: ");
        DFS_AdjacencyList obj = new DFS_AdjacencyList();
        obj.dfs(graph, 0);
    }
}