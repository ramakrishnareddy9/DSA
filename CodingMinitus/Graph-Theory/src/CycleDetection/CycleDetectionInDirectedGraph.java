package CycleDetection;

import java.util.*;

public class CycleDetectionInDirectedGraph {
    static class Graph{
        int V;
        List<Integer> adjacencyList[];

        Graph(int V){
            this.V = V;
            adjacencyList = new ArrayList[V];
            for(int i=0;i<V;i++) adjacencyList[i] = new ArrayList<>();
        }

        void addEdge(int v,int u){
            adjacencyList[v].add(u);
        }

        void printGraph(){
            for(int i=0;i<V;i++){
                System.out.print(i+" -> ");
                for(int j:adjacencyList[i]) System.out.print(j+" ");
                System.out.println();
            }
        }
    }

    static boolean isCyclic(Graph graph){
        boolean visited[] = new boolean[graph.V];
        boolean pathVisited[] = new boolean[graph.V];
        for(int i=0;i<graph.V;i++){
            if(!visited[i]) {
                if(dfs(i,visited,pathVisited,graph)) return true;
            }
        }
        return false;
    }

    static boolean dfs(int node, boolean visited[], boolean pathVisited[], Graph graph) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int nbr : graph.adjacencyList[node]) {
            if (!visited[nbr]) {
                if (dfs(nbr, visited, pathVisited, graph)) return true;
            }
            else if (pathVisited[nbr]) return true;
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        System.out.println(isCyclic(graph));
    }
}
