package shortestPath_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node {
		int vertex;
		int weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		Node[] Nodes = new Node[V+1];
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Nodes[from] = new Node(to, weight, Nodes[from]);
		}
		int[] minWeight = new int[V+1];
		boolean[] visited = new boolean[V+1];
		int min = 0;
		int stopOver = 0;
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		minWeight[K] = 0;
		for(int i = 0; i < V; i++) {
			stopOver = -1;
			min = INF;
			for(int j = 1; j < V+1; ++j) {
				if(!visited[j] && min > minWeight[j]) {
					min = minWeight[j];
					stopOver = j;
				}
			}
			if(stopOver == -1) break;
			
			visited[stopOver] = true;
			
			for(Node nextNode = Nodes[stopOver]; nextNode != null; nextNode = nextNode.next) {
				if(!visited[nextNode.vertex] && minWeight[nextNode.vertex] > min+nextNode.weight) {
					minWeight[nextNode.vertex] = min+nextNode.weight;
				}
			}
		}
		for(int i = 1; i < V+1; i++) {
			sb.append(minWeight[i] == INF? "INF":minWeight[i]).append("\n");
		}
		System.out.println(sb);
	}

}