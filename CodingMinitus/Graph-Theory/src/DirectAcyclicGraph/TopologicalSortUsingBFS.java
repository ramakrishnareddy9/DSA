package DirectAcyclicGraph;

import java.util.*;

public class TopologicalSortUsingBFS {
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

    static void topologicalSort(Graph graph, int source) {
        int[] indegree = new int[graph.V];
        for (int i = 0; i < graph.V; i++) {
            for (int nbr : graph.adj[i]) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int nbr : graph.adj[node]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) queue.offer(nbr);
            }
        }
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
        topologicalSort(graph, 0);
    }
}
