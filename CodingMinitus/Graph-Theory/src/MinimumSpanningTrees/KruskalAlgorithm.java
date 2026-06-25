package MinimumSpanningTrees;

import java.util.*;

public class KruskalAlgorithm {

    static class Edge {
        int u;
        int v;
        int weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }

        int find(int x) {
            if (parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int set1 = find(x);
            int set2 = find(y);

            if (set1 == set2) return;

            if (rank[set1] < rank[set2]) parent[set1] = set2;
            else if (rank[set1] > rank[set2]) parent[set2] = set1;
            else {
                parent[set2] = set1;
                rank[set1]++;
            }
        }
    }

    static int kruskal(int V, List<Edge> edges) {
        Collections.sort(edges,Comparator.comparingInt(e -> e.weight));
        DSU dsu = new DSU(V);

        int mstWeight = 0;
        int edgeCount = 0;
        System.out.println("Edges in MST:");
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.weight;
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                mstWeight += w;
                edgeCount++;
                System.out.println(u + " - " + v + " : " + w);
                if (edgeCount == V - 1) break;
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        int mstWeight = kruskal(4, edges);
        System.out.println("\nTotal MST Weight = " + mstWeight);
    }
}