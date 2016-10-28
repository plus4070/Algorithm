package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	static final int INF = 400000;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int numOfEdges = scan.nextInt();
		int numOfStart = scan.nextInt();
		int startVertex, endVertex, weight;

		int[][] graph = new int[size][size];

		for (int i = 0; i < size; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int i = 0; i < numOfEdges; i++) {
			startVertex = scan.nextInt();
			endVertex = scan.nextInt();
			weight = scan.nextInt();

			graph[startVertex-1][endVertex-1] = weight;
		}

		findWays(graph, numOfStart);

		scan.close();
	}

	private static void findWays(int[][] graph, int numOfStart) {
		int size = graph.length;
		int[] dist = new int[size+1];
		boolean[] visited = new boolean[size+1];
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

		Arrays.fill(dist, INF);
		dist[numOfStart] = 0;
		queue.add(new Edge(1, 1, 0));
		
		while(!queue.isEmpty()) {
			Edge first = queue.remove();
			
			for(int i=0; i<size; i++) {
				if(graph[first.end-1][i] != INF && !visited[first.end]) {
					queue.add(new Edge(first.end, i+1, graph[first.end-1][i]));
				}
			}
			visited[first.end] = true;
			
			if(first.weight !=0) {
				dist[first.end] = Math.min(dist[first.end], dist[first.from]+graph[first.from-1][first.end-1]);
			}
		}
		
		for(int i=numOfStart; i<=size; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		private int from;
		private int end;
		private int weight;
		
		public Edge(int from, int end, int weight) {
			this.from = from;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (this.weight<o.weight)?-1:1;
		}
	}
}
