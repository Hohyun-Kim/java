package heightOrder_2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int id;
		Node next;
		public Node(int id, Node next) {
			this.id = id;
			this.next = next;
		}
	}
	static boolean[] visit;
	static int N, M;
	static int[] memo; 
	static int[] memo_reverse; 
	static Node[] AdjList;
	static Node[] AdjList_reverse;
	static int[][] AdjMatrix;
	static int[][] AdjMatrix_reverse;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		AdjList = new Node[N+1];
		AdjList_reverse = new Node[N+1];
		AdjMatrix = new int[N+1][N+1];
		memo = new int[N+1];
		memo_reverse = new int[N+1];
		Arrays.fill(memo, -1);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			AdjList[first] = new Node(second, AdjList[first]);
			AdjList_reverse[second] = new Node(first, AdjList_reverse[second]);
			AdjMatrix[first][second] = 1;
		}
		visit = new boolean[N+1];
		for(int i = 1; i < N+1; i++) {
			dfs(i);
		}
		for(int i = 1; i < N+1; i++) {
			int cnt = 0;
			boolean[] isCounted = new boolean[N+1];
			for (Node next = AdjList_reverse[i]; next != null; next = next.next) {
				if(!isCounted[next.id]) cnt++;
				isCounted[next.id] = true;
			}
			memo_reverse[i] = cnt;
		}
		int answer = 0;
		for(int i = 1; i < N+1; i++) {
			if(memo[i] + memo_reverse[i] == N-1) answer++;
		}
		System.out.println(answer);
	}
	
	static void dfs(int now_id) {
		for(Node next = AdjList[now_id]; next != null; next = next.next) {
			if(!visit[next.id]) {
				visit[next.id] = true;
				dfs(next.id);
			}
			for(Node nextOfNext = AdjList[next.id]; nextOfNext != null; nextOfNext = nextOfNext.next) {
				if(AdjMatrix[now_id][nextOfNext.id] == 1 ) continue;
				AdjList[now_id] = new Node(nextOfNext.id, AdjList[now_id]);
				AdjList_reverse[nextOfNext.id] = new Node(now_id, AdjList_reverse[nextOfNext.id]);
				AdjMatrix[now_id][nextOfNext.id] = 1;
			}
		}
		int cnt = 0;
		boolean[] isCounted = new boolean[N+1];
		for (Node next = AdjList[now_id]; next != null; next = next.next) {
			if(!isCounted[next.id]) {
				cnt++;
				isCounted[next.id] = true;
			}
		}
		memo[now_id] = cnt;
		return;
	}
}
