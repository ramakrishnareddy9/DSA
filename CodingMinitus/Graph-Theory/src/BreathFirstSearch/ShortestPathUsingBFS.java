package BreathFirstSearch;

import java.util.*;
/*
 * Question:
 * Find shortest path distances in an undirected graph using BFS.
 */
public class ShortestPathUsingBFS {
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

        public void shortestPathUsingBFS(int source) {
            if (source < 0 || source >= V) {
                throw new IllegalArgumentException("Source vertex out of range: " + source);
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];
            int distance[] = new int[V];
            int parent[] = new int[V];
            Arrays.fill(parent, -1);

            queue.offer(source);
            visited[source] = true;
            parent[source] = source;
            distance[source] = 0;

            while (!queue.isEmpty()) {
                int front = queue.poll();
                System.out.print(front + " ");

                for (int neighbor : adjacencyList[front]) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                        // update distance and parent
                        distance[neighbor] = distance[front] + 1;
                        parent[neighbor] = front;
                    }
                }
            }
            System.out.println();
            for(int i=0;i<V;i++){
                System.out.println("Shortest distance to`"+i+"` is "+distance[i]+" and parent is "+parent[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.shortestPathUsingBFS(4);
    }

}
