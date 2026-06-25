package BreathFirstSearch;

import java.util.*;

/*
 * Question:
 * Traverse a graph using Breadth-First Search (BFS).
 */
public class BSF_OnAdjacencyListUsnigHashMap {

    static class Graph {
        Map<Integer, List<Integer>> adjacencyList;
         Graph(int V) {
            adjacencyList = new HashMap<>();

            for (int i = 0; i < V; i++) {
                adjacencyList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u); // Remove this line for directed graph
        }

        public void displayGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {

                System.out.print(entry.getKey() + " -> ");

                for (int neighbor : entry.getValue()) {
                    System.out.print(neighbor + " ");
                }

                System.out.println();
            }
        }

        public void bfs(int source) {

            if (!adjacencyList.containsKey(source)) throw new IllegalArgumentException("Invalid source vertex");
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(source);
            visited.add(source);

            while (!queue.isEmpty()) {

                int current = queue.poll();
                System.out.print(current + " ");

                for (int neighbor : adjacencyList.get(current)) {

                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
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

