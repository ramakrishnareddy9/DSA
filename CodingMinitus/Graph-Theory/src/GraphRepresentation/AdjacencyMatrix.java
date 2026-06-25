package GraphRepresentation;

public class AdjacencyMatrix {
    static class GraphMatrix {
        int V;
        int[][] adjMatrix;

        GraphMatrix(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
        }

        void addEdge(int u, int v) {
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; // Remove for Drirected Graph
        }

        void printGraph() {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.printGraph();
    }
}
