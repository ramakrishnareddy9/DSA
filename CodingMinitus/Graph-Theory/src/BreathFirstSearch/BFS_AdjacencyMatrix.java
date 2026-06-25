package BreathFirstSearch;

import java.util.*;

public class BFS_AdjacencyMatrix {

    static void bfs(int[][] graph, int start) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor = 0; neighbor < V; neighbor++) {
                if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };
        bfs(graph, 0);
    }
}