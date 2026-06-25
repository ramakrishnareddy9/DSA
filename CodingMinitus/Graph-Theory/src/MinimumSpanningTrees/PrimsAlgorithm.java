package MinimumSpanningTrees;

import java.util.*;

/*
Given a connected undirected weighted graph G,
find a Minimum Spanning Tree (MST).

Prim's Algorithm (Lazy Version)
Time Complexity: O(E log E)
*/

public class PrimsAlgorithm {

    static class Graph {
        int V;
        List<int[]>[] adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        }
        void addEdge(int u, int v, int w) {
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int[] edge : adj[i]) {
                    System.out.print("(" + edge[0] + "," + edge[1] + ") ");
                }
                System.out.println();
            }
        }
    }

    static class Pair {
        int weight;
        int node;
        int parent;

        Pair(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    static int prims(Graph graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] visited = new boolean[graph.V];
        int mstWeight = 0;
        // Start from vertex 0
        pq.offer(new Pair(0, 0, -1));
        System.out.println("Edges in MST:");
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;
            int parent = curr.parent;

            if (visited[node]) continue;
            visited[node] = true;
            mstWeight += weight;
            if (parent != -1) System.out.println(parent + " - " + node + " : " + weight);

            for (int[] edge : graph.adj[node]) {
                int neighbour = edge[0];
                int edgeWeight = edge[1];
                if (!visited[neighbour]) pq.offer(new Pair(edgeWeight,neighbour,node));
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.printGraph();
        int mstWeight = prims(g);
        System.out.println("\nTotal MST Weight = " + mstWeight);
    }
}