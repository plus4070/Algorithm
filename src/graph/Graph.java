package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	int vertexCount;
	List<Vertex> vertices;
	
	Graph() {
		this.vertices= new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
		this.vertexCount++;
	}
	
	public void addEdge(Vertex vertex, Edge edge) {
		for(Vertex vertexInList : vertices) {
			if(vertexInList.compareTo(edge.from) == 1) {
				vertexInList.adjacentList.add(edge);
			} else if(vertexInList.compareTo(edge.end) == 1) {
				vertexInList.adjacentList.add(edge);
			}
		}
	}
}
