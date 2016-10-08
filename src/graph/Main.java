package graph;

import java.util.stream.Collectors;

public class Main {
	public static void main(String args[]) {
		Graph graph = new Graph();

		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		
		graph.addEdge(a, new Edge(3, a, b));
		graph.addEdge(a, new Edge(2, a, c));
		graph.addEdge(a, new Edge(6, a, d));
		graph.addEdge(b, new Edge(1, b, c));
		graph.addEdge(b, new Edge(4, b, d));
		
		System.out.println(graph.vertices.stream()
				.filter(vertex->!vertex.name.equals(""))
				.map(Vertex::getName)
				.collect(Collectors.toList()));
		
		
	}
}
