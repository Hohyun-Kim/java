package height_Order_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int gtCnt, ltCnt, cnt, N, M;
	static int[][] adj;
	static int[][] radj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine().trim()); // 학생 수
			M = Integer.parseInt(in.readLine().trim()); // 관계 수
			adj = new int[N+1][N+1]; // 인접행렬
			radj = new int[N+1][N+1]; // 역인접행렬 
			StringTokenizer st = null;
			int i, j;
			for(int m = 0; m < M; ++m) { // 관계정보 : 학생번호 1번부터 시작
				st = new StringTokenizer(in.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				radj[j][i] = adj[i][j] = 1; // i키 < j키를 인접행렬과 역인접행렬에 표현
			}
			int answer = 0;
			for(int k = 1; k<=N; ++k){
//				gtCnt = ltCnt = 0;
//				gtDFS(k, new boolean[N+1]);
//				ltDFS(k, new boolean[N+1]);
//				if(gtCnt + ltCnt == N-1) answer++;
				
				cnt = 0;
				boolean[] visited = new boolean[N+1];
				dfs(k, adj, visited);
				dfs(k, radj, visited);
				if(cnt == N-1) answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1 && !visited[i]) {
				gtCnt++;
				gtDFS(i, visited);
			}
		}
	}
	private static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[i][cur] == 1 && !visited[i]) {
				ltCnt++;
				ltDFS(i, visited);
			}
		}
	}
	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[i][cur] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}

}
