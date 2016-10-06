package Test;

public class Edge {
	int weight;
	Vertex from;
	Vertex end;

	Edge(int weight, Vertex from, Vertex end) {
		this.weight = weight;
		this.from = from;
		this.end = end;
	}
}
