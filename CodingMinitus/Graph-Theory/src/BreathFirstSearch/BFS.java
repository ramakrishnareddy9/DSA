package BreathFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Question:
 * Traverse a graph using Breadth-First Search (BFS).
 */
public class BFS {
    static class Graph {
        int V;
        List<Integer>[] adjacencyList;

        public Graph(int V) {
            this.V = V;
            adjacencyList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }
        
        public void addEdge(int u, int v) {
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);   // Remove this line for directed graph 
        }
        
        public void displayGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int vertex : adjacencyList[i]) {
                    System.out.print(vertex + " ");
                }
                System.out.println();
            }
        }

        public void bfs(int source) {
            if (source < 0 || source >= V) {
                throw new IllegalArgumentException("Source vertex out of range: " + source);
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];

            queue.offer(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int front = queue.poll();
                System.out.print(front + " ");

                for (int neighbor : adjacencyList[front]) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        
        System.out.println("Graph representation using Adjacency List:");
        graph.displayGraph();

        System.out.println("Breadth First Traversal starting from vertex 0:");
        graph.bfs(0);
    }
}
