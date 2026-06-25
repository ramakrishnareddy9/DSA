package CycleDetection;

import java.util.*;

/*
A bipartite graph is where we can divide all vertex into 2 sets
such that all edges of the graph are from set1 to set2.
*/

public class BipartedGraph {
    static class Graph {
        int V;
        List<Integer>[] adjacencyList;

        Graph(int V) {
            this.V = V;
            adjacencyList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int nbr : adjacencyList[i]) {
                    System.out.print(nbr + " ");
                }
                System.out.println();
            }
        }
    }

    // ================= DFS =================
    static boolean isBipartiteDFS(Graph graph) {
        int[] color = new int[graph.V];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) return false;
            }
        }
        return true;
    }

    static boolean dfs(int node,int clr,int[] color,Graph graph) {
        color[node] = clr;
        for (int nbr : graph.adjacencyList[node]) {
            if (color[nbr] == -1) {
                if (!dfs(nbr, 1 - clr, color, graph)) return false;
            }
            else if (color[nbr] == clr) return false;
        }
        return true;
    }

    // ================= BFS =================
    static boolean isBipartiteBFS(Graph graph) {
        int[] color = new int[graph.V];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.V; i++) {
            if (color[i] != -1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int nbr : graph.adjacencyList[node]) {
                    if (color[nbr] == -1) {
                        color[nbr] = 1 - color[node];
                        queue.offer(nbr);
                    }
                    else if (color[nbr] == color[node]) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println("DFS : " + isBipartiteDFS(graph));
        System.out.println("BFS : " + isBipartiteBFS(graph));
    }
}