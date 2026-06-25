package GraphRepresentation;

import java.util.*;

/*
 * Question:
 * Represent a graph using a node-based adjacency list structure.
 */
public class AdjacencyListRepresentationUsingNode {
	static class Node {
		String name;
		List<String> neighbors;

		Node(String name) {
			this.name = name;
			this.neighbors = new ArrayList<>();
		}
	}

	static class Graph {

		Map<String, Node> map = new HashMap<>();

		public Graph(List<String> cities) {
			for (String city : cities) {
				map.put(city, new Node(city));
			}
		}

		public void addEdge(String x, String y, boolean undir) {
			map.get(x).neighbors.add(y);
			if (undir) {
				map.get(y).neighbors.add(x);
			}
		}

		public void printAdjList() {
			for (Map.Entry<String, Node> entry : map.entrySet()) {
				String city = entry.getKey();
				Node node = entry.getValue();
				System.out.print(city + " -> ");

				for (String nbr : node.neighbors) {
					System.out.print(nbr + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Delhi", "London", "Paris", "NewYork");

		Graph graph = new Graph(cities);

		graph.addEdge("Delhi", "London", true);
		graph.addEdge("Delhi", "Paris", true);
		graph.addEdge("London", "NewYork", true);

		System.out.println("Adjacency List Representation Using Node:");
		graph.printAdjList();
	}
}