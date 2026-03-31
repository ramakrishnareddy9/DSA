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

	static class GraphUsingNode {
		Map<String, Node> nodes;

		GraphUsingNode(List<String> cities) {
			nodes = new LinkedHashMap<>();
			for (String city : cities) {
				nodes.put(city, new Node(city));
			}
		}

		public void addEdge(String from, String to) {
			addEdge(from, to, false);
		}

		public void addEdge(String from, String to, boolean undirected) {
			if (!nodes.containsKey(from) || !nodes.containsKey(to)) {
				throw new IllegalArgumentException("Both cities must exist in the graph.");
			}

			nodes.get(from).neighbors.add(to);

			if (undirected) {
				nodes.get(to).neighbors.add(from);
			}
		}

		public void printAdjList() {
			for (Map.Entry<String, Node> entry : nodes.entrySet()) {
				String city = entry.getKey();
				Node node = entry.getValue();

				System.out.print(city + " -> ");
				for (String neighbor : node.neighbors) {
					System.out.print(neighbor + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Delhi", "London", "Paris", "NewYork");
		GraphUsingNode graph = new GraphUsingNode(cities);

		graph.addEdge("Delhi", "London", true);
		graph.addEdge("Delhi", "Paris", true);
		graph.addEdge("London", "NewYork", true);

		System.out.println("Adjacency List Representation Using Node:");
		graph.printAdjList();
	}
}
