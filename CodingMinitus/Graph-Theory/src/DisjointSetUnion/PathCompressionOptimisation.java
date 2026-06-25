package DisjointSetUnion;

import java.util.*;

public class PathCompressionOptimisation {
    static class Graph{
        int V;
        List<int[]> edges;
        Graph(int V){
            this.V = V;
            edges = new ArrayList<>();
        }

        void addEdge(int v,int u){
            edges.add(new int[]{v,u});
        }
    }

    static int find(int[] parent, int v) {
        if (parent[v] == -1)
            return v;

        return parent[v] = find(parent,parent[v]);
    }

    static void union(int[] parent, int u, int v, int[] rank) {

        int s1 = find(parent, u);
        int s2 = find(parent, v);

        if (s1 == s2) return;
        if (rank[s1] < rank[s2]) {
            parent[s1] = s2;
        }
        else if (rank[s1] > rank[s2]) {
            parent[s2] = s1;
        }
        else {
            parent[s2] = s1;
            rank[s1]++;
        }
    }

    static boolean containsCycle(BasicDSU.Graph graph){
        int[] parent = new int[graph.V];
        int[] rank = new int[graph.V];
        Arrays.fill(parent,-1);
        Arrays.fill(rank,1);

        for(int i=0;i<graph.edges.size();i++){
            int u = graph.edges.get(i)[0];
            int v = graph.edges.get(i)[1];
            if(find(parent,u) == find(parent,v)) return true;
            else union(parent,u,v,rank);
        }
        return false;
    }

    public static void main(String[] args) {
        BasicDSU.Graph graph = new BasicDSU.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        System.out.println(containsCycle(graph));
    }
}
