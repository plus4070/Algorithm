package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	String name;
	boolean visited;
	List<Edge> adjacentList;
	
	Vertex(String name) {
		this.name = name;
		this.adjacentList = new ArrayList<Edge>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void visitVertex() {
		this.visited = true;
	}

	@Override
	public int compareTo(Vertex o) {
		if(this.name.equals(o.name) && !(this.visited || o.visited))
			return 1;
		else
			return 0;
	}
}
