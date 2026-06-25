package ShortestPathAlgorithms.SingleSourceShortestPath;

import java.util.*;

public class BFS {

    static class Graph {
        int V;
        List<Integer>[] adj;

        Graph(int V) {
            this.V = V;

            adj = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u); // Undirected graph
        }
    }

    static void shortestPath(Graph graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.V];
        int[] distance = new int[graph.V];
        int[] parent = new int[graph.V];
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);
        queue.offer(source);
        visited[source] = true;
        distance[source] = 0;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            for (int neighbor : graph.adj[front]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[front] + 1;
                    parent[neighbor] = front;
                }
            }
        }
        for (int i = 0; i < graph.V; i++) System.out.println("Shortest distance to " + i + " is " + distance[i] + " and parent is " + parent[i]);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        shortestPath(graph, 0);
    }
}