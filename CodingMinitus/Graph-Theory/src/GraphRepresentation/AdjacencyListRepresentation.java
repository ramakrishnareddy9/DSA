package GraphRepresentation;

import java.util.*;

class Graph {
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
}

public class AdjacencyListRepresentation {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        
        System.out.println("Graph representation using Adjacency List:");
        graph.displayGraph();
    }
}
