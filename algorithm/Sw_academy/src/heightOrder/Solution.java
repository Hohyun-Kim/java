package heightOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node {
		int id;
		Node next;
		public Node(int id, Node next) {
			this.id = id;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			Node[] AdjList = new Node[N+1];
			Node[] AdjList_reverse = new Node[N+1];
			int[] know = new int[N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				AdjList[first] = new Node(second, AdjList[first]);
				AdjList_reverse[second] = new Node(first, AdjList_reverse[second]);
			}
			for(int i = 1; i < N+1; i++) {
				Node now = AdjList[i];
				int cnt_top = 0;
				int cnt_bottom = 0;
				while(now != null) {
					now = now.next;
				}
			}
			
			
		}
	}

}
