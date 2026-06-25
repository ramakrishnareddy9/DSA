package GraphRepresentation;

import java.util.*;

/*
 * Question:
 * Represent a graph using adjacency lists and demonstrate graph construction.
 */
class Graph1 {

    private int V;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph1(int V) {
        this.V = V;
        adjacencyList = new HashMap<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);   // Remove this line for directed graph
    }

    public void displayGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");

            for (int vertex : adjacencyList.get(i)) {
                System.out.print(vertex + " ");
            }

            System.out.println();
        }
    }
}

public class AdjacencyListRepresentationUsingHashMap {
    public static void main(String[] args) {
        Graph1 graph = new Graph1(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        System.out.println("Graph representation using Adjacency List:");
        graph.displayGraph();
    }
}
